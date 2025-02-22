package com.pydio.kotlin.sdk.client

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pydio.kotlin.openapi.api.JobsServiceApi
import com.pydio.kotlin.openapi.api.SearchServiceApi
import com.pydio.kotlin.openapi.api.ShareServiceApi
import com.pydio.kotlin.openapi.api.TreeServiceApi
import com.pydio.kotlin.openapi.api.UserMetaServiceApi
import com.pydio.kotlin.openapi.api.UserServiceApi
import com.pydio.kotlin.openapi.infrastructure.ClientException
import com.pydio.kotlin.openapi.infrastructure.ServerException
import com.pydio.kotlin.openapi.model.IdmSearchUserMetaRequest
import com.pydio.kotlin.openapi.model.IdmUpdateUserMetaRequest
import com.pydio.kotlin.openapi.model.IdmUserMeta
import com.pydio.kotlin.openapi.model.RestBulkMetaResponse
import com.pydio.kotlin.openapi.model.RestCreateNodesRequest
import com.pydio.kotlin.openapi.model.RestDeleteNodesRequest
import com.pydio.kotlin.openapi.model.RestGetBulkMetaRequest
import com.pydio.kotlin.openapi.model.RestPutShareLinkRequest
import com.pydio.kotlin.openapi.model.RestRestoreNodesRequest
import com.pydio.kotlin.openapi.model.RestSearchResults
import com.pydio.kotlin.openapi.model.RestShareLink
import com.pydio.kotlin.openapi.model.RestShareLinkAccessType
import com.pydio.kotlin.openapi.model.RestUserBookmarksRequest
import com.pydio.kotlin.openapi.model.RestUserJobRequest
import com.pydio.kotlin.openapi.model.ServiceResourcePolicy
import com.pydio.kotlin.openapi.model.ServiceResourcePolicyAction
import com.pydio.kotlin.openapi.model.TreeNode
import com.pydio.kotlin.openapi.model.TreeNodeType
import com.pydio.kotlin.openapi.model.TreeQuery
import com.pydio.kotlin.openapi.model.TreeSearchRequest
import com.pydio.kotlin.openapi.model.UpdateUserMetaRequestUserMetaOp
import com.pydio.kotlin.sdk.api.Client
import com.pydio.kotlin.sdk.api.ErrorCodes
import com.pydio.kotlin.sdk.api.ProgressListener
import com.pydio.kotlin.sdk.api.Registry
import com.pydio.kotlin.sdk.api.S3Client
import com.pydio.kotlin.sdk.api.S3Names
import com.pydio.kotlin.sdk.api.SDKException
import com.pydio.kotlin.sdk.api.SdkNames
import com.pydio.kotlin.sdk.api.ServerURL
import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.api.ui.PageOptions
import com.pydio.kotlin.sdk.api.ui.WorkspaceNode
import com.pydio.kotlin.sdk.client.model.DocumentRegistry
import com.pydio.kotlin.sdk.transport.CellsTransport
import com.pydio.kotlin.sdk.transport.StateID
import com.pydio.kotlin.sdk.utils.IoHelpers
import com.pydio.kotlin.sdk.utils.Log
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.xml.sax.SAXException
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.util.Properties
import javax.xml.parsers.ParserConfigurationException


class CellsClient(transport: Transport, private val s3Client: S3Client) : Client, SdkNames {

    private val logTag = "CellsClient"

    private val transport: CellsTransport = transport as CellsTransport
    private val gson = Gson()

    private fun userServiceApi(): UserServiceApi {
        val (u, c) = transport.apiConf()
        return UserServiceApi(u, c)
    }

    private fun userMetaServiceApi(): UserMetaServiceApi {
        val (u, c) = transport.apiConf()
        return UserMetaServiceApi(u, c)
    }

    private fun treeServiceApi(): TreeServiceApi {
        val (u, c) = transport.apiConf()
        return TreeServiceApi(u, c)
    }

    private fun jobsServiceApi(): JobsServiceApi {
        val (u, c) = transport.apiConf()
        return JobsServiceApi(u, c)
    }

    private fun searchServiceApi(): SearchServiceApi {
        val (u, c) = transport.apiConf()
        return SearchServiceApi(u, c)
    }

