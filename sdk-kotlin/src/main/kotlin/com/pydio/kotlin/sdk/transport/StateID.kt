package com.pydio.kotlin.sdk.transport

import com.pydio.kotlin.sdk.api.ErrorCodes
import com.pydio.kotlin.sdk.api.SDKException
import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.utils.Log
import java.io.UnsupportedEncodingException
import java.net.URL
import java.net.URLDecoder
import java.net.URLEncoder

/**
 * Central object to ease manipulation of remote nodes by defining a unique ID
 * that relies on:
 * - the username for the current session
 * - the full URL of the distant server
 * - a path to a given node (including its containing workspace)
 */
class StateID {

    val username: String?
    val serverUrl: String
    val path: String?

    constructor(serverUrl: String) {
        username = null
        this.serverUrl = serverUrl
        path = null
    }

    constructor(username: String?, serverUrl: String) {
        this.username = username
        this.serverUrl = serverUrl
        path = null
    }

    constructor(username: String?, serverUrl: String, path: String?) {
        this.username = username
        this.serverUrl = serverUrl
        this.path = path
    }

    val id: String
        /**
         * Retrieves the *encoded* representation of this StateID for serialization.
         */
        get() {
            val builder = StringBuilder(accountId)
            if (!path.isNullOrEmpty() && "/" != path) {
                builder.append("@").append(utf8Encode(path))
            }
            return builder.toString()
        }

    val accountId: String
        get() {
            val builder = StringBuilder()
            username?.let {
                builder.append(utf8Encode(it)).append("@")
            }
            builder.append(utf8Encode(serverUrl))
            return builder.toString()
        }

    fun account(): StateID {
        return safeFromId(accountId)
    }

    val slug: String?
        get() {
            return getWorkspace(path)
        }

    val workspace: StateID?
        get() {
            return slug?.let {
                withPath("/$it")
            }
        }


    val serverHost: String
        /**
         * Best effort to provide a short host name from the URL. If the current url values raises
         * a malformed URL exception, we return the initial value.
         */
        get() = try {
            val url = URL(serverUrl)
            url.host
        } catch (e: Exception) {
            serverUrl
        }

    val workspaceStr: String?
        get() = getWorkspace(path)

    val file: String?
        /**
         * Returns the trailing part of the path without the workspace. Always starts with a slash when not null.
         */
        get() = getFile(path)

    val fileName: String?
        get() {
            val file = file
            return if (file == null || "/" == file) {
                null
            } else file.substring(file.lastIndexOf("/") + 1)
        }

    /* HELPER METHODS */

    /**
     * Creates a copy of this state ID and sets the passed path.
     * Warning: we assume parent StateID's username **and** serverUrl are already set.
     *
     * @param path a path including the workspace and starting with a slash
     * @return a valid StateID pointing to this path within the account defined by this username
     * and server URL
     */
    fun withPath(path: String): StateID {
        return StateID(username, serverUrl, path)
    }

    // TODO we have this kind of parent method twice, analyse and fix.
    fun workspace(): StateID? {
        return slug?.let {
            withPath("/$it")
        }
    }

    fun parent(): StateID {
        return if (getParentPath() == null) {
            // Corner case: parent of a workspace or a cell is the corresponding account
            StateID(username, serverUrl)
        } else StateID(username, serverUrl, getParentPath())
    }

    fun getParentPath(): String? {
        if (path == null || "/" == path) {
            return null
        }
        val parentPath = path.substring(0, path.lastIndexOf("/"))
        return if ("" == parentPath) {
            null
        } else parentPath
    }

    /**
     * Creates a copy of this state ID and sets the passed path.
     *
     *
     * Warning:
     * - we assume parent StateID's username **and** serverUrl are already set.
     * - passing null, an empty string or "/", we return this.
     * - passing a file name that contains a slash raises a runtime exception
     *
     * @return a valid StateID for a child of the current workspace or folder.
     */
    fun child(fileName: String?): StateID {
        if (fileName == null || "" == fileName || "/" == fileName) {
            return this
        }
        if (fileName.contains("/")) {
            throw RuntimeException("wrong filename: [$fileName], inner slash are forbidden")
        }
        val newPath: String = if (path == null) {
            Log.w(logTag, "Getting $fileName child for $this, path is null")
            "/$fileName"
        } else if (path.endsWith("/")) {
            path + fileName
        } else {
            "$path/$fileName"
        }
        return StateID(username, serverUrl, newPath)
    }

