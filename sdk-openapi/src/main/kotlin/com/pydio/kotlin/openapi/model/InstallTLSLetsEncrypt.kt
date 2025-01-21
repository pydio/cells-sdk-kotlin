/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param acceptEULA
 * @param email
 * @param stagingCA
 */
data class InstallTLSLetsEncrypt(
    @Json(name = "AcceptEULA") val acceptEULA: kotlin.Boolean? = null,
    @Json(name = "Email") val email: kotlin.String? = null,
    @Json(name = "StagingCA") val stagingCA: kotlin.Boolean? = null
) {}
