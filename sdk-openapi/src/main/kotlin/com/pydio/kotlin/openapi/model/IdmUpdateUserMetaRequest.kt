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

import com.pydio.kotlin.openapi.model.IdmUserMeta
import com.pydio.kotlin.openapi.model.UpdateUserMetaRequestUserMetaOp

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param metaDatas 
 * @param operation 
 */


data class IdmUpdateUserMetaRequest (

    @Json(name = "MetaDatas")
    val metaDatas: kotlin.collections.List<IdmUserMeta>? = null,

    @Json(name = "Operation")
    val operation: UpdateUserMetaRequestUserMetaOp? = UpdateUserMetaRequestUserMetaOp.PUT

) {


}

