/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param lat
 * @param lon
 */
data class TreeGeoPoint(
    @Json(name = "Lat") val lat: kotlin.Double? = null,
    @Json(name = "Lon") val lon: kotlin.Double? = null
) {}
