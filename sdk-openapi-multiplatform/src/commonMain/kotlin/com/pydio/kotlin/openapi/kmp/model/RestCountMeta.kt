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
 * @param namespace 
 * @param `value` 
 */
@Serializable

data class RestCountMeta (

    @SerialName(value = "Namespace") @Required val namespace: kotlin.String,

    @SerialName(value = "Value") @Required val `value`: kotlin.Int

) {


}

