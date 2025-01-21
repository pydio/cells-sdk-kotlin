/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.api

import io.kotlintest.specs.ShouldSpec

class JobsServiceApiTest : ShouldSpec() {
  init {
    // uncomment below to create an instance of JobsServiceApi
    // val apiInstance = JobsServiceApi()

    // to test listTasksLogs
    should("test listTasksLogs") {
      // uncomment below to test listTasksLogs
      // val body : LogListLogRequest =  // LogListLogRequest | ListLogRequest launches a
      // parameterised query in the log repository and streams the results.
      // val result : RestLogMessageCollection = apiInstance.listTasksLogs(body)
      // result shouldBe ("TODO")
    }

    // to test userControlJob
    should("test userControlJob") {
      // uncomment below to test userControlJob
      // val body : JobsCtrlCommand =  // JobsCtrlCommand |
      // val result : JobsCtrlCommandResponse = apiInstance.userControlJob(body)
      // result shouldBe ("TODO")
    }

    // to test userCreateJob
    should("test userCreateJob") {
      // uncomment below to test userCreateJob
      // val jobName : kotlin.String = jobName_example // kotlin.String | Name of the job to create
      // in the user space
      // val body : RestUserJobRequest =  // RestUserJobRequest |
      // val result : RestUserJobResponse = apiInstance.userCreateJob(jobName, body)
      // result shouldBe ("TODO")
    }

    // to test userDeleteTasks
    should("test userDeleteTasks") {
      // uncomment below to test userDeleteTasks
      // val body : JobsDeleteTasksRequest =  // JobsDeleteTasksRequest |
      // val result : JobsDeleteTasksResponse = apiInstance.userDeleteTasks(body)
      // result shouldBe ("TODO")
    }

    // to test userListJobs
    should("test userListJobs") {
      // uncomment below to test userListJobs
      // val body : JobsListJobsRequest =  // JobsListJobsRequest |
      // val result : RestUserJobsCollection = apiInstance.userListJobs(body)
      // result shouldBe ("TODO")
    }
  }
}
