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

import com.pydio.kotlin.openapi.model.RestBulkMetaResponse
import com.pydio.kotlin.openapi.model.RestCreateNodesRequest
import com.pydio.kotlin.openapi.model.RestCreateSelectionRequest
import com.pydio.kotlin.openapi.model.RestCreateSelectionResponse
import com.pydio.kotlin.openapi.model.RestDeleteNodesRequest
import com.pydio.kotlin.openapi.model.RestDeleteNodesResponse
import com.pydio.kotlin.openapi.model.RestError
import com.pydio.kotlin.openapi.model.RestGetBulkMetaRequest
import com.pydio.kotlin.openapi.model.RestHeadNodeResponse
import com.pydio.kotlin.openapi.model.RestNodesCollection
import com.pydio.kotlin.openapi.model.RestRestoreNodesRequest
import com.pydio.kotlin.openapi.model.RestRestoreNodesResponse

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

class TreeServiceApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
     * List meta for a list of nodes, or a full directory using /path/_* syntax
     * 
     * @param body 
     * @return RestBulkMetaResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun bulkStatNodes(body: RestGetBulkMetaRequest) : RestBulkMetaResponse {
        val localVarResponse = bulkStatNodesWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestBulkMetaResponse
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
     * List meta for a list of nodes, or a full directory using /path/_* syntax
     * 
     * @param body 
     * @return ApiResponse<RestBulkMetaResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun bulkStatNodesWithHttpInfo(body: RestGetBulkMetaRequest) : ApiResponse<RestBulkMetaResponse?> {
        val localVariableConfig = bulkStatNodesRequestConfig(body = body)

        return request<RestGetBulkMetaRequest, RestBulkMetaResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation bulkStatNodes
     *
     * @param body 
     * @return RequestConfig
     */
    fun bulkStatNodesRequestConfig(body: RestGetBulkMetaRequest) : RequestConfig<RestGetBulkMetaRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/tree/stats",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Create dirs or empty files inside the tree
     * 
     * @param body 
     * @return RestNodesCollection
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun createNodes(body: RestCreateNodesRequest) : RestNodesCollection {
        val localVarResponse = createNodesWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestNodesCollection
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
     * Create dirs or empty files inside the tree
     * 
     * @param body 
     * @return ApiResponse<RestNodesCollection?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun createNodesWithHttpInfo(body: RestCreateNodesRequest) : ApiResponse<RestNodesCollection?> {
        val localVariableConfig = createNodesRequestConfig(body = body)

        return request<RestCreateNodesRequest, RestNodesCollection>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation createNodes
     *
     * @param body 
     * @return RequestConfig
     */
    fun createNodesRequestConfig(body: RestCreateNodesRequest) : RequestConfig<RestCreateNodesRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/tree/create",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Create a temporary selection for further action (namely download)
     * 
     * @param body 
     * @return RestCreateSelectionResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun createSelection(body: RestCreateSelectionRequest) : RestCreateSelectionResponse {
        val localVarResponse = createSelectionWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestCreateSelectionResponse
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
     * Create a temporary selection for further action (namely download)
     * 
     * @param body 
     * @return ApiResponse<RestCreateSelectionResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun createSelectionWithHttpInfo(body: RestCreateSelectionRequest) : ApiResponse<RestCreateSelectionResponse?> {
        val localVariableConfig = createSelectionRequestConfig(body = body)

        return request<RestCreateSelectionRequest, RestCreateSelectionResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation createSelection
     *
     * @param body 
     * @return RequestConfig
     */
    fun createSelectionRequestConfig(body: RestCreateSelectionRequest) : RequestConfig<RestCreateSelectionRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/tree/selection",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Handle nodes deletion
     * 
     * @param body 
     * @return RestDeleteNodesResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun deleteNodes(body: RestDeleteNodesRequest) : RestDeleteNodesResponse {
        val localVarResponse = deleteNodesWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestDeleteNodesResponse
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
     * Handle nodes deletion
     * 
     * @param body 
     * @return ApiResponse<RestDeleteNodesResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun deleteNodesWithHttpInfo(body: RestDeleteNodesRequest) : ApiResponse<RestDeleteNodesResponse?> {
        val localVariableConfig = deleteNodesRequestConfig(body = body)

        return request<RestDeleteNodesRequest, RestDeleteNodesResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation deleteNodes
     *
     * @param body 
     * @return RequestConfig
     */
    fun deleteNodesRequestConfig(body: RestDeleteNodesRequest) : RequestConfig<RestDeleteNodesRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/tree/delete",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Return node meta without the node content itself
     * 
     * @param node The node to state
     * @return RestHeadNodeResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun headNode(node: kotlin.String) : RestHeadNodeResponse {
        val localVarResponse = headNodeWithHttpInfo(node = node)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestHeadNodeResponse
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
     * Return node meta without the node content itself
     * 
     * @param node The node to state
     * @return ApiResponse<RestHeadNodeResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun headNodeWithHttpInfo(node: kotlin.String) : ApiResponse<RestHeadNodeResponse?> {
        val localVariableConfig = headNodeRequestConfig(node = node)

        return request<Unit, RestHeadNodeResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation headNode
     *
     * @param node The node to state
     * @return RequestConfig
     */
    fun headNodeRequestConfig(node: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/tree/stat/{Node}".replace("{"+"Node"+"}", encodeURIComponent(node.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Handle nodes restoration from recycle bin
     * 
     * @param body 
     * @return RestRestoreNodesResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun restoreNodes(body: RestRestoreNodesRequest) : RestRestoreNodesResponse {
        val localVarResponse = restoreNodesWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestRestoreNodesResponse
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
     * Handle nodes restoration from recycle bin
     * 
     * @param body 
     * @return ApiResponse<RestRestoreNodesResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun restoreNodesWithHttpInfo(body: RestRestoreNodesRequest) : ApiResponse<RestRestoreNodesResponse?> {
        val localVariableConfig = restoreNodesRequestConfig(body = body)

        return request<RestRestoreNodesRequest, RestRestoreNodesResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation restoreNodes
     *
     * @param body 
     * @return RequestConfig
     */
    fun restoreNodesRequestConfig(body: RestRestoreNodesRequest) : RequestConfig<RestRestoreNodesRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/tree/restore",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
