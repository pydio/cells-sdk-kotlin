/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.pydio.kotlin.openapi.api

import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.HttpUrl

import com.pydio.kotlin.openapi.model.RestCell
import com.pydio.kotlin.openapi.model.RestDeleteCellResponse
import com.pydio.kotlin.openapi.model.RestDeleteShareLinkResponse
import com.pydio.kotlin.openapi.model.RestError
import com.pydio.kotlin.openapi.model.RestListSharedResourcesRequest
import com.pydio.kotlin.openapi.model.RestListSharedResourcesResponse
import com.pydio.kotlin.openapi.model.RestPutCellRequest
import com.pydio.kotlin.openapi.model.RestPutShareLinkRequest
import com.pydio.kotlin.openapi.model.RestShareLink
import com.pydio.kotlin.openapi.model.RestUpdateSharePoliciesRequest
import com.pydio.kotlin.openapi.model.RestUpdateSharePoliciesResponse

import com.squareup.moshi.Json

import com.pydio.kotlin.openapi.infrastructure.ApiClient
import com.pydio.kotlin.openapi.infrastructure.ApiResponse
import com.pydio.kotlin.openapi.infrastructure.ClientException
import com.pydio.kotlin.openapi.infrastructure.ClientError
import com.pydio.kotlin.openapi.infrastructure.ServerException
import com.pydio.kotlin.openapi.infrastructure.ServerError
import com.pydio.kotlin.openapi.infrastructure.MultiValueMap
import com.pydio.kotlin.openapi.infrastructure.PartConfig
import com.pydio.kotlin.openapi.infrastructure.RequestConfig
import com.pydio.kotlin.openapi.infrastructure.RequestMethod
import com.pydio.kotlin.openapi.infrastructure.ResponseType
import com.pydio.kotlin.openapi.infrastructure.Success
import com.pydio.kotlin.openapi.infrastructure.toMultiValue

class ShareServiceApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
     * Delete a share room
     * 
     * @param uuid Cell Uuid
     * @return RestDeleteCellResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun deleteCell(uuid: kotlin.String) : RestDeleteCellResponse {
        val localVarResponse = deleteCellWithHttpInfo(uuid = uuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestDeleteCellResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Delete a share room
     * 
     * @param uuid Cell Uuid
     * @return ApiResponse<RestDeleteCellResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun deleteCellWithHttpInfo(uuid: kotlin.String) : ApiResponse<RestDeleteCellResponse?> {
        val localVariableConfig = deleteCellRequestConfig(uuid = uuid)

        return request<Unit, RestDeleteCellResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation deleteCell
     *
     * @param uuid Cell Uuid
     * @return RequestConfig
     */
    fun deleteCellRequestConfig(uuid: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/share/cell/{Uuid}".replace("{"+"Uuid"+"}", encodeURIComponent(uuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Delete Share Link
     * 
     * @param uuid Id of Link to delete
     * @return RestDeleteShareLinkResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun deleteShareLink(uuid: kotlin.String) : RestDeleteShareLinkResponse {
        val localVarResponse = deleteShareLinkWithHttpInfo(uuid = uuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestDeleteShareLinkResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Delete Share Link
     * 
     * @param uuid Id of Link to delete
     * @return ApiResponse<RestDeleteShareLinkResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun deleteShareLinkWithHttpInfo(uuid: kotlin.String) : ApiResponse<RestDeleteShareLinkResponse?> {
        val localVariableConfig = deleteShareLinkRequestConfig(uuid = uuid)

        return request<Unit, RestDeleteShareLinkResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation deleteShareLink
     *
     * @param uuid Id of Link to delete
     * @return RequestConfig
     */
    fun deleteShareLinkRequestConfig(uuid: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/share/link/{Uuid}".replace("{"+"Uuid"+"}", encodeURIComponent(uuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Load a share room
     * 
     * @param uuid Cell Uuid
     * @return RestCell
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getCell(uuid: kotlin.String) : RestCell {
        val localVarResponse = getCellWithHttpInfo(uuid = uuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestCell
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Load a share room
     * 
     * @param uuid Cell Uuid
     * @return ApiResponse<RestCell?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getCellWithHttpInfo(uuid: kotlin.String) : ApiResponse<RestCell?> {
        val localVariableConfig = getCellRequestConfig(uuid = uuid)

        return request<Unit, RestCell>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getCell
     *
     * @param uuid Cell Uuid
     * @return RequestConfig
     */
    fun getCellRequestConfig(uuid: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/share/cell/{Uuid}".replace("{"+"Uuid"+"}", encodeURIComponent(uuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Load a share link with all infos
     * 
     * @param uuid Link Uuid
     * @return RestShareLink
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun getShareLink(uuid: kotlin.String) : RestShareLink {
        val localVarResponse = getShareLinkWithHttpInfo(uuid = uuid)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestShareLink
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Load a share link with all infos
     * 
     * @param uuid Link Uuid
     * @return ApiResponse<RestShareLink?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun getShareLinkWithHttpInfo(uuid: kotlin.String) : ApiResponse<RestShareLink?> {
        val localVariableConfig = getShareLinkRequestConfig(uuid = uuid)

        return request<Unit, RestShareLink>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation getShareLink
     *
     * @param uuid Link Uuid
     * @return RequestConfig
     */
    fun getShareLinkRequestConfig(uuid: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/share/link/{Uuid}".replace("{"+"Uuid"+"}", encodeURIComponent(uuid.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * List Shared Resources for current user or all users
     * 
     * @param body 
     * @return RestListSharedResourcesResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun listSharedResources(body: RestListSharedResourcesRequest) : RestListSharedResourcesResponse {
        val localVarResponse = listSharedResourcesWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestListSharedResourcesResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * List Shared Resources for current user or all users
     * 
     * @param body 
     * @return ApiResponse<RestListSharedResourcesResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun listSharedResourcesWithHttpInfo(body: RestListSharedResourcesRequest) : ApiResponse<RestListSharedResourcesResponse?> {
        val localVariableConfig = listSharedResourcesRequestConfig(body = body)

        return request<RestListSharedResourcesRequest, RestListSharedResourcesResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation listSharedResources
     *
     * @param body 
     * @return RequestConfig
     */
    fun listSharedResourcesRequestConfig(body: RestListSharedResourcesRequest) : RequestConfig<RestListSharedResourcesRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/share/resources",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Put or Create a share room
     * 
     * @param body 
     * @return RestCell
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun putCell(body: RestPutCellRequest) : RestCell {
        val localVarResponse = putCellWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestCell
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Put or Create a share room
     * 
     * @param body 
     * @return ApiResponse<RestCell?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun putCellWithHttpInfo(body: RestPutCellRequest) : ApiResponse<RestCell?> {
        val localVariableConfig = putCellRequestConfig(body = body)

        return request<RestPutCellRequest, RestCell>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation putCell
     *
     * @param body 
     * @return RequestConfig
     */
    fun putCellRequestConfig(body: RestPutCellRequest) : RequestConfig<RestPutCellRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/share/cell",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Put or Create a share room
     * 
     * @param body 
     * @return RestShareLink
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun putShareLink(body: RestPutShareLinkRequest) : RestShareLink {
        val localVarResponse = putShareLinkWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestShareLink
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Put or Create a share room
     * 
     * @param body 
     * @return ApiResponse<RestShareLink?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun putShareLinkWithHttpInfo(body: RestPutShareLinkRequest) : ApiResponse<RestShareLink?> {
        val localVariableConfig = putShareLinkRequestConfig(body = body)

        return request<RestPutShareLinkRequest, RestShareLink>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation putShareLink
     *
     * @param body 
     * @return RequestConfig
     */
    fun putShareLinkRequestConfig(body: RestPutShareLinkRequest) : RequestConfig<RestPutShareLinkRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/share/link",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Updates policies associated to the underlying workspace for a Cell or a ShareLink
     * 
     * @param body 
     * @return RestUpdateSharePoliciesResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun updateSharePolicies(body: RestUpdateSharePoliciesRequest) : RestUpdateSharePoliciesResponse {
        val localVarResponse = updateSharePoliciesWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestUpdateSharePoliciesResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()} ${localVarError.body}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Updates policies associated to the underlying workspace for a Cell or a ShareLink
     * 
     * @param body 
     * @return ApiResponse<RestUpdateSharePoliciesResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun updateSharePoliciesWithHttpInfo(body: RestUpdateSharePoliciesRequest) : ApiResponse<RestUpdateSharePoliciesResponse?> {
        val localVariableConfig = updateSharePoliciesRequestConfig(body = body)

        return request<RestUpdateSharePoliciesRequest, RestUpdateSharePoliciesResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation updateSharePolicies
     *
     * @param body 
     * @return RequestConfig
     */
    fun updateSharePoliciesRequestConfig(body: RestUpdateSharePoliciesRequest) : RequestConfig<RestUpdateSharePoliciesRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/share/policies",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