    private fun shareServiceApi(): ShareServiceApi {
        val (u, c) = transport.apiConf()
        return ShareServiceApi(u, c)
    }

    @Throws(SDKException::class)
    override fun stillAuthenticated(): Boolean {
        return try {
            userServiceApi().getUser(transport.username)
            true
        } catch (e: ClientException) {
            Log.e(
                logTag,
                "SDK error #" + e.statusCode + " while checking auth state for " + StateID.fromId(
                    transport.id
                )
            )
            false
        } catch (e: SDKException) {
            Log.w(logTag, "${e.code} (${e.message}) when checking auth for ${transport.stateID}")
            false
        } catch (e: ServerException) {
            Log.e(logTag, "API error while checking auth state for " + StateID.fromId(transport.id))
            e.printStackTrace()
            if (e.statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                return false
            }
            throw SDKException.fromServerException(e)
        }
    }

    override fun getDefaultRegistry(): Registry? {
        return null
    }

    override fun getUserRegistry(): Registry? {
        return null
    }

    @Throws(SDKException::class)
    override fun getWorkspaceList(handler: (WorkspaceNode) -> Unit) {
        var con: HttpURLConnection? = null
        var input: InputStream? = null
        val registry: Registry
        try {
            con = transport.openApiConnection("/frontend/state")
            con.requestMethod = "GET"
            input = con.inputStream
            val responseCode = con.responseCode
            if (responseCode != 200) {
                val msg = "could not get registry for " + transport.id + "(" + responseCode + ")"
                throw SDKException.conFailed(msg, IOException(con.responseMessage))
            }
            registry = DocumentRegistry(input)
            if (!registry.isLoggedIn()) {
                // TODO Double check if we are correctly connected
                throw SDKException(
                    ErrorCodes.authentication_required,
                    "not logged in " + transport.id + ", you cannot list workspaces."
                )
            }
            for (node in registry.getWorkspaces()) {
                handler(node)
                // TODO check if we have to skip some of the workspaces at this point
//                if (!Arrays.asList<Any>(defaultExcludedWorkspaces).contains(node.accessType)) {
//                    handler.onNode(node)
//                }
            }
        } catch (e: ParserConfigurationException) {
            throw SDKException.unexpectedContent(e)
        } catch (e: SAXException) {
            throw SDKException.unexpectedContent(e)
        } catch (e: IOException) {
            throw SDKException.conFailed("could not get registry for " + transport.id, e)
        } finally {
            IoHelpers.closeQuietly(input)
            IoHelpers.closeQuietly(con)
        }
    }

    @Throws(SDKException::class)
    override fun ls(
        slug: String, path: String, options: PageOptions?, handler: (TreeNode) -> Unit
    ): PageOptions {
        val request = RestGetBulkMetaRequest(
            nodePaths = listOf(
                StateID.withSlug(
                    slug, if ("/" == path) "/*" else "$path/*"
                )
            ),
            allMetaProviders = true,
            limit = options?.limit,
            offset = options?.offset,
        )
        val response: RestBulkMetaResponse
        // var nextPageOptions: PageOptions
        try {
            response = treeServiceApi().bulkStatNodes(request)
            val nextPageOptions = response.pagination?.let { pag ->
                PageOptions(
                    limit = pag.limit ?: 0,
                    offset = pag.nextOffset ?: -1,
                    total = pag.total ?: 0,
                    currentPage = pag.currentPage ?: 0,
                    totalPages = pag.totalPages ?: 0
                )
            } ?: run {
                val size = response.nodes?.size ?: 0
                PageOptions(
                    limit = size, offset = 0, total = size, currentPage = 1, totalPages = 1
                )
            }

            response.nodes?.let { nodes ->
                nodes.forEach { handler(it) }
            }
            return nextPageOptions

        } catch (e: ClientException) {
            val msg = "Could not list: " + e.message
            throw SDKException(e.statusCode, msg, e)
        } catch (e: ServerException) {
            val msg = "Could not list: " + e.message
            throw SDKException(e.statusCode, msg, e)
        }
    }

