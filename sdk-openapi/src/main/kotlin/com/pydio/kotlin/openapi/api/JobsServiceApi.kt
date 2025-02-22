/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.api

import com.pydio.kotlin.openapi.infrastructure.ApiClient
import com.pydio.kotlin.openapi.infrastructure.ApiResponse
import com.pydio.kotlin.openapi.infrastructure.ClientError
import com.pydio.kotlin.openapi.infrastructure.ClientException
import com.pydio.kotlin.openapi.infrastructure.MultiValueMap
import com.pydio.kotlin.openapi.infrastructure.RequestConfig
import com.pydio.kotlin.openapi.infrastructure.RequestMethod
import com.pydio.kotlin.openapi.infrastructure.ResponseType
import com.pydio.kotlin.openapi.infrastructure.ServerError
import com.pydio.kotlin.openapi.infrastructure.ServerException
import com.pydio.kotlin.openapi.infrastructure.Success
import com.pydio.kotlin.openapi.model.JobsCtrlCommand
import com.pydio.kotlin.openapi.model.JobsCtrlCommandResponse
import com.pydio.kotlin.openapi.model.JobsDeleteTasksRequest
import com.pydio.kotlin.openapi.model.JobsDeleteTasksResponse
import com.pydio.kotlin.openapi.model.JobsListJobsRequest
import com.pydio.kotlin.openapi.model.LogListLogRequest
import com.pydio.kotlin.openapi.model.RestLogMessageCollection
import com.pydio.kotlin.openapi.model.RestUserJobRequest
import com.pydio.kotlin.openapi.model.RestUserJobResponse
import com.pydio.kotlin.openapi.model.RestUserJobsCollection
import java.io.IOException
import okhttp3.Call
import okhttp3.HttpUrl

