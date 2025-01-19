/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.v2.model

import com.squareup.moshi.Json

/**
 * @param link
 * @param createPassword
 * @param passwordEnabled
 * @param updateCustomHash
 * @param updatePassword
 */
data class RestPublicLinkRequest(
    @Json(name = "Link") val link: RestShareLink,
    @Json(name = "CreatePassword") val createPassword: kotlin.String? = null,
    @Json(name = "PasswordEnabled") val passwordEnabled: kotlin.Boolean? = null,
    @Json(name = "UpdateCustomHash") val updateCustomHash: kotlin.String? = null,
    @Json(name = "UpdatePassword") val updatePassword: kotlin.String? = null
) {}
