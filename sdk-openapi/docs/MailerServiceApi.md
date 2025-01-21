# MailerServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**send**](MailerServiceApi.md#send) | **POST** /mailer/send | Send an email to a user or any email address |


<a id="send"></a>
# **send**
> MailerSendMailResponse send(body)

Send an email to a user or any email address

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = MailerServiceApi()
val body : MailerMail =  // MailerMail |
try {
    val result : MailerSendMailResponse = apiInstance.send(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling MailerServiceApi#send")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling MailerServiceApi#send")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**MailerMail**](MailerMail.md)|  | |

### Return type

[**MailerSendMailResponse**](MailerSendMailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
