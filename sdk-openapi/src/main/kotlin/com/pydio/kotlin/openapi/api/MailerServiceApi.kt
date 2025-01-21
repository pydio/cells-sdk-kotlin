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
import com.pydio.kotlin.openapi.model.MailerMail
import com.pydio.kotlin.openapi.model.MailerSendMailResponse
import java.io.IOException
import okhttp3.Call
import okhttp3.HttpUrl

class MailerServiceApi(
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
   * Send an email to a user or any email address
   *
   * @param body
   * @return MailerSendMailResponse
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
  fun send(body: MailerMail): MailerSendMailResponse {
    val localVarResponse = sendWithHttpInfo(body = body)

    return when (localVarResponse.responseType) {
      ResponseType.Success -> (localVarResponse as Success<*>).data as MailerSendMailResponse
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
   * Send an email to a user or any email address
   *
   * @param body
   * @return ApiResponse<MailerSendMailResponse?>
   * @throws IllegalStateException If the request is not correctly configured
   * @throws IOException Rethrows the OkHttp execute method exception
   */
  @Suppress("UNCHECKED_CAST")
  @Throws(IllegalStateException::class, IOException::class)
  fun sendWithHttpInfo(body: MailerMail): ApiResponse<MailerSendMailResponse?> {
    val localVariableConfig = sendRequestConfig(body = body)

    return request<MailerMail, MailerSendMailResponse>(localVariableConfig)
  }

  /**
   * To obtain the request config of the operation send
   *
   * @param body
   * @return RequestConfig
   */
  fun sendRequestConfig(body: MailerMail): RequestConfig<MailerMail> {
    val localVariableBody = body
    val localVariableQuery: MultiValueMap = mutableMapOf()
    val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
    localVariableHeaders["Content-Type"] = "application/json"
    localVariableHeaders["Accept"] = "application/json"

    return RequestConfig(
        method = RequestMethod.POST,
        path = "/mailer/send",
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