    @Throws(SDKException::class)
    override fun mkdir(ws: String, parent: String, name: String) {
        val node = TreeNode(
            path = "$ws$parent/$name".replace("//", "/"), type = TreeNodeType.COLLECTION
        )

        val request = RestCreateNodesRequest(
            recursive = false, nodes = listOf(node)
        )

        try {
            treeServiceApi().createNodes(request)
        } catch (e: ServerException) {
            e.printStackTrace()
            throw SDKException.fromServerException(e)
        }
    }

    @Throws(SDKException::class)
    override fun delete(slug: String, paths: Array<String>, removePermanently: Boolean) {
        val nodes = paths.map { TreeNode(path = StateID.withSlug(slug, it)) }
        val request = RestDeleteNodesRequest(nodes = nodes, removePermanently = removePermanently)
        try {
            treeServiceApi().deleteNodes(request)
        } catch (e: ServerException) {
            throw SDKException.fromServerException(e)
        }
    }

    @Throws(SDKException::class)
    override fun statNode(stateID: StateID): TreeNode? {
        val path = if (stateID.slug.isNullOrEmpty()) {
            throw SDKException(ErrorCodes.illegal_argument, "cannot stat at $stateID, define a WS")
        } else if (stateID.file.isNullOrEmpty()) {
            "${stateID.slug}"
        } else {
            "${stateID.slug}/${stateID.file}"
        }
        try {
            val response = treeServiceApi().headNode(path)
            return response.node
        } catch (e: ServerException) {
            throw SDKException.fromServerException(e)
        } catch (e: ClientException) {
            throw SDKException.fromClientException(e)
        } catch (e: Exception) {
            Log.e(logTag, "unexpected error when doing stat node for [$path]")
            e.printStackTrace()
            throw SDKException(ErrorCodes.internal_error, "Cannot stat $path", e)
        }
    }

    @Throws(SDKException::class)
    override fun getThumbnail(
        stateID: StateID, uuid: String, props: Properties, parentFolder: File, dim: Int
    ): String? {

        val filename = getThumbFilename(uuid, props, dim)
        if (filename.isNullOrEmpty()) {
            Log.w(logTag, "No thumbnail is defined for $stateID")
            return null
        }
        var out: OutputStream? = null
        try {
            if (!parentFolder.exists()) {
                if (!parentFolder.mkdirs()) {
                    throw SDKException(
                        ErrorCodes.internal_error,
                        "could not create folder for thumbs at " + parentFolder.absolutePath
                    )
                }
            }
            val targetFile = File(parentFolder.absolutePath + File.separator + filename)
            out = FileOutputStream(targetFile)
            // Download API expect a full path starting with a slash (a.k.a a file, not a filename)
            val file = "/$filename"
            download(S3Names.PYDIO_S3_THUMBSTORE_PREFIX, file, out, null)
        } catch (e: IOException) {
            throw SDKException.conReadFailed("could not get thumb for $stateID", e)
        } finally {
            IoHelpers.closeQuietly(out)
        }
        return filename
    }

    /**
     * Warning, this expect a file (with a leading slash), not a file name
     */
    @Throws(SDKException::class)
    override fun download(
        ws: String, file: String, target: OutputStream, progressListener: ProgressListener?
    ): Long {
        var input: InputStream? = null
        return try {
            val preSignedURL = s3Client.getDownloadPreSignedURL(ws, file)
            val serverUrl = try {
                transport.server.newURL(preSignedURL.path).withQuery(preSignedURL.query)
            } catch (e: MalformedURLException) { // This should never happen with a pre-signed.
                throw SDKException(
                    ErrorCodes.internal_error, "Invalid pre-signed path: " + preSignedURL.path, e
                )
            }
            val con = transport.withUserAgent(serverUrl.openConnection())
            con.connect()
            input = con.inputStream

            progressListener?.let {
                IoHelpers.pipeReadWithIncrementalProgress(input, target, it)
            } ?: run {
                IoHelpers.pipeRead(input, target)
            }

        } catch (e: IOException) {
            if (e.message!!.contains("ENOSPC")) { // no space left on device
                throw SDKException.noSpaceLeft(e)
            }
            throw SDKException.conReadFailed("could not download from $ws$file", e)
        } finally {
            IoHelpers.closeQuietly(input)
        }
    }

