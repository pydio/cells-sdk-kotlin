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

package com.pydio.kotlin.openapi.kmp.model

import com.pydio.kotlin.openapi.kmp.model.IdmUserMetaNamespace

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param namespaces 
 */
@Serializable

data class RestUserMetaNamespaceCollection (

    @SerialName(value = "Namespaces") val namespaces: kotlin.collections.List<IdmUserMetaNamespace>? = null

) {


}

