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

import com.pydio.kotlin.openapi.kmp.model.JobsTaskStatus
import com.pydio.kotlin.openapi.kmp.model.RestNodeLocator

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param awaitStatus 
 * @param awaitTimeout 
 * @param jsonParameters 
 * @param nodes 
 * @param selectionUuid 
 * @param targetNode 
 */
@Serializable

data class RestActionParameters (

    @SerialName(value = "AwaitStatus") val awaitStatus: JobsTaskStatus? = JobsTaskStatus.Unknown,

    @SerialName(value = "AwaitTimeout") val awaitTimeout: kotlin.String? = null,

    @SerialName(value = "JsonParameters") val jsonParameters: kotlin.String? = null,

    @SerialName(value = "Nodes") val nodes: kotlin.collections.List<RestNodeLocator>? = null,

    @SerialName(value = "SelectionUuid") val selectionUuid: kotlin.String? = null,

    @SerialName(value = "TargetNode") val targetNode: RestNodeLocator? = null

) {


}