    /*
     * If no thumb is defined or if it is currently processing, we return null.
     * If we find only one thumb, we choose this one. Otherwise we return the smaller thumb that has at least required size.
     *
     * Thumb names follow a tacit standard that is: <node_uuid>-<size>.<type>
     * @param currNode
     * @param dim
     * @return
     * @throws SDKException
     */
    @Throws(SDKException::class)
    private fun getThumbFilename(uid: String, meta: Properties, dim: Int): String? {
        var thumbName: String? = null

        val imgThumbsStr = meta[SdkNames.META_KEY_THUMB_PARENT] as? String ?: return null

        // TODO centralize this
        val objType = object : TypeToken<Map<String, Any>>() {}.type
        val thumbData: Map<String, *> = gson.fromJson(imgThumbsStr, objType)
        if (thumbData.containsKey(SdkNames.META_KEY_THUMB_PROCESSING) && !(thumbData[SdkNames.META_KEY_THUMB_PROCESSING] as Boolean) && thumbData.containsKey(
                SdkNames.META_KEY_THUMBS
            )
        ) {
            val rawData = thumbData[SdkNames.META_KEY_THUMBS]
            val thumbs = if (rawData is List<*>) {
                rawData.filterIsInstance<Map<String, Any>>() as? ArrayList<Map<String, Any>>
            } else {
                null
            }
            thumbs?.let {
                for (currThumb in it) {
                    val size = (currThumb[SdkNames.META_KEY_THUMB_SIZE] as? Double)?.toInt() ?: 0
                    val format = currThumb[SdkNames.META_KEY_THUMB_FORMAT] as? String ?: "jpg"
                    val currName = "$uid-$size.$format"
                    if (thumbName == null) {
                        thumbName = currName
                    }
                    if (size > 0 && size >= dim) {
                        thumbName = currName
                        break
                    }
                }
            }
        }
        return thumbName
    }

    @Throws(SDKException::class)
    override fun getNodeMeta(ws: String, file: String): TreeNode? {
        val request = RestGetBulkMetaRequest(
            allMetaProviders = true, nodePaths = listOf(StateID.withSlug(ws, file))
        )
        val response: RestBulkMetaResponse = try {
            treeServiceApi().bulkStatNodes(request)
        } catch (e: ClientException) {
            e.printStackTrace()
            throw SDKException(e)
        }
        if (response.nodes.isNullOrEmpty()) {
            Log.w(logTag, "No node found for " + StateID.withSlug(ws, file))
            return null
        }
        return response.nodes?.let { it[0] }
    }

    @Throws(SDKException::class)
    override fun search(ws: String, dir: String, searchedText: String, h: (TreeNode) -> Unit) {
        val query = TreeQuery(
            fileName = searchedText, pathPrefix = listOf(ws + dir)
        )
        val request = TreeSearchRequest(
            propertySize = 50, query = query
        )
        val results: RestSearchResults = try {
            searchServiceApi().nodes(request)
        } catch (e: ClientException) {
            throw SDKException(e)
        }
        val nodes = results.results
        if (nodes != null) {
            for (treeNode in nodes) {
                h(treeNode)
            }
        }
    }

    //
//    @Throws(SDKException::class)
//    override fun search(parentPath: String, searchedText: String, size: Int): List<FileNode> {
//        return try {
//            Log.d(logTag, " ... About to list nodes for [$searchedText] at $parentPath")
//            val query = TreeQuery()
//            query.setFileName(searchedText)
//            query.addPathPrefixItem(parentPath)
//            val request = TreeSearchRequest()
//            request.setSize(size)
//            request.setQuery(query)
//            val api = SearchServiceApi(authenticatedClient())
//            val (_, treeNodes) = api.nodes(request)
//            val fileNodes: MutableList<FileNode> = ArrayList()
//            if (treeNodes == null) {
//                Log.w(logTag, " .. Found no node for [$searchedText] at $parentPath")
//                return fileNodes
//            }
//            Log.d(
//                logTag, " .. Found " + treeNodes.size
//                        + " nodes for [" + searchedText + "] at " + parentPath
//            )
//            for (node in treeNodes) {
//                // FIXME this won't work, the workspace does not set the appearsIn variable in Search request results
////                toMultipleNode(fileNodes, node);
//                val fileNode = FileNodeUtils.toFileNode(node)
//                if (fileNode != null) {
//                    fileNodes.add(fileNode)
//                }
//            }
//            // Log.d(logTag, " .. After to multiple: " + fileNodes.size());
//            fileNodes
//        } catch (e: ApiException) {
//            throw SDKException.fromApiException(e)
//        }
//    }
//

