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


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param jsonValue 
 * @param namespace 
 * @param editable 
 * @param nodeUuid 
 */
@Serializable

data class RestUserMeta (

    @SerialName(value = "JsonValue") @Required val jsonValue: kotlin.String,

    @SerialName(value = "Namespace") @Required val namespace: kotlin.String,

    @SerialName(value = "Editable") val editable: kotlin.Boolean? = null,

    @SerialName(value = "NodeUuid") val nodeUuid: kotlin.String? = null

) {


}

