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

import com.pydio.kotlin.openapi.model.TreeNode

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param nodes 
 * @param persist 
 * @param targetAction 
 */


data class RestCreateSelectionRequest (

    @Json(name = "Nodes")
    val nodes: kotlin.collections.List<TreeNode>? = null,

    @Json(name = "Persist")
    val persist: kotlin.Boolean? = null,

    @Json(name = "TargetAction")
    val targetAction: kotlin.String? = null

) {


}

