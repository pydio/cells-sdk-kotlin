# FrontendServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**frontBootConf**](FrontendServiceApi.md#frontBootConf) | **GET** /frontend/bootconf | Add some data to the initial set of parameters loaded by the frontend |
| [**frontEnrollAuth**](FrontendServiceApi.md#frontEnrollAuth) | **POST** /frontend/enroll | Generic endpoint that can be implemented by 2FA systems for enrollment |
| [**frontMessages**](FrontendServiceApi.md#frontMessages) | **GET** /frontend/messages/{Lang} | Serve list of I18n messages |
| [**frontPlugins**](FrontendServiceApi.md#frontPlugins) | **GET** /frontend/plugins/{Lang} | Serve list of I18n messages |
| [**frontPutBinary**](FrontendServiceApi.md#frontPutBinary) | **POST** /frontend/binaries/{BinaryType}/{Uuid} | Upload frontend binaries (avatars / logos / bg images) |
| [**frontServeBinary**](FrontendServiceApi.md#frontServeBinary) | **GET** /frontend/binaries/{BinaryType}/{Uuid} | Serve frontend binaries directly (avatars / logos / bg images) |
| [**frontSession**](FrontendServiceApi.md#frontSession) | **POST** /frontend/session | Handle JWT |
| [**frontState**](FrontendServiceApi.md#frontState) | **GET** /frontend/state | Send XML state registry |
| [**settingsMenu**](FrontendServiceApi.md#settingsMenu) | **GET** /frontend/settings-menu | Sends a tree of nodes to be used a menu in the Settings panel |


<a id="frontBootConf"></a>
# **frontBootConf**
> RestFrontBootConfResponse frontBootConf()

Add some data to the initial set of parameters loaded by the frontend

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
try {
    val result : RestFrontBootConfResponse = apiInstance.frontBootConf()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontBootConf")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontBootConf")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestFrontBootConfResponse**](RestFrontBootConfResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="frontEnrollAuth"></a>
# **frontEnrollAuth**
> RestFrontEnrollAuthResponse frontEnrollAuth(body)

Generic endpoint that can be implemented by 2FA systems for enrollment

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
val body : RestFrontEnrollAuthRequest =  // RestFrontEnrollAuthRequest |
try {
    val result : RestFrontEnrollAuthResponse = apiInstance.frontEnrollAuth(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontEnrollAuth")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontEnrollAuth")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestFrontEnrollAuthRequest**](RestFrontEnrollAuthRequest.md)|  | |

### Return type

[**RestFrontEnrollAuthResponse**](RestFrontEnrollAuthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="frontMessages"></a>
# **frontMessages**
> RestFrontMessagesResponse frontMessages(lang)

Serve list of I18n messages

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
val lang : kotlin.String = lang_example // kotlin.String |
try {
    val result : RestFrontMessagesResponse = apiInstance.frontMessages(lang)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontMessages")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontMessages")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **lang** | **kotlin.String**|  | |

### Return type

[**RestFrontMessagesResponse**](RestFrontMessagesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="frontPlugins"></a>
# **frontPlugins**
> RestFrontPluginsResponse frontPlugins(lang)

Serve list of I18n messages

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
val lang : kotlin.String = lang_example // kotlin.String |
try {
    val result : RestFrontPluginsResponse = apiInstance.frontPlugins(lang)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontPlugins")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontPlugins")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **lang** | **kotlin.String**|  | |

### Return type

[**RestFrontPluginsResponse**](RestFrontPluginsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="frontPutBinary"></a>
# **frontPutBinary**
> RestFrontBinaryResponse frontPutBinary(binaryType, uuid)

Upload frontend binaries (avatars / logos / bg images)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
val binaryType : kotlin.String = binaryType_example // kotlin.String | Currently supported values are USER and GLOBAL
val uuid : kotlin.String = uuid_example // kotlin.String | Id of the binary
try {
    val result : RestFrontBinaryResponse = apiInstance.frontPutBinary(binaryType, uuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontPutBinary")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontPutBinary")
    e.printStackTrace()
}
```

### Parameters
| **binaryType** | **kotlin.String**| Currently supported values are USER and GLOBAL | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **uuid** | **kotlin.String**| Id of the binary | |

### Return type

[**RestFrontBinaryResponse**](RestFrontBinaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="frontServeBinary"></a>
# **frontServeBinary**
> RestFrontBinaryResponse frontServeBinary(binaryType, uuid)

Serve frontend binaries directly (avatars / logos / bg images)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
val binaryType : kotlin.String = binaryType_example // kotlin.String | Currently supported values are USER and GLOBAL
val uuid : kotlin.String = uuid_example // kotlin.String | Id of the binary
try {
    val result : RestFrontBinaryResponse = apiInstance.frontServeBinary(binaryType, uuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontServeBinary")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontServeBinary")
    e.printStackTrace()
}
```

### Parameters
| **binaryType** | **kotlin.String**| Currently supported values are USER and GLOBAL | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **uuid** | **kotlin.String**| Id of the binary | |

### Return type

[**RestFrontBinaryResponse**](RestFrontBinaryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="frontSession"></a>
# **frontSession**
> RestFrontSessionResponse frontSession(body)

Handle JWT

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
val body : RestFrontSessionRequest =  // RestFrontSessionRequest |
try {
    val result : RestFrontSessionResponse = apiInstance.frontSession(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontSession")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontSession")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestFrontSessionRequest**](RestFrontSessionRequest.md)|  | |

### Return type

[**RestFrontSessionResponse**](RestFrontSessionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="frontState"></a>
# **frontState**
> RestFrontStateResponse frontState(xpath)

Send XML state registry

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
val xpath : kotlin.String = xpath_example // kotlin.String |
try {
    val result : RestFrontStateResponse = apiInstance.frontState(xpath)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#frontState")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#frontState")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **xpath** | **kotlin.String**|  | [optional] |

### Return type

[**RestFrontStateResponse**](RestFrontStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="settingsMenu"></a>
# **settingsMenu**
> RestSettingsMenuResponse settingsMenu()

Sends a tree of nodes to be used a menu in the Settings panel

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = FrontendServiceApi()
try {
    val result : RestSettingsMenuResponse = apiInstance.settingsMenu()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling FrontendServiceApi#settingsMenu")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling FrontendServiceApi#settingsMenu")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestSettingsMenuResponse**](RestSettingsMenuResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json
