/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.model

import com.squareup.moshi.Json

/**
 * @param inputs
 * @param recursive
 */
data class RestCreateRequest(
    @Json(name = "Inputs") val inputs: kotlin.collections.List<RestIncomingNode>,
    @Json(name = "Recursive") val recursive: kotlin.Boolean? = null
) {}
