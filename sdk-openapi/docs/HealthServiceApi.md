# HealthServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**apiLive**](HealthServiceApi.md#apiLive) | **GET** /health/live | Check overall liveness of this API |
| [**apiPing**](HealthServiceApi.md#apiPing) | **GET** /health/ping | Does nothing except responding |
| [**apiReady**](HealthServiceApi.md#apiReady) | **GET** /health/ready | Check overally readyness ot this API, with details |
| [**serviceLive**](HealthServiceApi.md#serviceLive) | **GET** /health/{ServiceName}/live | Check overall liveness of this API |
| [**serviceReady**](HealthServiceApi.md#serviceReady) | **GET** /health/{ServiceName}/ready | Check overally readyness ot this API, with details |


<a id="apiLive"></a>
# **apiLive**
> RestHealthServiceResponse apiLive(serviceName)

Check overall liveness of this API

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = HealthServiceApi()
val serviceName : kotlin.String = serviceName_example // kotlin.String |
try {
    val result : RestHealthServiceResponse = apiInstance.apiLive(serviceName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthServiceApi#apiLive")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthServiceApi#apiLive")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **serviceName** | **kotlin.String**|  | [optional] |

### Return type

[**RestHealthServiceResponse**](RestHealthServiceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="apiPing"></a>
# **apiPing**
> RestHealthServiceResponse apiPing(serviceName)

Does nothing except responding

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = HealthServiceApi()
val serviceName : kotlin.String = serviceName_example // kotlin.String |
try {
    val result : RestHealthServiceResponse = apiInstance.apiPing(serviceName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthServiceApi#apiPing")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthServiceApi#apiPing")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **serviceName** | **kotlin.String**|  | [optional] |

### Return type

[**RestHealthServiceResponse**](RestHealthServiceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="apiReady"></a>
# **apiReady**
> RestHealthServiceResponse apiReady(serviceName)

Check overally readyness ot this API, with details

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = HealthServiceApi()
val serviceName : kotlin.String = serviceName_example // kotlin.String |
try {
    val result : RestHealthServiceResponse = apiInstance.apiReady(serviceName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthServiceApi#apiReady")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthServiceApi#apiReady")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **serviceName** | **kotlin.String**|  | [optional] |

### Return type

[**RestHealthServiceResponse**](RestHealthServiceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="serviceLive"></a>
# **serviceLive**
> RestHealthServiceResponse serviceLive(serviceName)

Check overall liveness of this API

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = HealthServiceApi()
val serviceName : kotlin.String = serviceName_example // kotlin.String |
try {
    val result : RestHealthServiceResponse = apiInstance.serviceLive(serviceName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthServiceApi#serviceLive")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthServiceApi#serviceLive")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **serviceName** | **kotlin.String**|  | |

### Return type

[**RestHealthServiceResponse**](RestHealthServiceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="serviceReady"></a>
# **serviceReady**
> RestHealthServiceResponse serviceReady(serviceName)

Check overally readyness ot this API, with details

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = HealthServiceApi()
val serviceName : kotlin.String = serviceName_example // kotlin.String |
try {
    val result : RestHealthServiceResponse = apiInstance.serviceReady(serviceName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling HealthServiceApi#serviceReady")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling HealthServiceApi#serviceReady")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **serviceName** | **kotlin.String**|  | |

### Return type

[**RestHealthServiceResponse**](RestHealthServiceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json
