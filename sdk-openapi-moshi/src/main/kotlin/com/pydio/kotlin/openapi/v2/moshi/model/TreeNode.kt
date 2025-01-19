/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.moshi.model

import com.squareup.moshi.Json

/**
 * @param appearsIn
 * @param commits
 * @param etag
 * @param mtime
 * @param metaStore
 * @param mode Permission mode, like 0777. Stored as string using custom ModeString field.
 * @param modeString
 * @param path
 * @param propertySize
 * @param type
 * @param uuid
 */
data class TreeNode(
    @Json(name = "AppearsIn")
    val appearsIn: kotlin.collections.List<TreeWorkspaceRelativePath>? = null,
    @Json(name = "Commits") val commits: kotlin.collections.List<TreeChangeLog>? = null,
    @Json(name = "Etag") val etag: kotlin.String? = null,
    @Json(name = "MTime") val mtime: kotlin.String? = null,
    @Json(name = "MetaStore")
    val metaStore: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,

    /* Permission mode, like 0777. Stored as string using custom ModeString field. */
    @Json(name = "Mode") val mode: kotlin.Int? = null,
    @Json(name = "ModeString") val modeString: kotlin.String? = null,
    @Json(name = "Path") val path: kotlin.String? = null,
    @Json(name = "Size") val propertySize: kotlin.String? = null,
    @Json(name = "Type") val type: TreeNodeType? = TreeNodeType.UNKNOWN,
    @Json(name = "Uuid") val uuid: kotlin.String? = null
) {}
