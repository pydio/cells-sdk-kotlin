/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.moshi.model

import com.squareup.moshi.Json

/**
 * @param uuid
 * @param description
 */
data class RestRevisionMeta(
    @Json(name = "Uuid") val uuid: kotlin.String,
    @Json(name = "Description") val description: kotlin.String? = null
) {}
