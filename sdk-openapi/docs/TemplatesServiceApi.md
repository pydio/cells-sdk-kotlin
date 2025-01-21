# TemplatesServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**listTemplates**](TemplatesServiceApi.md#listTemplates) | **GET** /templates | List available templates |


<a id="listTemplates"></a>
# **listTemplates**
> RestListTemplatesResponse listTemplates(templateType)

List available templates

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TemplatesServiceApi()
val templateType : kotlin.String = templateType_example // kotlin.String |
try {
    val result : RestListTemplatesResponse = apiInstance.listTemplates(templateType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TemplatesServiceApi#listTemplates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TemplatesServiceApi#listTemplates")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **templateType** | **kotlin.String**|  | [optional] |

### Return type

[**RestListTemplatesResponse**](RestListTemplatesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json
