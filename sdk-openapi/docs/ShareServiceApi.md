# ShareServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteCell**](ShareServiceApi.md#deleteCell) | **DELETE** /share/cell/{Uuid} | Delete a share room |
| [**deleteShareLink**](ShareServiceApi.md#deleteShareLink) | **DELETE** /share/link/{Uuid} | Delete Share Link |
| [**getCell**](ShareServiceApi.md#getCell) | **GET** /share/cell/{Uuid} | Load a share room |
| [**getShareLink**](ShareServiceApi.md#getShareLink) | **GET** /share/link/{Uuid} | Load a share link with all infos |
| [**listSharedResources**](ShareServiceApi.md#listSharedResources) | **POST** /share/resources | List Shared Resources for current user or all users |
| [**putCell**](ShareServiceApi.md#putCell) | **PUT** /share/cell | Put or Create a share room |
| [**putShareLink**](ShareServiceApi.md#putShareLink) | **PUT** /share/link | Put or Create a share room |
| [**updateSharePolicies**](ShareServiceApi.md#updateSharePolicies) | **PUT** /share/policies | Updates policies associated to the underlying workspace for a Cell or a ShareLink |


<a id="deleteCell"></a>
# **deleteCell**
> RestDeleteCellResponse deleteCell(uuid)

Delete a share room

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String | Cell Uuid
try {
    val result : RestDeleteCellResponse = apiInstance.deleteCell(uuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#deleteCell")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#deleteCell")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **uuid** | **kotlin.String**| Cell Uuid | |

### Return type

[**RestDeleteCellResponse**](RestDeleteCellResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="deleteShareLink"></a>
# **deleteShareLink**
> RestDeleteShareLinkResponse deleteShareLink(uuid)

Delete Share Link

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String | Id of Link to delete
try {
    val result : RestDeleteShareLinkResponse = apiInstance.deleteShareLink(uuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#deleteShareLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#deleteShareLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **uuid** | **kotlin.String**| Id of Link to delete | |

### Return type

[**RestDeleteShareLinkResponse**](RestDeleteShareLinkResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getCell"></a>
# **getCell**
> RestCell getCell(uuid)

Load a share room

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String | Cell Uuid
try {
    val result : RestCell = apiInstance.getCell(uuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#getCell")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#getCell")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **uuid** | **kotlin.String**| Cell Uuid | |

### Return type

[**RestCell**](RestCell.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getShareLink"></a>
# **getShareLink**
> RestShareLink getShareLink(uuid)

Load a share link with all infos

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String | Link Uuid
try {
    val result : RestShareLink = apiInstance.getShareLink(uuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#getShareLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#getShareLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **uuid** | **kotlin.String**| Link Uuid | |

### Return type

[**RestShareLink**](RestShareLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listSharedResources"></a>
# **listSharedResources**
> RestListSharedResourcesResponse listSharedResources(body)

List Shared Resources for current user or all users

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val body : RestListSharedResourcesRequest =  // RestListSharedResourcesRequest |
try {
    val result : RestListSharedResourcesResponse = apiInstance.listSharedResources(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#listSharedResources")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#listSharedResources")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestListSharedResourcesRequest**](RestListSharedResourcesRequest.md)|  | |

### Return type

[**RestListSharedResourcesResponse**](RestListSharedResourcesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="putCell"></a>
# **putCell**
> RestCell putCell(body)

Put or Create a share room

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val body : RestPutCellRequest =  // RestPutCellRequest |
try {
    val result : RestCell = apiInstance.putCell(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#putCell")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#putCell")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestPutCellRequest**](RestPutCellRequest.md)|  | |

### Return type

[**RestCell**](RestCell.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="putShareLink"></a>
# **putShareLink**
> RestShareLink putShareLink(body)

Put or Create a share room

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val body : RestPutShareLinkRequest =  // RestPutShareLinkRequest |
try {
    val result : RestShareLink = apiInstance.putShareLink(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#putShareLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#putShareLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestPutShareLinkRequest**](RestPutShareLinkRequest.md)|  | |

### Return type

[**RestShareLink**](RestShareLink.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateSharePolicies"></a>
# **updateSharePolicies**
> RestUpdateSharePoliciesResponse updateSharePolicies(body)

Updates policies associated to the underlying workspace for a Cell or a ShareLink

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ShareServiceApi()
val body : RestUpdateSharePoliciesRequest =  // RestUpdateSharePoliciesRequest |
try {
    val result : RestUpdateSharePoliciesResponse = apiInstance.updateSharePolicies(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ShareServiceApi#updateSharePolicies")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ShareServiceApi#updateSharePolicies")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestUpdateSharePoliciesRequest**](RestUpdateSharePoliciesRequest.md)|  | |

### Return type

[**RestUpdateSharePoliciesResponse**](RestUpdateSharePoliciesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
