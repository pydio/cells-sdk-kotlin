/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.moshi.model

import com.squareup.moshi.Json

/**
 * @param namespace
 * @param `value`
 */
data class RestCountMeta(
    @Json(name = "Namespace") val namespace: kotlin.String,
    @Json(name = "Value") val `value`: kotlin.Int
) {}
