/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param dataSources
 * @param total
 */
data class RestDataSourceCollection(
    @Json(name = "DataSources") val dataSources: kotlin.collections.List<ObjectDataSource>? = null,
    @Json(name = "Total") val total: kotlin.Int? = null
) {}
