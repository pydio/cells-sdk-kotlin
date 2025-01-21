# MetaServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteMeta**](MetaServiceApi.md#deleteMeta) | **POST** /meta/delete/{NodePath} | Delete metadata of a given node |
| [**getBulkMeta**](MetaServiceApi.md#getBulkMeta) | **POST** /meta/bulk/get | List meta for a list of nodes, or a full directory using /path/_* syntax |
| [**getMeta**](MetaServiceApi.md#getMeta) | **POST** /meta/get/{NodePath} | Load metadata for a given node |
| [**setMeta**](MetaServiceApi.md#setMeta) | **POST** /meta/set/{NodePath} | Update metadata for a given node |


<a id="deleteMeta"></a>
# **deleteMeta**
> TreeNode deleteMeta(nodePath, body)

Delete metadata of a given node

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = MetaServiceApi()
val nodePath : kotlin.String = nodePath_example // kotlin.String | Path to the requested node
val body : RestMetaNamespaceRequest =  // RestMetaNamespaceRequest |
try {
    val result : TreeNode = apiInstance.deleteMeta(nodePath, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MetaServiceApi#deleteMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MetaServiceApi#deleteMeta")
    e.printStackTrace()
}
```

### Parameters
| **nodePath** | **kotlin.String**| Path to the requested node | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestMetaNamespaceRequest**](RestMetaNamespaceRequest.md)|  | |

### Return type

[**TreeNode**](TreeNode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="getBulkMeta"></a>
# **getBulkMeta**
> RestBulkMetaResponse getBulkMeta(body)

List meta for a list of nodes, or a full directory using /path/_* syntax

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = MetaServiceApi()
val body : RestGetBulkMetaRequest =  // RestGetBulkMetaRequest |
try {
    val result : RestBulkMetaResponse = apiInstance.getBulkMeta(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MetaServiceApi#getBulkMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MetaServiceApi#getBulkMeta")
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

<a id="getMeta"></a>
# **getMeta**
> TreeNode getMeta(nodePath, body)

Load metadata for a given node

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = MetaServiceApi()
val nodePath : kotlin.String = nodePath_example // kotlin.String | Path to the requested node
val body : RestMetaNamespaceRequest =  // RestMetaNamespaceRequest |
try {
    val result : TreeNode = apiInstance.getMeta(nodePath, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MetaServiceApi#getMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MetaServiceApi#getMeta")
    e.printStackTrace()
}
```

### Parameters
| **nodePath** | **kotlin.String**| Path to the requested node | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestMetaNamespaceRequest**](RestMetaNamespaceRequest.md)|  | |

### Return type

[**TreeNode**](TreeNode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="setMeta"></a>
# **setMeta**
> TreeNode setMeta(nodePath, body)

Update metadata for a given node

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = MetaServiceApi()
val nodePath : kotlin.String = nodePath_example // kotlin.String |
val body : RestMetaCollection =  // RestMetaCollection |
try {
    val result : TreeNode = apiInstance.setMeta(nodePath, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MetaServiceApi#setMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MetaServiceApi#setMeta")
    e.printStackTrace()
}
```

### Parameters
| **nodePath** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestMetaCollection**](RestMetaCollection.md)|  | |

### Return type

[**TreeNode**](TreeNode.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
