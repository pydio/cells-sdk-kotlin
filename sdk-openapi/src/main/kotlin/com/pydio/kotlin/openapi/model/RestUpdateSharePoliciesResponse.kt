/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param policies
 * @param policiesContextEditable
 * @param success
 */
data class RestUpdateSharePoliciesResponse(
    @Json(name = "Policies") val policies: kotlin.collections.List<ServiceResourcePolicy>? = null,
    @Json(name = "PoliciesContextEditable") val policiesContextEditable: kotlin.Boolean? = null,
    @Json(name = "Success") val success: kotlin.Boolean? = null
) {}
