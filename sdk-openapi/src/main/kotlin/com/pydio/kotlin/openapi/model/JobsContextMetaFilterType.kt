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

package com.pydio.kotlin.openapi.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * Values: RequestMeta,ContextUser
 */

@JsonClass(generateAdapter = false)
enum class JobsContextMetaFilterType(val value: kotlin.String) {

    @Json(name = "RequestMeta")
    RequestMeta("RequestMeta"),

    @Json(name = "ContextUser")
    ContextUser("ContextUser");

    /**
     * Override [toString()] to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): kotlin.String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is JobsContextMetaFilterType) "$data" else null

        /**
         * Returns a valid [JobsContextMetaFilterType] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): JobsContextMetaFilterType? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

