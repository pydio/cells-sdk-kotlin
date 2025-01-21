# UpdateServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**applyUpdate**](UpdateServiceApi.md#applyUpdate) | **PATCH** /update/{TargetVersion} | Apply an update to a given version |
| [**updateRequired**](UpdateServiceApi.md#updateRequired) | **POST** /update | Check the remote server to see if there are available binaries |


<a id="applyUpdate"></a>
# **applyUpdate**
> UpdateApplyUpdateResponse applyUpdate(targetVersion, body)

Apply an update to a given version

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UpdateServiceApi()
val targetVersion : kotlin.String = targetVersion_example // kotlin.String | Version of the target binary
val body : UpdateApplyUpdateRequest =  // UpdateApplyUpdateRequest |
try {
    val result : UpdateApplyUpdateResponse = apiInstance.applyUpdate(targetVersion, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UpdateServiceApi#applyUpdate")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UpdateServiceApi#applyUpdate")
    e.printStackTrace()
}
```

### Parameters
| **targetVersion** | **kotlin.String**| Version of the target binary | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**UpdateApplyUpdateRequest**](UpdateApplyUpdateRequest.md)|  | |

### Return type

[**UpdateApplyUpdateResponse**](UpdateApplyUpdateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateRequired"></a>
# **updateRequired**
> UpdateUpdateResponse updateRequired(body)

Check the remote server to see if there are available binaries

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UpdateServiceApi()
val body : UpdateUpdateRequest =  // UpdateUpdateRequest |
try {
    val result : UpdateUpdateResponse = apiInstance.updateRequired(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UpdateServiceApi#updateRequired")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UpdateServiceApi#updateRequired")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**UpdateUpdateRequest**](UpdateUpdateRequest.md)|  | |

### Return type

[**UpdateUpdateResponse**](UpdateUpdateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
