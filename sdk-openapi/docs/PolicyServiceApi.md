# PolicyServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**listPolicies**](PolicyServiceApi.md#listPolicies) | **POST** /policy | List all defined security policies |


<a id="listPolicies"></a>
# **listPolicies**
> IdmListPolicyGroupsResponse listPolicies(body)

List all defined security policies

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = PolicyServiceApi()
val body : IdmListPolicyGroupsRequest =  // IdmListPolicyGroupsRequest |
try {
    val result : IdmListPolicyGroupsResponse = apiInstance.listPolicies(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling PolicyServiceApi#listPolicies")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling PolicyServiceApi#listPolicies")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**IdmListPolicyGroupsRequest**](IdmListPolicyGroupsRequest.md)|  | |

### Return type

[**IdmListPolicyGroupsResponse**](IdmListPolicyGroupsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
