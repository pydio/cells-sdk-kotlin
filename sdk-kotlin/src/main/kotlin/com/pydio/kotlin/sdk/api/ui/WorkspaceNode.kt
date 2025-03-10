package com.pydio.kotlin.sdk.api.ui

import java.util.Properties

/**
 * Simply used to de-serialize the registry that is used to get workspaces.
 *
 * Warning: for comparison and equality, we assume that the workspaces are **in the same** server
 * and only rely on their respective slug: the workspaces don't hold a reference to their hosting server.
 */
class WorkspaceNode(
    // TODO this is still not persisted in the DB
    //   We must also remove thumb column
    val uuid: String,
    val slug: String,
    var label: String?,
    val description: String?,
    val type: String,
    val path: String = "/",
    // TODO we never get this info from the cells server
    val lastModified: Long = 0,
    // TODO This is also missing in the DB
    val props: Properties
) : Comparable<WorkspaceNode> {

    override fun equals(other: Any?): Boolean {
        // we rely on the workspace slug that is unique by construction
        if (this === other) return true
        return if (other !is WorkspaceNode) false else slug == other.slug
    }

    override fun hashCode(): Int {
        return slug.hashCode()
    }


    // TODO we also used to handle these properties
    //        we skipped them when moving to kotlin only...
//        val id = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_ID)
//        val acl = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_ACL)
//        val owner = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_OWNER)
//        val crossCopy = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_CROSS_COPY)
//        val accessType = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_ACCESS_TYPE)
//        val metaSync = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_META_SYNC)


    /**
     * This is only used for diffs, for UI sorting we rather rely on the sort_name that is added
     * to the RWorkspace object upon creation - TODO double check
     */
    override operator fun compareTo(other: WorkspaceNode): Int {
        return label?.compareTo(other.label ?: "") ?: -1
    }
}
