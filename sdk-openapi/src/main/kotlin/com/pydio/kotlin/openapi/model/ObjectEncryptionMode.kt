/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/** Values: CLEAR,MASTER,USER,USER_PWD */
@JsonClass(generateAdapter = false)
enum class ObjectEncryptionMode(val value: kotlin.String) {

  @Json(name = "CLEAR") CLEAR("CLEAR"),
  @Json(name = "MASTER") MASTER("MASTER"),
  @Json(name = "USER") USER("USER"),
  @Json(name = "USER_PWD") USER_PWD("USER_PWD");

  /**
   * Override [toString()] to avoid using the enum variable name as the value, and instead use the
   * actual value defined in the API spec file.
   *
   * This solves a problem when the variable name and its value are different, and ensures that the
   * client sends the correct enum values to the server always.
   */
  override fun toString(): kotlin.String = value

  companion object {
    /** Converts the provided [data] to a [String] on success, null otherwise. */
    fun encode(data: kotlin.Any?): kotlin.String? =
        if (data is ObjectEncryptionMode) "$data" else null

    /** Returns a valid [ObjectEncryptionMode] for [data], null otherwise. */
    fun decode(data: kotlin.Any?): ObjectEncryptionMode? =
        data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value -> it == value || normalizedData == "$value".lowercase() }
        }
  }
}
