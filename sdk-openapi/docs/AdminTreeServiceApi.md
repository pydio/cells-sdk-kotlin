# AdminTreeServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**listAdminTree**](AdminTreeServiceApi.md#listAdminTree) | **POST** /tree/admin/list | List files and folders starting at the root (first level lists the datasources) |
| [**statAdminTree**](AdminTreeServiceApi.md#statAdminTree) | **POST** /tree/admin/stat | Read a node information inside the admin tree |


<a id="listAdminTree"></a>
# **listAdminTree**
> RestNodesCollection listAdminTree(body)

List files and folders starting at the root (first level lists the datasources)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = AdminTreeServiceApi()
val body : TreeListNodesRequest =  // TreeListNodesRequest |
try {
    val result : RestNodesCollection = apiInstance.listAdminTree(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdminTreeServiceApi#listAdminTree")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdminTreeServiceApi#listAdminTree")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**TreeListNodesRequest**](TreeListNodesRequest.md)|  | |

### Return type

[**RestNodesCollection**](RestNodesCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="statAdminTree"></a>
# **statAdminTree**
> TreeReadNodeResponse statAdminTree(body)

Read a node information inside the admin tree

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = AdminTreeServiceApi()
val body : TreeReadNodeRequest =  // TreeReadNodeRequest |
try {
    val result : TreeReadNodeResponse = apiInstance.statAdminTree(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling AdminTreeServiceApi#statAdminTree")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling AdminTreeServiceApi#statAdminTree")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**TreeReadNodeRequest**](TreeReadNodeRequest.md)|  | |

### Return type

[**TreeReadNodeResponse**](TreeReadNodeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
