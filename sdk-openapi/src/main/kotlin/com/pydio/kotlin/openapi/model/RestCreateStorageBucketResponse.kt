/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param bucketName
 * @param success
 */
data class RestCreateStorageBucketResponse(
    @Json(name = "BucketName") val bucketName: kotlin.String? = null,
    @Json(name = "Success") val success: kotlin.Boolean? = null
) {}