    @Throws(SDKException::class)
    fun upload(
        source: InputStream,
        length: Long,
        mime: String,
        ws: String,
        path: String,
        name: String,
        autoRename: Boolean,
        progressListener: ProgressListener
    ) {
        val preSignedURL = s3Client.getUploadPreSignedURL(ws, path, name)
        val serverUrl: ServerURL
        serverUrl = try {
            transport.server.newURL(preSignedURL.path).withQuery(preSignedURL.query)
        } catch (e: MalformedURLException) { // This should never happen with a pre-signed.
            throw SDKException(
                ErrorCodes.internal_error,
                "Invalid pre-signed path: " + preSignedURL.path,
                e
            )
        }
        try {
            val con = transport.withUserAgent(serverUrl.openConnection())
            con.requestMethod = "PUT"
            con.doOutput = true
            con.setRequestProperty("Content-Type", "application/octet-stream")
            con.setFixedLengthStreamingMode(length)
            con.outputStream.use { out ->
                try {
                    IoHelpers.pipeReadWithIncrementalProgress(source, out, progressListener)
                } catch (se: SDKException) {
                    if (SDKException.isCancellation(se)) {
                        IoHelpers.closeQuietly(out)
                    }
                    throw se
                }
            }
            // TODO implement multi part upload
            Log.d(logTag, "PUT request done with status " + con.responseCode)
        } catch (e: IOException) {
            throw SDKException.conWriteFailed("Cannot write to server", e)
        }
        // return Message.create(Message.SUCCESS, "SUCCESS");
    }

    //
//    @Throws(SDKException::class)
//    override fun upload(
//        source: File,
//        mime: String,
//        ws: String,
//        path: String,
//        name: String,
//        autoRename: Boolean,
//        progressListener: ProgressListener
//    ) {
//        upload(source, mime, ws, path, name, progressListener)
//    }
//
//    @Deprecated("")
//    override fun uploadURL(ws: String, folder: String, name: String, autoRename: Boolean): String {
//        throw RuntimeException("Unsupported method for cells client")
//    }
//
//
//    @Throws(SDKException::class)
//    override fun download(
//        ws: String,
//        file: String,
//        target: File,
//        progressListener: ProgressListener
//    ): Long {
//        var totalRead: Long = -1
//        var dlException: SDKException? = null
//        try {
//            FileOutputStream(target).use { out ->
//                totalRead = download(ws, file, out, progressListener)
//            }
//        } catch (e: FileNotFoundException) {
//            dlException = SDKException.notFound(e)
//        } catch (e: IOException) {
//            dlException = SDKException.conReadFailed("Could not download file $file", e)
//        } catch (e: SDKException) {
//            dlException =
//                SDKException(ErrorCodes.api_error, "Could not download file $file from $ws", e)
//        } finally {
//            if (dlException != null) {
//                // Best effort to download non-complete
//                try {
//                    target.delete()
//                } catch (e: Exception) {
//                    Log.w("Local", "Could not delete file at $target after failed download")
//                }
//                throw dlException
//            }
//        }
//        return totalRead
//    }
//
//    @Throws(SDKException::class)
//    override fun downloadPath(ws: String, file: String): String {
//        return fromURL(s3Client.getDownloadPreSignedURL(ws, file))
//    }
//
    @Throws(SDKException::class)
    override fun copy(
        sources: List<StateID>, targetParent: StateID
    ) {
        val nodes = mutableListOf<String>()
        sources.forEach { nodes.add(it.path!!) }
        val params = mutableMapOf<String, Any>()
        params["nodes"] = nodes.toTypedArray()
        params["target"] = targetParent.path!!
        params["targetParent"] = true
        val request = RestUserJobRequest(jsonParameters = gson.toJson(params))
        try {
            jobsServiceApi().userCreateJob(SdkNames.JOB_ID_COPY, request)
        } catch (e: ClientException) {
            throw SDKException(e)
        }
    }

