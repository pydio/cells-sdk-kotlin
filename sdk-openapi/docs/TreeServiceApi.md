# TreeServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**bulkStatNodes**](TreeServiceApi.md#bulkStatNodes) | **POST** /tree/stats | List meta for a list of nodes, or a full directory using /path/_* syntax |
| [**createNodes**](TreeServiceApi.md#createNodes) | **POST** /tree/create | Create dirs or empty files inside the tree |
| [**createSelection**](TreeServiceApi.md#createSelection) | **POST** /tree/selection | Create a temporary selection for further action (namely download) |
| [**deleteNodes**](TreeServiceApi.md#deleteNodes) | **POST** /tree/delete | Handle nodes deletion |
| [**headNode**](TreeServiceApi.md#headNode) | **GET** /tree/stat/{Node} | Return node meta without the node content itself |
| [**restoreNodes**](TreeServiceApi.md#restoreNodes) | **POST** /tree/restore | Handle nodes restoration from recycle bin |


<a id="bulkStatNodes"></a>
# **bulkStatNodes**
> RestBulkMetaResponse bulkStatNodes(body)

List meta for a list of nodes, or a full directory using /path/_* syntax

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TreeServiceApi()
val body : RestGetBulkMetaRequest =  // RestGetBulkMetaRequest |
try {
    val result : RestBulkMetaResponse = apiInstance.bulkStatNodes(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TreeServiceApi#bulkStatNodes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TreeServiceApi#bulkStatNodes")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestGetBulkMetaRequest**](RestGetBulkMetaRequest.md)|  | |

### Return type

[**RestBulkMetaResponse**](RestBulkMetaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createNodes"></a>
# **createNodes**
> RestNodesCollection createNodes(body)

Create dirs or empty files inside the tree

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TreeServiceApi()
val body : RestCreateNodesRequest =  // RestCreateNodesRequest |
try {
    val result : RestNodesCollection = apiInstance.createNodes(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TreeServiceApi#createNodes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TreeServiceApi#createNodes")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestCreateNodesRequest**](RestCreateNodesRequest.md)|  | |

### Return type

[**RestNodesCollection**](RestNodesCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createSelection"></a>
# **createSelection**
> RestCreateSelectionResponse createSelection(body)

Create a temporary selection for further action (namely download)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TreeServiceApi()
val body : RestCreateSelectionRequest =  // RestCreateSelectionRequest |
try {
    val result : RestCreateSelectionResponse = apiInstance.createSelection(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TreeServiceApi#createSelection")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TreeServiceApi#createSelection")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestCreateSelectionRequest**](RestCreateSelectionRequest.md)|  | |

### Return type

[**RestCreateSelectionResponse**](RestCreateSelectionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteNodes"></a>
# **deleteNodes**
> RestDeleteNodesResponse deleteNodes(body)

Handle nodes deletion

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TreeServiceApi()
val body : RestDeleteNodesRequest =  // RestDeleteNodesRequest |
try {
    val result : RestDeleteNodesResponse = apiInstance.deleteNodes(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TreeServiceApi#deleteNodes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TreeServiceApi#deleteNodes")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestDeleteNodesRequest**](RestDeleteNodesRequest.md)|  | |

### Return type

[**RestDeleteNodesResponse**](RestDeleteNodesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="headNode"></a>
# **headNode**
> RestHeadNodeResponse headNode(node)

Return node meta without the node content itself

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TreeServiceApi()
val node : kotlin.String = node_example // kotlin.String | The node to state
try {
    val result : RestHeadNodeResponse = apiInstance.headNode(node)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TreeServiceApi#headNode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TreeServiceApi#headNode")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **node** | **kotlin.String**| The node to state | |

### Return type

[**RestHeadNodeResponse**](RestHeadNodeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="restoreNodes"></a>
# **restoreNodes**
> RestRestoreNodesResponse restoreNodes(body)

Handle nodes restoration from recycle bin

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TreeServiceApi()
val body : RestRestoreNodesRequest =  // RestRestoreNodesRequest |
try {
    val result : RestRestoreNodesResponse = apiInstance.restoreNodes(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TreeServiceApi#restoreNodes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TreeServiceApi#restoreNodes")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestRestoreNodesRequest**](RestRestoreNodesRequest.md)|  | |

### Return type

[**RestRestoreNodesResponse**](RestRestoreNodesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