class JobsServiceApi(
    basePath: kotlin.String = defaultBasePath,
    client: Call.Factory = ApiClient.defaultClient
) : ApiClient(basePath, client) {
  companion object {
    @JvmStatic
    val defaultBasePath: String by lazy {
      System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
    }
  }

  /**
   * Technical Logs, in Json or CSV format
   *
   * @param body ListLogRequest launches a parameterised query in the log repository and streams the
   *   results.
   * @return RestLogMessageCollection
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   * @throws UnsupportedOperationException If the API returns an informational or redirection
   *   response
   * @throws ClientException If the API returns a client error response
   * @throws ServerException If the API returns a server error response
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(
      IllegalStateException::class,
      IOException::class,
      UnsupportedOperationException::class,
      ClientException::class,
      ServerException::class)
  fun listTasksLogs(body: LogListLogRequest): RestLogMessageCollection {
    val localVarResponse = listTasksLogsWithHttpInfo(body = body)

    return when (localVarResponse.responseType) {
      ResponseType.Success -> (localVarResponse as Success<*>).data as RestLogMessageCollection
      ResponseType.Informational ->
          throw UnsupportedOperationException("Client does not support Informational responses.")
      ResponseType.Redirection ->
          throw UnsupportedOperationException("Client does not support Redirection responses.")
      ResponseType.ClientError -> {
        val localVarError = localVarResponse as ClientError<*>
        throw ClientException(
            "Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}",
            localVarError.statusCode,
            localVarResponse)
      }
      ResponseType.ServerError -> {
        val localVarError = localVarResponse as ServerError<*>
        throw ServerException(
            "Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}",
            localVarError.statusCode,
            localVarResponse)
      }
    }
  }

  /**
   * Technical Logs, in Json or CSV format
   *
   * @param body ListLogRequest launches a parameterised query in the log repository and streams the
   *   results.
   * @return ApiResponse<RestLogMessageCollection?>
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(IllegalStateException::class, IOException::class)
  fun listTasksLogsWithHttpInfo(body: LogListLogRequest): ApiResponse<RestLogMessageCollection?> {
    val localVariableConfig = listTasksLogsRequestConfig(body = body)

    return request<LogListLogRequest, RestLogMessageCollection>(localVariableConfig)
  }

  /**
   * To obtain the request config of the operation listTasksLogs
   *
   * @param body ListLogRequest launches a parameterised query in the log repository and streams the
   *   results.
   * @return RequestConfig
   */
  fun listTasksLogsRequestConfig(body: LogListLogRequest): RequestConfig<LogListLogRequest> {
    val localVariableBody = body
    val localVariableQuery: MultiValueMap = mutableMapOf()
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders["Content-Type"] = "application/json"
    localVariableHeaders["Accept"] = "application/json"

    return RequestConfig(
        method = RequestMethod.POST,
        path = "/jobs/tasks/logs",
        query = localVariableQuery,
        headers = localVariableHeaders,
        requiresAuthentication = false,
        body = localVariableBody)
  }

  /**
   * Send Control Commands to one or many jobs / tasks
   *
   * @param body
   * @return JobsCtrlCommandResponse
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   * @throws UnsupportedOperationException If the API returns an informational or redirection
   *   response
   * @throws ClientException If the API returns a client error response
   * @throws ServerException If the API returns a server error response
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(
      IllegalStateException::class,
      IOException::class,
      UnsupportedOperationException::class,
      ClientException::class,
      ServerException::class)
  fun userControlJob(body: JobsCtrlCommand): JobsCtrlCommandResponse {
    val localVarResponse = userControlJobWithHttpInfo(body = body)

    return when (localVarResponse.responseType) {
      ResponseType.Success -> (localVarResponse as Success<*>).data as JobsCtrlCommandResponse
      ResponseType.Informational ->
          throw UnsupportedOperationException("Client does not support Informational responses.")
      ResponseType.Redirection ->
          throw UnsupportedOperationException("Client does not support Redirection responses.")
      ResponseType.ClientError -> {
        val localVarError = localVarResponse as ClientError<*>
        throw ClientException(
            "Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}",
            localVarError.statusCode,
            localVarResponse)
      }
      ResponseType.ServerError -> {
        val localVarError = localVarResponse as ServerError<*>
        throw ServerException(
            "Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}",
            localVarError.statusCode,
            localVarResponse)
      }
    }
  }

  /**
   * Send Control Commands to one or many jobs / tasks
   *
   * @param body
   * @return ApiResponse<JobsCtrlCommandResponse?>
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(IllegalStateException::class, IOException::class)
  fun userControlJobWithHttpInfo(body: JobsCtrlCommand): ApiResponse<JobsCtrlCommandResponse?> {
    val localVariableConfig = userControlJobRequestConfig(body = body)

    return request<JobsCtrlCommand, JobsCtrlCommandResponse>(localVariableConfig)
  }

  /**
   * To obtain the request config of the operation userControlJob
   *
   * @param body
   * @return RequestConfig
   */
  fun userControlJobRequestConfig(body: JobsCtrlCommand): RequestConfig<JobsCtrlCommand> {
    val localVariableBody = body
    val localVariableQuery: MultiValueMap = mutableMapOf()
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders["Content-Type"] = "application/json"
    localVariableHeaders["Accept"] = "application/json"

    return RequestConfig(
        method = RequestMethod.PUT,
        path = "/jobs/user",
        query = localVariableQuery,
        headers = localVariableHeaders,
        requiresAuthentication = false,
        body = localVariableBody)
  }

  /**
   * Create a predefined job to be run directly
   *
   * @param jobName Name of the job to create in the user space
   * @param body
   * @return RestUserJobResponse
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   * @throws UnsupportedOperationException If the API returns an informational or redirection
   *   response
   * @throws ClientException If the API returns a client error response
   * @throws ServerException If the API returns a server error response
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(
      IllegalStateException::class,
      IOException::class,
      UnsupportedOperationException::class,
      ClientException::class,
      ServerException::class)
  fun userCreateJob(jobName: kotlin.String, body: RestUserJobRequest): RestUserJobResponse {
    val localVarResponse = userCreateJobWithHttpInfo(jobName = jobName, body = body)

    return when (localVarResponse.responseType) {
      ResponseType.Success -> (localVarResponse as Success<*>).data as RestUserJobResponse
      ResponseType.Informational ->
          throw UnsupportedOperationException("Client does not support Informational responses.")
      ResponseType.Redirection ->
          throw UnsupportedOperationException("Client does not support Redirection responses.")
      ResponseType.ClientError -> {
        val localVarError = localVarResponse as ClientError<*>
        throw ClientException(
            "Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}",
            localVarError.statusCode,
            localVarResponse)
      }
      ResponseType.ServerError -> {
        val localVarError = localVarResponse as ServerError<*>
        throw ServerException(
            "Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}",
            localVarError.statusCode,
            localVarResponse)
      }
    }
  }

  /**
   * Create a predefined job to be run directly
   *
   * @param jobName Name of the job to create in the user space
   * @param body
   * @return ApiResponse<RestUserJobResponse?>
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(IllegalStateException::class, IOException::class)
  fun userCreateJobWithHttpInfo(
      jobName: kotlin.String,
      body: RestUserJobRequest
  ): ApiResponse<RestUserJobResponse?> {
    val localVariableConfig = userCreateJobRequestConfig(jobName = jobName, body = body)

    return request<RestUserJobRequest, RestUserJobResponse>(localVariableConfig)
  }

  /**
   * To obtain the request config of the operation userCreateJob
   *
   * @param jobName Name of the job to create in the user space
   * @param body
   * @return RequestConfig
   */
  fun userCreateJobRequestConfig(
      jobName: kotlin.String,
      body: RestUserJobRequest
  ): RequestConfig<RestUserJobRequest> {
    val localVariableBody = body
    val localVariableQuery: MultiValueMap = mutableMapOf()
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders["Content-Type"] = "application/json"
    localVariableHeaders["Accept"] = "application/json"

    return RequestConfig(
        method = RequestMethod.PUT,
        path =
            "/jobs/user/{JobName}"
                .replace("{" + "JobName" + "}", encodeURIComponent(jobName.toString())),
        query = localVariableQuery,
        headers = localVariableHeaders,
        requiresAuthentication = false,
        body = localVariableBody)
  }

  /**
   * Send a control command to clean tasks on a given job
   *
   * @param body
   * @return JobsDeleteTasksResponse
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   * @throws UnsupportedOperationException If the API returns an informational or redirection
   *   response
   * @throws ClientException If the API returns a client error response
   * @throws ServerException If the API returns a server error response
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(
      IllegalStateException::class,
      IOException::class,
      UnsupportedOperationException::class,
      ClientException::class,
      ServerException::class)
  fun userDeleteTasks(body: JobsDeleteTasksRequest): JobsDeleteTasksResponse {
    val localVarResponse = userDeleteTasksWithHttpInfo(body = body)

    return when (localVarResponse.responseType) {
      ResponseType.Success -> (localVarResponse as Success<*>).data as JobsDeleteTasksResponse
      ResponseType.Informational ->
          throw UnsupportedOperationException("Client does not support Informational responses.")
      ResponseType.Redirection ->
          throw UnsupportedOperationException("Client does not support Redirection responses.")
      ResponseType.ClientError -> {
        val localVarError = localVarResponse as ClientError<*>
        throw ClientException(
            "Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}",
            localVarError.statusCode,
            localVarResponse)
      }
      ResponseType.ServerError -> {
        val localVarError = localVarResponse as ServerError<*>
        throw ServerException(
            "Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}",
            localVarError.statusCode,
            localVarResponse)
      }
    }
  }

  /**
   * Send a control command to clean tasks on a given job
   *
   * @param body
   * @return ApiResponse<JobsDeleteTasksResponse?>
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(IllegalStateException::class, IOException::class)
  fun userDeleteTasksWithHttpInfo(
      body: JobsDeleteTasksRequest
  ): ApiResponse<JobsDeleteTasksResponse?> {
    val localVariableConfig = userDeleteTasksRequestConfig(body = body)

    return request<JobsDeleteTasksRequest, JobsDeleteTasksResponse>(localVariableConfig)
  }

  /**
   * To obtain the request config of the operation userDeleteTasks
   *
   * @param body
   * @return RequestConfig
   */
  fun userDeleteTasksRequestConfig(
      body: JobsDeleteTasksRequest
  ): RequestConfig<JobsDeleteTasksRequest> {
    val localVariableBody = body
    val localVariableQuery: MultiValueMap = mutableMapOf()
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders["Content-Type"] = "application/json"
    localVariableHeaders["Accept"] = "application/json"

    return RequestConfig(
        method = RequestMethod.POST,
        path = "/jobs/tasks/delete",
        query = localVariableQuery,
        headers = localVariableHeaders,
        requiresAuthentication = false,
        body = localVariableBody)
  }

  /**
   * List jobs associated with current user
   *
   * @param body
   * @return RestUserJobsCollection
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   * @throws UnsupportedOperationException If the API returns an informational or redirection
   *   response
   * @throws ClientException If the API returns a client error response
   * @throws ServerException If the API returns a server error response
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(
      IllegalStateException::class,
      IOException::class,
      UnsupportedOperationException::class,
      ClientException::class,
      ServerException::class)
  fun userListJobs(body: JobsListJobsRequest): RestUserJobsCollection {
    val localVarResponse = userListJobsWithHttpInfo(body = body)

    return when (localVarResponse.responseType) {
      ResponseType.Success -> (localVarResponse as Success<*>).data as RestUserJobsCollection
      ResponseType.Informational ->
          throw UnsupportedOperationException("Client does not support Informational responses.")
      ResponseType.Redirection ->
          throw UnsupportedOperationException("Client does not support Redirection responses.")
      ResponseType.ClientError -> {
        val localVarError = localVarResponse as ClientError<*>
        throw ClientException(
            "Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}",
            localVarError.statusCode,
            localVarResponse)
      }
      ResponseType.ServerError -> {
        val localVarError = localVarResponse as ServerError<*>
        throw ServerException(
            "Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}",
            localVarError.statusCode,
            localVarResponse)
      }
    }
  }

  /**
   * List jobs associated with current user
   *
   * @param body
   * @return ApiResponse<RestUserJobsCollection?>
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(IllegalStateException::class, IOException::class)
  fun userListJobsWithHttpInfo(body: JobsListJobsRequest): ApiResponse<RestUserJobsCollection?> {
    val localVariableConfig = userListJobsRequestConfig(body = body)

    return request<JobsListJobsRequest, RestUserJobsCollection>(localVariableConfig)
  }

  /**
   * To obtain the request config of the operation userListJobs
   *
   * @param body
   * @return RequestConfig
   */
  fun userListJobsRequestConfig(body: JobsListJobsRequest): RequestConfig<JobsListJobsRequest> {
    val localVariableBody = body
    val localVariableQuery: MultiValueMap = mutableMapOf()
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders["Content-Type"] = "application/json"
    localVariableHeaders["Accept"] = "application/json"

    return RequestConfig(
        method = RequestMethod.POST,
        path = "/jobs/user",
        query = localVariableQuery,
        headers = localVariableHeaders,
        requiresAuthentication = false,
        body = localVariableBody)
  }

  private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
      HttpUrl.Builder()
          .scheme("http")
          .host("localhost")
          .addPathSegment(uriComponent)
          .build()
          .encodedPathSegments[0]
}
