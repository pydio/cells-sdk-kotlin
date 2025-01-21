/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param node
 * @param objectStats
 * @param statFlags
 * @param withCommits
 * @param withExtendedStats
 */
data class TreeReadNodeRequest(
    @Json(name = "Node") val node: TreeNode? = null,
    @Json(name = "ObjectStats") val objectStats: kotlin.Boolean? = null,
    @Json(name = "StatFlags") val statFlags: kotlin.collections.List<kotlin.Long>? = null,
    @Json(name = "WithCommits") val withCommits: kotlin.Boolean? = null,
    @Json(name = "WithExtendedStats") val withExtendedStats: kotlin.Boolean? = null
) {}
