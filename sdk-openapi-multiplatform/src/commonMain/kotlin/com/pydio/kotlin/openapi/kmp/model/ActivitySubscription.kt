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

import com.pydio.kotlin.openapi.kmp.model.ActivityOwnerType

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param events 
 * @param objectId 
 * @param objectType 
 * @param userId 
 */
@Serializable

data class ActivitySubscription (

    @SerialName(value = "Events") val events: kotlin.collections.List<kotlin.String>? = null,

    @SerialName(value = "ObjectId") val objectId: kotlin.String? = null,

    @SerialName(value = "ObjectType") val objectType: ActivityOwnerType? = ActivityOwnerType.NODE,

    @SerialName(value = "UserId") val userId: kotlin.String? = null

) {


}

