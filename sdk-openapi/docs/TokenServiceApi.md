# TokenServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**generateDocumentAccessToken**](TokenServiceApi.md#generateDocumentAccessToken) | **POST** /auth/token/document | Generate a temporary access token for a specific document for the current user |
| [**resetPassword**](TokenServiceApi.md#resetPassword) | **POST** /auth/reset-password | Finish up the reset password process by providing the unique token |
| [**resetPasswordToken**](TokenServiceApi.md#resetPasswordToken) | **PUT** /auth/reset-password-token/{UserLogin} | Generate a unique token for the reset password process |
| [**revoke**](TokenServiceApi.md#revoke) | **POST** /auth/token/revoke | Revoke a JWT token |


<a id="generateDocumentAccessToken"></a>
# **generateDocumentAccessToken**
> RestDocumentAccessTokenResponse generateDocumentAccessToken(body)

Generate a temporary access token for a specific document for the current user

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TokenServiceApi()
val body : RestDocumentAccessTokenRequest =  // RestDocumentAccessTokenRequest |
try {
    val result : RestDocumentAccessTokenResponse = apiInstance.generateDocumentAccessToken(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TokenServiceApi#generateDocumentAccessToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TokenServiceApi#generateDocumentAccessToken")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestDocumentAccessTokenRequest**](RestDocumentAccessTokenRequest.md)|  | |

### Return type

[**RestDocumentAccessTokenResponse**](RestDocumentAccessTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="resetPassword"></a>
# **resetPassword**
> RestResetPasswordResponse resetPassword(body)

Finish up the reset password process by providing the unique token

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TokenServiceApi()
val body : RestResetPasswordRequest =  // RestResetPasswordRequest |
try {
    val result : RestResetPasswordResponse = apiInstance.resetPassword(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TokenServiceApi#resetPassword")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TokenServiceApi#resetPassword")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestResetPasswordRequest**](RestResetPasswordRequest.md)|  | |

### Return type

[**RestResetPasswordResponse**](RestResetPasswordResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="resetPasswordToken"></a>
# **resetPasswordToken**
> RestResetPasswordTokenResponse resetPasswordToken(userLogin, body)

Generate a unique token for the reset password process

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TokenServiceApi()
val userLogin : kotlin.String = userLogin_example // kotlin.String | Start a ResetPassword workflow for this user
val body : TokenServiceResetPasswordTokenBody =  // TokenServiceResetPasswordTokenBody |
try {
    val result : RestResetPasswordTokenResponse = apiInstance.resetPasswordToken(userLogin, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TokenServiceApi#resetPasswordToken")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TokenServiceApi#resetPasswordToken")
    e.printStackTrace()
}
```

### Parameters
| **userLogin** | **kotlin.String**| Start a ResetPassword workflow for this user | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**TokenServiceResetPasswordTokenBody**](TokenServiceResetPasswordTokenBody.md)|  | |

### Return type

[**RestResetPasswordTokenResponse**](RestResetPasswordTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="revoke"></a>
# **revoke**
> RestRevokeResponse revoke(body)

Revoke a JWT token

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = TokenServiceApi()
val body : RestRevokeRequest =  // RestRevokeRequest |
try {
    val result : RestRevokeResponse = apiInstance.revoke(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling TokenServiceApi#revoke")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling TokenServiceApi#revoke")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestRevokeRequest**](RestRevokeRequest.md)|  | |

### Return type

[**RestRevokeResponse**](RestRevokeResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
