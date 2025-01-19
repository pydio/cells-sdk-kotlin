/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.moshi.model

import com.squareup.moshi.Json

/**
 * @param limit
 * @param locators
 * @param offset
 * @param query
 * @param sortDirDesc
 * @param sortField
 * @param statFlags
 */
data class RestLookupRequest(
    @Json(name = "Limit") val limit: kotlin.String? = null,
    @Json(name = "Locators") val locators: RestNodeLocators? = null,
    @Json(name = "Offset") val offset: kotlin.String? = null,
    @Json(name = "Query") val query: TreeQuery? = null,
    @Json(name = "SortDirDesc") val sortDirDesc: kotlin.Boolean? = null,
    @Json(name = "SortField") val sortField: kotlin.String? = null,
    @Json(name = "StatFlags") val statFlags: kotlin.collections.List<kotlin.Long>? = null
) {}
