/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param errorString
 * @param ignored
 * @param jsonBody
 * @param rawBody
 * @param stringBody
 * @param success
 * @param time
 * @param vars Vars container, values are json-encoded.
 */
data class JobsActionOutput(
    @Json(name = "ErrorString") val errorString: kotlin.String? = null,
    @Json(name = "Ignored") val ignored: kotlin.Boolean? = null,
    @Json(name = "JsonBody") val jsonBody: kotlin.ByteArray? = null,
    @Json(name = "RawBody") val rawBody: kotlin.ByteArray? = null,
    @Json(name = "StringBody") val stringBody: kotlin.String? = null,
    @Json(name = "Success") val success: kotlin.Boolean? = null,
    @Json(name = "Time") val time: kotlin.Int? = null,

    /* Vars container, values are json-encoded. */
    @Json(name = "Vars") val vars: kotlin.collections.Map<kotlin.String, kotlin.String>? = null
) {}
