/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param key
 * @param `override`
 * @param strPassword
 */
data class EncryptionAdminImportKeyRequest(
    @Json(name = "Key") val key: EncryptionKey? = null,
    @Json(name = "Override") val `override`: kotlin.Boolean? = null,
    @Json(name = "StrPassword") val strPassword: kotlin.String? = null
) {}
