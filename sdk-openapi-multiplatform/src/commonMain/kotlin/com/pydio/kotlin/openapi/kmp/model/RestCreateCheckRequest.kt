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

import com.pydio.kotlin.openapi.kmp.model.RestIncomingNode

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Request for pre-checking nodes before uploading or creating them.
 *
 * @param inputs 
 * @param findAvailablePath 
 */
@Serializable

data class RestCreateCheckRequest (

    @SerialName(value = "Inputs") @Required val inputs: kotlin.collections.List<RestIncomingNode>,

    @SerialName(value = "FindAvailablePath") val findAvailablePath: kotlin.Boolean? = null

) {


}

