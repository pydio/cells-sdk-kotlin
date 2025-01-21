/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param ID
 * @param metricsPort
 * @param parentID
 * @param peerAddress
 * @param peerId
 * @param services
 * @param startTag
 */
data class RestProcess(
    @Json(name = "ID") val ID: kotlin.String? = null,
    @Json(name = "MetricsPort") val metricsPort: kotlin.Int? = null,
    @Json(name = "ParentID") val parentID: kotlin.String? = null,
    @Json(name = "PeerAddress") val peerAddress: kotlin.String? = null,
    @Json(name = "PeerId") val peerId: kotlin.String? = null,
    @Json(name = "Services") val services: kotlin.collections.List<kotlin.String>? = null,
    @Json(name = "StartTag") val startTag: kotlin.String? = null
) {}
