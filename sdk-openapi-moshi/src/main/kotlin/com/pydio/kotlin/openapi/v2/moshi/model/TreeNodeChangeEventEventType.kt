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

package com.pydio.kotlin.openapi.v2.moshi.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * Values: CREATE,READ,UPDATE_PATH,UPDATE_CONTENT,UPDATE_META,UPDATE_USER_META,DELETE
 */

@JsonClass(generateAdapter = false)
enum class TreeNodeChangeEventEventType(val value: kotlin.String) {

    @Json(name = "CREATE")
    CREATE("CREATE"),

    @Json(name = "READ")
    READ("READ"),

    @Json(name = "UPDATE_PATH")
    UPDATE_PATH("UPDATE_PATH"),

    @Json(name = "UPDATE_CONTENT")
    UPDATE_CONTENT("UPDATE_CONTENT"),

    @Json(name = "UPDATE_META")
    UPDATE_META("UPDATE_META"),

    @Json(name = "UPDATE_USER_META")
    UPDATE_USER_META("UPDATE_USER_META"),

    @Json(name = "DELETE")
    DELETE("DELETE");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is TreeNodeChangeEventEventType) "$data" else null

        /**
         * Returns a valid [TreeNodeChangeEventEventType] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): TreeNodeChangeEventEventType? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

