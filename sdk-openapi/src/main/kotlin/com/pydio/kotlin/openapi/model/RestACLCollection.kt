/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param acLs
 * @param total
 */
data class RestACLCollection(
    @Json(name = "ACLs") val acLs: kotlin.collections.List<IdmACL>? = null,
    @Json(name = "Total") val total: kotlin.Int? = null
) {}
