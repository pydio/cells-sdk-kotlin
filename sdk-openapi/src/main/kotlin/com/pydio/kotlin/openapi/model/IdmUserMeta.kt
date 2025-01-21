/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param jsonValue
 * @param namespace
 * @param nodeUuid
 * @param policies
 * @param policiesContextEditable
 * @param resolvedNode
 * @param uuid
 */
data class IdmUserMeta(
    @Json(name = "JsonValue") val jsonValue: kotlin.String? = null,
    @Json(name = "Namespace") val namespace: kotlin.String? = null,
    @Json(name = "NodeUuid") val nodeUuid: kotlin.String? = null,
    @Json(name = "Policies") val policies: kotlin.collections.List<ServiceResourcePolicy>? = null,
    @Json(name = "PoliciesContextEditable") val policiesContextEditable: kotlin.Boolean? = null,
    @Json(name = "ResolvedNode") val resolvedNode: TreeNode? = null,
    @Json(name = "Uuid") val uuid: kotlin.String? = null
) {}
