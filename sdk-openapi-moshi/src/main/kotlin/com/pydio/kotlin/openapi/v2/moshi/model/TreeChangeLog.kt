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

import com.pydio.kotlin.openapi.v2.moshi.model.TreeNode
import com.pydio.kotlin.openapi.v2.moshi.model.TreeNodeChangeEvent

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param `data` 
 * @param description 
 * @param event 
 * @param location 
 * @param mtime 
 * @param ownerUuid 
 * @param propertySize 
 * @param uuid 
 */


data class TreeChangeLog (

    @Json(name = "Data")
    val `data`: kotlin.ByteArray? = null,

    @Json(name = "Description")
    val description: kotlin.String? = null,

    @Json(name = "Event")
    val event: TreeNodeChangeEvent? = null,

    @Json(name = "Location")
    val location: TreeNode? = null,

    @Json(name = "MTime")
    val mtime: kotlin.String? = null,

    @Json(name = "OwnerUuid")
    val ownerUuid: kotlin.String? = null,

    @Json(name = "Size")
    val propertySize: kotlin.String? = null,

    @Json(name = "Uuid")
    val uuid: kotlin.String? = null

) {


}

