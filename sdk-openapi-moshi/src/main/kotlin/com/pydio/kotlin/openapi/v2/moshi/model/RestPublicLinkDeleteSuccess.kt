/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.moshi.model

import com.squareup.moshi.Json

/**
 * @param message
 * @param uuid
 */
data class RestPublicLinkDeleteSuccess(
    @Json(name = "Message") val message: kotlin.String? = null,
    @Json(name = "Uuid") val uuid: kotlin.String? = null
) {}
