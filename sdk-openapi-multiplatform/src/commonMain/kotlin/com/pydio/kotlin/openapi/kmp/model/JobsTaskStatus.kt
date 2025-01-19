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


import kotlinx.serialization.*

/**
 * 
 *
 * Values: Unknown,Idle,Running,Finished,Interrupted,Paused,Any,Error,Queued
 */
@Serializable
enum class JobsTaskStatus(val value: kotlin.String) {

    @SerialName(value = "Unknown")
    Unknown("Unknown"),

    @SerialName(value = "Idle")
    Idle("Idle"),

    @SerialName(value = "Running")
    Running("Running"),

    @SerialName(value = "Finished")
    Finished("Finished"),

    @SerialName(value = "Interrupted")
    Interrupted("Interrupted"),

    @SerialName(value = "Paused")
    Paused("Paused"),

    @SerialName(value = "Any")
    Any("Any"),

    @SerialName(value = "Error")
    Error("Error"),

    @SerialName(value = "Queued")
    Queued("Queued");

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
        fun encode(data: kotlin.Any?): kotlin.String? = if (data is JobsTaskStatus) "$data" else null

        /**
         * Returns a valid [JobsTaskStatus] for [data], null otherwise.
         */
        fun decode(data: kotlin.Any?): JobsTaskStatus? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}

