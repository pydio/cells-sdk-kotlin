/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.model

import com.squareup.moshi.Json

/**
 * @param eventsOnly
 * @param jobIDs
 * @param loadTasks
 * @param owner
 * @param tasksLimit
 * @param tasksOffset
 * @param timersOnly
 */
data class JobsListJobsRequest(
    @Json(name = "EventsOnly") val eventsOnly: kotlin.Boolean? = null,
    @Json(name = "JobIDs") val jobIDs: kotlin.collections.List<kotlin.String>? = null,
    @Json(name = "LoadTasks") val loadTasks: JobsTaskStatus? = JobsTaskStatus.Unknown,
    @Json(name = "Owner") val owner: kotlin.String? = null,
    @Json(name = "TasksLimit") val tasksLimit: kotlin.Int? = null,
    @Json(name = "TasksOffset") val tasksOffset: kotlin.Int? = null,
    @Json(name = "TimersOnly") val timersOnly: kotlin.Boolean? = null
) {}
