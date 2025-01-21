/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param authInfo
 * @param clientTime
 * @param logout
 */
data class RestFrontSessionRequest(
    @Json(name = "AuthInfo")
    val authInfo: kotlin.collections.Map<kotlin.String, kotlin.String>? = null,
    @Json(name = "ClientTime") val clientTime: kotlin.Int? = null,
    @Json(name = "Logout") val logout: kotlin.Boolean? = null
) {}