    fun parentFolder(): StateID {
        return if (parentFile == null) {
            // Corner case: parent of a workspace or a cell is the corresponding account
            StateID(username, serverUrl)
        } else StateID(username, serverUrl, "/$workspaceStr$parentFile")
    }

    val isWorkspaceRoot: Boolean
        get() = path?.let {
            it == "/$workspaceStr"
        } ?: run { false }

    val parentFile: String?
        get() {
            val file = file
            if (file == null || "/" == file) {
                return null
            }
            var parentFile = file.substring(0, file.lastIndexOf("/"))
            if ("" == parentFile) {
                parentFile = "/"
            }
            return parentFile
        }

    override fun toString(): String {
        val builder = StringBuilder()
        if (username != null) {
            builder.append(username).append("@")
        }
        builder.append(serverUrl)
        if (!path.isNullOrEmpty() && "/" != path) {
            builder.append(path)
        }
        return builder.toString()
    }

    companion object {
        private const val logTag = "StateID"
        val NONE = StateID(Transport.UNDEFINED_URL)

        /**
         * Simply creates a StateID object from its *encoded* string representation.
         *
         *
         * Supported combination are
         * - ServerURL only
         * - Username@ServerURL
         * - Username@ServerURL@Path
         */
        fun fromId(stateId: String?): StateID? {
            if (stateId.isNullOrEmpty()) {
                return null
            }
            var username: String? = null
            val host: String
            var path: String? = null
            val parts = stateId.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            when (parts.size) {
                1 -> host = utf8Decode(parts[0])
                2 -> {
                    username = utf8Decode(parts[0])
                    host = utf8Decode(parts[1])
                }

                3 -> {
                    username = utf8Decode(parts[0])
                    host = utf8Decode(parts[1])
                    path = utf8Decode(parts[2])
                }

                else -> {
//                    Log.e(logTag, "Could not create State from ID: $stateId")
                    return null
                }
            }
            return StateID(username, host, path)
        }

        fun safeFromId(stateId: String): StateID {
            if (stateId.isEmpty()) {
                throw IllegalArgumentException("Passed stateID cannot be empty")
            }

            var username: String? = null
            val host: String
            var path: String? = null
            val parts = stateId.split("@".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            when (parts.size) {
                1 -> host = utf8Decode(parts[0])
                2 -> {
                    username = utf8Decode(parts[0])
                    host = utf8Decode(parts[1])
                }

                3 -> {
                    username = utf8Decode(parts[0])
                    host = utf8Decode(parts[1])
                    path = utf8Decode(parts[2])
                }

                else -> {
                    throw IllegalArgumentException("Cannot parse: $stateId (found ${parts.size} parts)")
                }
            }
            return StateID(username, host, path)
        }

        // TODO find a elegant way to rather inject the CustomEncoder.
        //   Not perfect: Might have side effects when switching from plain Java to Android
        fun utf8Encode(value: String): String {
            return try {
                URLEncoder.encode(value, "UTF-8")
            } catch (e: UnsupportedEncodingException) {
                throw RuntimeException("Unexpected encoding issue", e)
            }
        }

        fun utf8Decode(value: String): String {
            return try {
                URLDecoder.decode(value, "UTF-8")
            } catch (e: UnsupportedEncodingException) {
                throw RuntimeException("Unexpected decoding issue", e)
            }
        }

        @Throws(SDKException::class)
        fun toTreeNodePath(stateID: StateID): String {
            val path = if (stateID.slug.isNullOrEmpty()) {
                throw SDKException(
                    ErrorCodes.illegal_argument,
                    "cannot stat at $stateID, define a WS"
                )
            } else if (stateID.file.isNullOrEmpty()) {
                "${stateID.slug}/"
            } else {
                "${stateID.slug}/${stateID.file}"
            }

            return path
        }

        fun withSlug(slug: String, path: String): String {
            return slug + path
        }
    }
}

fun getWorkspace(path: String?): String? {
    return if (path == null || "" == path || "/" == path) {
        null
    } else path.substring(1).split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
}

fun getFile(path: String?): String? {
    if (path == null || "" == path) { // || "/".equals(path)) {
        return null
    }
    val prefix = "/" + getWorkspace(path)
    if (path.length > prefix.length) {
        return path.substring(prefix.length)
    } else if (path.length == prefix.length) {
        // we only have the workspace, so we consider we are at root of the workspace
        return "/"
    }
    return null
}

fun getPath(ws: String, file: String?): String? {
    var path: String? = "/$ws"
    if (!file.isNullOrEmpty()) {
        path += file
    }
    return path
}
