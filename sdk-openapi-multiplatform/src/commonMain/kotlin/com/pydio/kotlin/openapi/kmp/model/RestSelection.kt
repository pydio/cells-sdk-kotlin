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

import com.pydio.kotlin.openapi.kmp.model.RestNode

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Request to create a selection from a list of nodes.
 *
 * @param nodes 
 * @param uuid 
 */
@Serializable

data class RestSelection (

    @SerialName(value = "Nodes") @Required val nodes: kotlin.collections.List<RestNode>,

    @SerialName(value = "Uuid") val uuid: kotlin.String? = null

) {


}

