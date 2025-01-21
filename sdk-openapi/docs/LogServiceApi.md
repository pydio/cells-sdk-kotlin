# LogServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**syslog**](LogServiceApi.md#syslog) | **POST** /log/sys | Technical Logs, in Json or CSV format |


<a id="syslog"></a>
# **syslog**
> RestLogMessageCollection syslog(body)

Technical Logs, in Json or CSV format

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = LogServiceApi()
val body : LogListLogRequest =  // LogListLogRequest | ListLogRequest launches a parameterised query in the log repository and streams the results.
try {
    val result : RestLogMessageCollection = apiInstance.syslog(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling LogServiceApi#syslog")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling LogServiceApi#syslog")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**LogListLogRequest**](LogListLogRequest.md)| ListLogRequest launches a parameterised query in the log repository and streams the results. | |

### Return type

[**RestLogMessageCollection**](RestLogMessageCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
