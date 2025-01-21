# GraphServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**recommend**](GraphServiceApi.md#recommend) | **POST** /graph/recommend |  |
| [**relation**](GraphServiceApi.md#relation) | **GET** /graph/relation/{UserId} | Compute relation of context user with another user |
| [**userState**](GraphServiceApi.md#userState) | **GET** /graph/state/{Segment} | Compute accessible workspaces for a given user |


<a id="recommend"></a>
# **recommend**
> RestRecommendResponse recommend(body)



### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = GraphServiceApi()
val body : RestRecommendRequest =  // RestRecommendRequest |
try {
    val result : RestRecommendResponse = apiInstance.recommend(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GraphServiceApi#recommend")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GraphServiceApi#recommend")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestRecommendRequest**](RestRecommendRequest.md)|  | |

### Return type

[**RestRecommendResponse**](RestRecommendResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="relation"></a>
# **relation**
> RestRelationResponse relation(userId)

Compute relation of context user with another user

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = GraphServiceApi()
val userId : kotlin.String = userId_example // kotlin.String |
try {
    val result : RestRelationResponse = apiInstance.relation(userId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GraphServiceApi#relation")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GraphServiceApi#relation")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **userId** | **kotlin.String**|  | |

### Return type

[**RestRelationResponse**](RestRelationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="userState"></a>
# **userState**
> RestUserStateResponse userState(segment)

Compute accessible workspaces for a given user

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = GraphServiceApi()
val segment : kotlin.String = segment_example // kotlin.String |
try {
    val result : RestUserStateResponse = apiInstance.userState(segment)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling GraphServiceApi#userState")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling GraphServiceApi#userState")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **segment** | **kotlin.String**|  | |

### Return type

[**RestUserStateResponse**](RestUserStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json