    @Throws(SDKException::class)
    override fun move(
        sources: List<StateID>, targetParent: StateID
    ) {
        val nodes = mutableListOf<String>()
        for (source in sources) {
            nodes.add(source.path!!)
        }
        val param = mutableMapOf<String, Any>()
        param["nodes"] = nodes.toTypedArray()
        param["target"] = targetParent.path!!
        param["targetParent"] = true
        val request = RestUserJobRequest(jsonParameters = gson.toJson(param))
        try {
            jobsServiceApi().userCreateJob(SdkNames.JOB_ID_MOVE, request)
        } catch (e: ClientException) {
            throw SDKException(e)
        }
    }

    @Throws(SDKException::class)
    override fun rename(ws: String, srcFile: String, newName: String) {
        val nodes = listOf(ws + srcFile)
        val parent = File(srcFile).parentFile.path
        val dstFile = if ("/" == parent) {
            parent + newName
        } else {
            "$parent/$newName"
        }
        val targetFile = ws + dstFile
        val o = mutableMapOf<String, Any>()
        o["nodes"] = nodes.toTypedArray()
        o["target"] = targetFile
        o["targetParent"] = false
        val request = RestUserJobRequest(
            jsonParameters = gson.toJson(o)
        )

        try {
            jobsServiceApi().userCreateJob(SdkNames.JOB_ID_MOVE, request)
        } catch (e: ClientException) {
            e.printStackTrace()
            throw SDKException(e)
        }
    }

    /**
     * val nodes: MutableList<TreeNode> = ArrayList()
     *         for (file in files) {
     *             val node: TreeNode = TreeNode(
     *                 uuid = ,
     *                 path = ,
     *             ).uuid(file.id).path(file.path)
     *             nodes.add(node)
     *         }
     */
    @Throws(SDKException::class)
    override fun restore(ws: String, nodes: List<TreeNode>?) {
        val request = RestRestoreNodesRequest(
            nodes = nodes
        )
        try {
            treeServiceApi().restoreNodes(request)
        } catch (e: ClientException) {
            e.printStackTrace()
            throw SDKException(e)
        }
    }

    @Throws(SDKException::class)
    override fun emptyRecycleBin(ws: String) {
        delete(ws, arrayOf("/recycle_bin"), true)
    }
//
//    @Throws(SDKException::class)
//    override fun streamingAudioURL(slug: String, file: String): String {
//        return fromURL(s3Client.getStreamingPreSignedURL(slug, file, S3Names.S3_CONTENT_TYPE_MP3))
//    }
//
//    @Throws(SDKException::class)
//    override fun streamingVideoURL(slug: String, file: String): String {
//        return fromURL(s3Client.getStreamingPreSignedURL(slug, file, S3Names.S3_CONTENT_TYPE_MP4))
//    }
//

    @Throws(SDKException::class)
    override fun getBookmarks(h: (TreeNode) -> Unit) {
        val request = RestUserBookmarksRequest()
        try {
            val (nodes) = userMetaServiceApi().userBookmarks(request)
            if (nodes == null) {
                return
            }
            for (node in nodes) {
                toMultipleNode(h, node)
            }
        } catch (e: ClientException) {
            e.printStackTrace()
            throw SDKException(e)
        }
    }

