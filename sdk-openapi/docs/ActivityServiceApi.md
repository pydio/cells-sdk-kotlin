# ActivityServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**searchSubscriptions**](ActivityServiceApi.md#searchSubscriptions) | **POST** /activity/subscriptions | Load subscriptions to other users/nodes feeds |
| [**stream**](ActivityServiceApi.md#stream) | **POST** /activity/stream | Load the the feeds of the currently logged user |
| [**subscribe**](ActivityServiceApi.md#subscribe) | **POST** /activity/subscribe | Manage subscriptions to other users/nodes feeds |


<a id="searchSubscriptions"></a>
# **searchSubscriptions**
> RestSubscriptionsCollection searchSubscriptions(body)

Load subscriptions to other users/nodes feeds

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ActivityServiceApi()
val body : ActivitySearchSubscriptionsRequest =  // ActivitySearchSubscriptionsRequest |
try {
    val result : RestSubscriptionsCollection = apiInstance.searchSubscriptions(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ActivityServiceApi#searchSubscriptions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityServiceApi#searchSubscriptions")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**ActivitySearchSubscriptionsRequest**](ActivitySearchSubscriptionsRequest.md)|  | |

### Return type

[**RestSubscriptionsCollection**](RestSubscriptionsCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="stream"></a>
# **stream**
> ActivityObject stream(body)

Load the the feeds of the currently logged user

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ActivityServiceApi()
val body : ActivityStreamActivitiesRequest =  // ActivityStreamActivitiesRequest |
try {
    val result : ActivityObject = apiInstance.stream(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ActivityServiceApi#stream")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityServiceApi#stream")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**ActivityStreamActivitiesRequest**](ActivityStreamActivitiesRequest.md)|  | |

### Return type

[**ActivityObject**](ActivityObject.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="subscribe"></a>
# **subscribe**
> ActivitySubscription subscribe(body)

Manage subscriptions to other users/nodes feeds

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ActivityServiceApi()
val body : ActivitySubscription =  // ActivitySubscription |
try {
    val result : ActivitySubscription = apiInstance.subscribe(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ActivityServiceApi#subscribe")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ActivityServiceApi#subscribe")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**ActivitySubscription**](ActivitySubscription.md)|  | |

### Return type

[**ActivitySubscription**](ActivitySubscription.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
