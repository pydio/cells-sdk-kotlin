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

package com.pydio.kotlin.openapi.v2.moshi.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param isLocked 
 * @param owner 
 */


data class RestLockInfo (

    @Json(name = "IsLocked")
    val isLocked: kotlin.Boolean? = null,

    @Json(name = "Owner")
    val owner: kotlin.String? = null

) {


}