    private fun toMultipleNode(h: (TreeNode) -> Unit, node: TreeNode) {
        try {
            val sources = node.appearsIn
            if (sources != null) {
                // A node can appear in various workspaces (typically when referenced in a cell)
                // Yet the server sends back only one node with the specific "appears in" property,
                // We then have to return a node for each bookmark to the local cache
                for (workspace in sources) {
                    var path = workspace.path
                    if (path.isNullOrEmpty()) {
                        Log.w(
                            logTag,
                            "Got an empty path in 'appearsIn' list of node at ${node.path}"
                        )
                        path = "/"
                    } else if (!path.startsWith("/")) {
                        path = "/$path"
                    }
// FIXME this has been broken when moving to kotlin
//                        fileNode.setProperty(SdkNames.NODE_PROPERTY_WORKSPACE_SLUG, workspace.wsSlug)
//                        fileNode.setProperty(SdkNames.NODE_PROPERTY_PATH, path)
//                        fileNode.setProperty(
//                            SdkNames.NODE_PROPERTY_FILENAME,
//                            FileNodeUtils.getNameFromPath(path)
//                        )
                    h(node)
                }
            }
        } catch (e: NullPointerException) {
            Log.e(logTag, "###############################################################")
            Log.e(logTag, "Could node create FileNode for " + node.path + ", skipping")
            e.printStackTrace()
        }
    }

    @Throws(SDKException::class)
    override fun bookmark(path: String, newState: Boolean) {
        if (newState) {
            doBookmark(getNodeUuid(path))
        } else {
            unBookmark(path)
        }
    }

    @Throws(SDKException::class)
    private fun doBookmark(uuid: String?) {

        val userMeta = IdmUserMeta(
            nodeUuid = uuid, namespace = "bookmark", jsonValue = "true", policies = listOf(
                ServiceResourcePolicy(action = ServiceResourcePolicyAction.READ),
                ServiceResourcePolicy(action = ServiceResourcePolicyAction.WRITE),
                ServiceResourcePolicy(action = ServiceResourcePolicyAction.OWNER),
            )
        )

        val request = IdmUpdateUserMetaRequest(
            operation = UpdateUserMetaRequestUserMetaOp.PUT, metaDatas = listOf(userMeta)
        )
        try {
            userMetaServiceApi().updateUserMeta(request)
        } catch (e: ClientException) {
            e.printStackTrace()
            throw SDKException(
                ErrorCodes.api_error,
                "could not update bookmark user-meta for uuid $uuid: " + e.message,
                e
            )
        }
    }

    @Throws(SDKException::class)
    fun unBookmark(path: String) {
        try {
            val api = userMetaServiceApi()
            getNodeUuid(path)?.let { listOf(it) }

            // Retrieve bookmark user meta with node UUID
            val searchRequest = IdmSearchUserMetaRequest(namespace = "bookmark",
                nodeUuids = getNodeUuid(path)?.let { listOf(it) })

            // Delete corresponding user meta
            val (userMetas: List<IdmUserMeta>?) = api.searchUserMeta(searchRequest)
            val request = IdmUpdateUserMetaRequest(
                operation = UpdateUserMetaRequestUserMetaOp.DELETE, metaDatas = userMetas
            )
            api.updateUserMeta(request)
        } catch (e: ClientException) {
            throw SDKException(e)
        }
    }

    @Throws(SDKException::class)
    override fun share(
        path: String,
        isFolder: Boolean,
        linkLabel: String,
        linkDesc: String,
        password: String?,
        expiration: Int,
        download: Int,
        canPreview: Boolean,
        canDownload: Boolean
    ): String {
        val uuid = getNodeUuid(path)
            ?: run { throw SDKException("Cannot share, no UUID found for node at $path") }
        val n = TreeNode(uuid = uuid)
        val permissions: MutableList<RestShareLinkAccessType> = ArrayList()
        if (canPreview) {
            permissions.add(RestShareLinkAccessType.Preview)
        }
        if (canDownload) {
            permissions.add(RestShareLinkAccessType.Download)
        }
        val sl = RestShareLink(
            policiesContextEditable = true,
            permissions = permissions,
            rootNodes = listOf(n),
            description = linkDesc,
            label = linkLabel,
            viewTemplateName = SdkNames.SHARE_TEMPLATE_GALLERY
        )

        val request = RestPutShareLinkRequest(
            createPassword = password,
            passwordEnabled = !password.isNullOrEmpty(),
            shareLink = sl,
        )

        return try {
            val restShareLink = shareServiceApi().putShareLink(request)
            transport.server.url() + restShareLink.linkUrl
        } catch (e: ClientException) {
            throw SDKException.fromClientException(e)
        }
    }

