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

package com.pydio.kotlin.openapi.model

import com.pydio.kotlin.openapi.model.RestMetaUpdate

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param updates 
 */


data class RestBatchUpdateMetaList (

    @Json(name = "Updates")
    val updates: kotlin.collections.List<RestMetaUpdate>? = null

) {


}

