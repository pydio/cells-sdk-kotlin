package com.pydio.kotlin.sdk.api

import com.pydio.kotlin.openapi.model.TreeNode
import com.pydio.kotlin.sdk.api.ui.PageOptions
import com.pydio.kotlin.sdk.api.ui.WorkspaceNode
import com.pydio.kotlin.sdk.transport.StateID
import java.io.File
import java.io.OutputStream
import java.util.Properties

interface Client {

    @Throws(SDKException::class)
    fun getDefaultRegistry(): Registry?

    @Throws(SDKException::class)
    fun getUserRegistry(): Registry?

    @Throws(SDKException::class)
    fun stillAuthenticated(): Boolean

    @Throws(SDKException::class)
    fun getWorkspaceList(handler: (WorkspaceNode) -> Unit)

    @Throws(SDKException::class)
    fun ls(
        slug: String,
        path: String,
        options: PageOptions?,
        handler: (TreeNode) -> Unit
    ): PageOptions

    @Throws(SDKException::class)
    fun mkdir(ws: String, parent: String, name: String)

    @Throws(SDKException::class)
    fun delete(slug: String, paths: Array<String>, removePermanently: Boolean)

    @Throws(SDKException::class)
    fun statNode(stateID: StateID): TreeNode?

    /**
     * @return the filename If a thumbnail has been correctly downloaded or generated or null otherwise
     * @throws SDKException Wraps "known" exception with our error code and a local message to ease downstream management of the error.
     */
    @Throws(SDKException::class)
    fun getThumbnail(
        stateID: StateID,
        uuid: String,
        props: Properties,
        parentFolder: File,
        dim: Int
    ): String?

    @Throws(SDKException::class)
    fun download(
        ws: String,
        file: String,
        target: OutputStream,
        onProgress: ProgressListener?
    ): Long


    @Throws(SDKException::class)
    fun getNodeMeta(ws: String, file: String): TreeNode?

    @Throws(SDKException::class)
    fun search(ws: String, dir: String, searchedText: String, h: (TreeNode) -> Unit)

    @Throws(SDKException::class)
    fun copy(
        sources: List<StateID>,
        targetParent: StateID
    )

    @Throws(SDKException::class)
    fun move(sources: List<StateID>, targetParent: StateID)

    @Throws(SDKException::class)
    fun rename(ws: String, srcFile: String, newName: String)

    @Throws(SDKException::class)
    fun restore(ws: String, nodes: List<TreeNode>?)

    @Throws(SDKException::class)
    fun emptyRecycleBin(ws: String)

    @Throws(SDKException::class)
    fun bookmark(path: String, newState: Boolean)

    @Throws(SDKException::class)
    fun getBookmarks(h: (TreeNode) -> Unit)

    @Throws(SDKException::class)
    fun share(
        stateID: StateID,
        label: String,
        desc: String,
        password: String?,
        canPreview: Boolean,
        canDownload: Boolean
    ): String

    @Throws(SDKException::class)
    fun share(
        path: String,
        isFolder: Boolean,
        linkLabel: String,
        linkDesc: String,
        password: String?,
        expiration: Int,
        download: Int,
        canPreview: Boolean,
        canDownload: Boolean
    ): String

    fun unshare(workspace: String, shareUuid: String)

    fun getShareAddress(ws: String, shareID: String): String

}
