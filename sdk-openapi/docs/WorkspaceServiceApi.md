# WorkspaceServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteWorkspace**](WorkspaceServiceApi.md#deleteWorkspace) | **DELETE** /workspace/{Slug} | Delete an existing workspace |
| [**putWorkspace**](WorkspaceServiceApi.md#putWorkspace) | **PUT** /workspace/{Slug} | Create or update a workspace |
| [**searchWorkspaces**](WorkspaceServiceApi.md#searchWorkspaces) | **POST** /workspace | Search workspaces on certain keys |


<a id="deleteWorkspace"></a>
# **deleteWorkspace**
> RestDeleteResponse deleteWorkspace(slug)

Delete an existing workspace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = WorkspaceServiceApi()
val slug : kotlin.String = slug_example // kotlin.String |
try {
    val result : RestDeleteResponse = apiInstance.deleteWorkspace(slug)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WorkspaceServiceApi#deleteWorkspace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WorkspaceServiceApi#deleteWorkspace")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **slug** | **kotlin.String**|  | |

### Return type

[**RestDeleteResponse**](RestDeleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="putWorkspace"></a>
# **putWorkspace**
> IdmWorkspace putWorkspace(slug, body)

Create or update a workspace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = WorkspaceServiceApi()
val slug : kotlin.String = slug_example // kotlin.String | Slug is an url-compatible form of the workspace label, or can be freely modified (max length 500)
val body : WorkspaceServicePutWorkspaceBody =  // WorkspaceServicePutWorkspaceBody |
try {
    val result : IdmWorkspace = apiInstance.putWorkspace(slug, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WorkspaceServiceApi#putWorkspace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WorkspaceServiceApi#putWorkspace")
    e.printStackTrace()
}
```

### Parameters
| **slug** | **kotlin.String**| Slug is an url-compatible form of the workspace label, or can be freely modified (max length 500) | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**WorkspaceServicePutWorkspaceBody**](WorkspaceServicePutWorkspaceBody.md)|  | |

### Return type

[**IdmWorkspace**](IdmWorkspace.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="searchWorkspaces"></a>
# **searchWorkspaces**
> RestWorkspaceCollection searchWorkspaces(body)

Search workspaces on certain keys

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = WorkspaceServiceApi()
val body : RestSearchWorkspaceRequest =  // RestSearchWorkspaceRequest |
try {
    val result : RestWorkspaceCollection = apiInstance.searchWorkspaces(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling WorkspaceServiceApi#searchWorkspaces")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling WorkspaceServiceApi#searchWorkspaces")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestSearchWorkspaceRequest**](RestSearchWorkspaceRequest.md)|  | |

### Return type

[**RestWorkspaceCollection**](RestWorkspaceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
