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

import com.pydio.kotlin.openapi.model.IdmUserMetaNamespace

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param namespaces 
 */


data class IdmUpdateUserMetaNamespaceResponse (

    @Json(name = "Namespaces")
    val namespaces: kotlin.collections.List<IdmUserMetaNamespace>? = null

) {


}

