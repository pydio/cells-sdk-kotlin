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

import com.pydio.kotlin.openapi.v2.moshi.model.RestNodeLocator
import com.pydio.kotlin.openapi.v2.moshi.model.TreeNodeType

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param locator 
 * @param type 
 * @param contentType 
 * @param knownSize 
 * @param templateUuid 
 */


data class RestIncomingNode (

    @Json(name = "Locator")
    val locator: RestNodeLocator,

    @Json(name = "Type")
    val type: TreeNodeType = TreeNodeType.UNKNOWN,

    @Json(name = "ContentType")
    val contentType: kotlin.String? = null,

    @Json(name = "KnownSize")
    val knownSize: kotlin.String? = null,

    @Json(name = "TemplateUuid")
    val templateUuid: kotlin.String? = null

) {


}

