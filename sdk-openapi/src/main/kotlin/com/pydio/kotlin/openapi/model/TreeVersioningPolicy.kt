/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param description
 * @param ignoreFilesGreaterThan
 * @param keepPeriods
 * @param maxSizePerFile
 * @param maxTotalSize
 * @param name
 * @param nodeDeletedStrategy
 * @param uuid
 * @param versionsDataSourceBucket
 * @param versionsDataSourceName
 */
data class TreeVersioningPolicy(
    @Json(name = "Description") val description: kotlin.String? = null,
    @Json(name = "IgnoreFilesGreaterThan") val ignoreFilesGreaterThan: kotlin.String? = null,
    @Json(name = "KeepPeriods")
    val keepPeriods: kotlin.collections.List<TreeVersioningKeepPeriod>? = null,
    @Json(name = "MaxSizePerFile") val maxSizePerFile: kotlin.String? = null,
    @Json(name = "MaxTotalSize") val maxTotalSize: kotlin.String? = null,
    @Json(name = "Name") val name: kotlin.String? = null,
    @Json(name = "NodeDeletedStrategy")
    val nodeDeletedStrategy: TreeVersioningNodeDeletedStrategy? =
        TreeVersioningNodeDeletedStrategy.KeepAll,
    @Json(name = "Uuid") val uuid: kotlin.String? = null,
    @Json(name = "VersionsDataSourceBucket") val versionsDataSourceBucket: kotlin.String? = null,
    @Json(name = "VersionsDataSourceName") val versionsDataSourceName: kotlin.String? = null
) {}
