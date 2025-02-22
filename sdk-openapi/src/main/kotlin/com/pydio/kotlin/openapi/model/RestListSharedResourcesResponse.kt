/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param limit
 * @param offset
 * @param resources
 * @param total
 */
data class RestListSharedResourcesResponse(
    @Json(name = "Limit") val limit: kotlin.Int? = null,
    @Json(name = "Offset") val offset: kotlin.Int? = null,
    @Json(name = "Resources")
    val resources: kotlin.collections.List<ListSharedResourcesResponseSharedResource>? = null,
    @Json(name = "Total") val total: kotlin.Int? = null
) {}
