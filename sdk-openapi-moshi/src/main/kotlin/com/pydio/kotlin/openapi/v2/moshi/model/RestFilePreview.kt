/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.moshi.model

import com.squareup.moshi.Json

/**
 * @param bucket
 * @param contentType
 * @param dimension
 * @param key
 * @param processing
 * @param url
 */
data class RestFilePreview(
    @Json(name = "Bucket") val bucket: kotlin.String? = null,
    @Json(name = "ContentType") val contentType: kotlin.String? = null,
    @Json(name = "Dimension") val dimension: kotlin.Int? = null,
    @Json(name = "Key") val key: kotlin.String? = null,
    @Json(name = "Processing") val processing: kotlin.Boolean? = null,
    @Json(name = "Url") val url: kotlin.String? = null
) {}
