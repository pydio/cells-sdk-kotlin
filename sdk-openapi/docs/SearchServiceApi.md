# SearchServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**nodes**](SearchServiceApi.md#nodes) | **POST** /search/nodes | Search indexed nodes (files/folders) on various aspects |


<a id="nodes"></a>
# **nodes**
> RestSearchResults nodes(body)

Search indexed nodes (files/folders) on various aspects

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = SearchServiceApi()
val body : TreeSearchRequest =  // TreeSearchRequest |
try {
    val result : RestSearchResults = apiInstance.nodes(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling SearchServiceApi#nodes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling SearchServiceApi#nodes")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**TreeSearchRequest**](TreeSearchRequest.md)|  | |

### Return type

[**RestSearchResults**](RestSearchResults.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
