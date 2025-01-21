/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/** Values: ALL,EDGE,NODE,SERVICE,SERVER,DAO,GENERIC,ADDRESS,TAG,PROCESS,ENDPOINT,STATS,STORAGE */
@JsonClass(generateAdapter = false)
enum class RegistryItemType(val value: kotlin.String) {

  @Json(name = "ALL") ALL("ALL"),
  @Json(name = "EDGE") EDGE("EDGE"),
  @Json(name = "NODE") NODE("NODE"),
  @Json(name = "SERVICE") SERVICE("SERVICE"),
  @Json(name = "SERVER") SERVER("SERVER"),
  @Json(name = "DAO") DAO("DAO"),
  @Json(name = "GENERIC") GENERIC("GENERIC"),
  @Json(name = "ADDRESS") ADDRESS("ADDRESS"),
  @Json(name = "TAG") TAG("TAG"),
  @Json(name = "PROCESS") PROCESS("PROCESS"),
  @Json(name = "ENDPOINT") ENDPOINT("ENDPOINT"),
  @Json(name = "STATS") STATS("STATS"),
  @Json(name = "STORAGE") STORAGE("STORAGE");

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
    fun encode(data: kotlin.Any?): kotlin.String? = if (data is RegistryItemType) "$data" else null

    /** Returns a valid [RegistryItemType] for [data], null otherwise. */
    fun decode(data: kotlin.Any?): RegistryItemType? =
        data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value -> it == value || normalizedData == "$value".lowercase() }
        }
  }
}
