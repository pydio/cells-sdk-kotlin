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

import com.pydio.kotlin.openapi.model.IdmACL
import com.pydio.kotlin.openapi.model.RestACLCollection
import com.pydio.kotlin.openapi.model.RestDeleteResponse
import com.pydio.kotlin.openapi.model.RestError
import com.pydio.kotlin.openapi.model.RestSearchACLRequest

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

class ACLServiceApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "http://localhost")
        }
    }

    /**
     * Delete one or more ACLs
     * 
     * @param body ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
     * @return RestDeleteResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun deleteAcl(body: IdmACL) : RestDeleteResponse {
        val localVarResponse = deleteAclWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestDeleteResponse
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
     * Delete one or more ACLs
     * 
     * @param body ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
     * @return ApiResponse<RestDeleteResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun deleteAclWithHttpInfo(body: IdmACL) : ApiResponse<RestDeleteResponse?> {
        val localVariableConfig = deleteAclRequestConfig(body = body)

        return request<IdmACL, RestDeleteResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation deleteAcl
     *
     * @param body ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
     * @return RequestConfig
     */
    fun deleteAclRequestConfig(body: IdmACL) : RequestConfig<IdmACL> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/acl/bulk/delete",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Store an ACL
     * 
     * @param body ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
     * @return IdmACL
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun putAcl(body: IdmACL) : IdmACL {
        val localVarResponse = putAclWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as IdmACL
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
     * Store an ACL
     * 
     * @param body ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
     * @return ApiResponse<IdmACL?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun putAclWithHttpInfo(body: IdmACL) : ApiResponse<IdmACL?> {
        val localVariableConfig = putAclRequestConfig(body = body)

        return request<IdmACL, IdmACL>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation putAcl
     *
     * @param body ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
     * @return RequestConfig
     */
    fun putAclRequestConfig(body: IdmACL) : RequestConfig<IdmACL> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/acl",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

    /**
     * Search Acls
     * 
     * @param body 
     * @return RestACLCollection
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun searchAcls(body: RestSearchACLRequest) : RestACLCollection {
        val localVarResponse = searchAclsWithHttpInfo(body = body)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as RestACLCollection
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
     * Search Acls
     * 
     * @param body 
     * @return ApiResponse<RestACLCollection?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun searchAclsWithHttpInfo(body: RestSearchACLRequest) : ApiResponse<RestACLCollection?> {
        val localVariableConfig = searchAclsRequestConfig(body = body)

        return request<RestSearchACLRequest, RestACLCollection>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation searchAcls
     *
     * @param body 
     * @return RequestConfig
     */
    fun searchAclsRequestConfig(body: RestSearchACLRequest) : RequestConfig<RestSearchACLRequest> {
        val localVariableBody = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/acl",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    private fun encodeURIComponent(uriComponent: kotlin.String): kotlin.String =
        HttpUrl.Builder().scheme("http").host("localhost").addPathSegment(uriComponent).build().encodedPathSegments[0]
}