    @Throws(SDKException::class)
    override fun share(
        stateID: StateID,
        label: String,
        desc: String,
        password: String?,
        canPreview: Boolean,
        canDownload: Boolean
    ): String {

        val targetRemote = statNode(stateID)
            ?: throw SDKException("Cannot share node $stateID: it has disappeared on remote")
        val meta: Map<String, String> = targetRemote.metaStore ?: HashMap()
        val templateName = if ("true" == meta["is_image"]) {
            SdkNames.SHARE_TEMPLATE_GALLERY
        } else {
            SdkNames.SHARE_TEMPLATE_FOLDER_LIST
        }
        val permissions: MutableList<RestShareLinkAccessType> = ArrayList()
        if (canPreview) {
            permissions.add(RestShareLinkAccessType.Preview)
        }
        if (canDownload) {
            permissions.add(RestShareLinkAccessType.Download)
        }

        val n = TreeNode(uuid = getNodeUuid(stateID))
        val shareLink = RestShareLink(
            policiesContextEditable = true,
            permissions = permissions,
            rootNodes = listOf(n),
            description = desc,
            label = label,
//            viewTemplateName = "pydio_unique_strip"
            viewTemplateName = templateName
        )

        val hasPwd = !password.isNullOrEmpty()
        val request = RestPutShareLinkRequest(
            createPassword = if (hasPwd) password else null,
            passwordEnabled = hasPwd,
            shareLink = shareLink
        )

        return try {
            val (_, _, _, _, _, _, linkUrl) = shareServiceApi().putShareLink(request)
            transport.server.url() + linkUrl
        } catch (e: ClientException) {
            throw SDKException.fromClientException(e)
        }
    }

    @Throws(SDKException::class)
    override fun unshare(workspace: String, shareUuid: String) {
        try {
            shareServiceApi().deleteShareLink(shareUuid)
        } catch (e: ClientException) {
            throw SDKException.fromClientException(e)
        }
    }

    @Throws(SDKException::class)
    override fun getShareAddress(ws: String, shareID: String): String {
        return try {
            val (_, _, _, _, _, _, linkUrl) = shareServiceApi().getShareLink(shareID)
            getFullLinkAddress(linkUrl, transport.server.url())
        } catch (e: ClientException) {
            throw SDKException.fromClientException(e)
        }
    }

    @Throws(SDKException::class)
    private fun getFullLinkAddress(linkUrl: String?, defaultPrefix: String): String {
        // TODO make this robuster after finding how it is used.
        val httpUrl = linkUrl?.toHttpUrlOrNull() ?: (defaultPrefix + linkUrl).toHttpUrlOrNull()
        return httpUrl.toString()


        //    return try {
//
        //        val httpUrl = linkUrl?.toHttpUrlOrNull() ?: (            defaultPrefix + linkUrl).toHttpUrlOrNull()
        //        return
//
        //         HttpUrl.Companion.Builder().build()
//
        //        // FIX ME we should not use java.net package
        //        val url = URL(linkUrl)
        //        // Passed URL is valid we directly use this
        //        url.toString()
        //    } catch (e: MalformedURLException) {
        //        if (!linkUrl!!.startsWith("/")) {
        //            // Log.e(logTag, "Could not parse link URL: [" + linkUrl + "]");
        //            throw SDKException(
        //                ErrorCodes.unexpected_response, "Public link [$linkUrl] is not valid", e
        //            )
        //        }
        //        defaultPrefix + linkUrl
        //    }
    }

    @Throws(SDKException::class)
    private fun getNodeUuid(path: String): String? {
        return try {
            treeServiceApi().headNode(path).node?.uuid
        } catch (e: ClientException) {
            throw SDKException("Cannot get UUID for $path", e)
        }
    }

    @Throws(SDKException::class)
    private fun getNodeUuid(stateID: StateID): String? {
        return try {
            treeServiceApi().headNode(StateID.toTreeNodePath(stateID)).node?.uuid
        } catch (e: ClientException) {
            throw SDKException("Cannot get UUID for $stateID", e)
        }
    }

}
