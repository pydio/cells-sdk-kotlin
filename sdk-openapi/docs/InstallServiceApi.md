# InstallServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**getAgreement**](InstallServiceApi.md#getAgreement) | **GET** /install/agreement | Load a textual agreement for using the software |
| [**getInstall**](InstallServiceApi.md#getInstall) | **GET** /install | Loads default values for install form |
| [**installEvents**](InstallServiceApi.md#installEvents) | **GET** /install/events |  |
| [**performInstallCheck**](InstallServiceApi.md#performInstallCheck) | **POST** /install/check | Perform a check during install (like a valid DB connection) |
| [**postInstall**](InstallServiceApi.md#postInstall) | **POST** /install | Post values to be saved for install |


<a id="getAgreement"></a>
# **getAgreement**
> InstallGetAgreementResponse getAgreement()

Load a textual agreement for using the software

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = InstallServiceApi()
try {
    val result : InstallGetAgreementResponse = apiInstance.getAgreement()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InstallServiceApi#getAgreement")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstallServiceApi#getAgreement")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InstallGetAgreementResponse**](InstallGetAgreementResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getInstall"></a>
# **getInstall**
> InstallGetDefaultsResponse getInstall()

Loads default values for install form

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = InstallServiceApi()
try {
    val result : InstallGetDefaultsResponse = apiInstance.getInstall()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InstallServiceApi#getInstall")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstallServiceApi#getInstall")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InstallGetDefaultsResponse**](InstallGetDefaultsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="installEvents"></a>
# **installEvents**
> InstallInstallEventsResponse installEvents()



### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = InstallServiceApi()
try {
    val result : InstallInstallEventsResponse = apiInstance.installEvents()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InstallServiceApi#installEvents")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstallServiceApi#installEvents")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**InstallInstallEventsResponse**](InstallInstallEventsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="performInstallCheck"></a>
# **performInstallCheck**
> InstallPerformCheckResponse performInstallCheck(body)

Perform a check during install (like a valid DB connection)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = InstallServiceApi()
val body : InstallPerformCheckRequest =  // InstallPerformCheckRequest |
try {
    val result : InstallPerformCheckResponse = apiInstance.performInstallCheck(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InstallServiceApi#performInstallCheck")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstallServiceApi#performInstallCheck")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**InstallPerformCheckRequest**](InstallPerformCheckRequest.md)|  | |

### Return type

[**InstallPerformCheckResponse**](InstallPerformCheckResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="postInstall"></a>
# **postInstall**
> InstallInstallResponse postInstall(body)

Post values to be saved for install

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = InstallServiceApi()
val body : InstallInstallRequest =  // InstallInstallRequest |
try {
    val result : InstallInstallResponse = apiInstance.postInstall(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling InstallServiceApi#postInstall")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling InstallServiceApi#postInstall")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**InstallInstallRequest**](InstallInstallRequest.md)|  | |

### Return type

[**InstallInstallResponse**](InstallInstallResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
