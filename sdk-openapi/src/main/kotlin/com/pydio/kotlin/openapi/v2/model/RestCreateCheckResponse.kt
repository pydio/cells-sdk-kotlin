/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.pydio.kotlin.openapi.v2.model

import com.pydio.kotlin.openapi.v2.model.RestCheckResult

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param results 
 */


data class RestCreateCheckResponse (

    @Json(name = "Results")
    val results: kotlin.collections.List<RestCheckResult>

) {


}

