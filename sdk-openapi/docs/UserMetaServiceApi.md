# UserMetaServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteUserMetaTags**](UserMetaServiceApi.md#deleteUserMetaTags) | **DELETE** /user-meta/tags/{Namespace}/{Tags} | Delete one or all tags for a given namespace (use * for all tags) |
| [**listUserMetaNamespace**](UserMetaServiceApi.md#listUserMetaNamespace) | **GET** /user-meta/namespace | List defined meta namespaces |
| [**listUserMetaTags**](UserMetaServiceApi.md#listUserMetaTags) | **GET** /user-meta/tags/{Namespace} | List Tags for a given namespace |
| [**putUserMetaTag**](UserMetaServiceApi.md#putUserMetaTag) | **POST** /user-meta/tags/{Namespace} | Add a new value to Tags for a given namespace |
| [**searchUserMeta**](UserMetaServiceApi.md#searchUserMeta) | **POST** /user-meta/search | Search a list of meta by node Id or by User id and by namespace |
| [**updateUserMeta**](UserMetaServiceApi.md#updateUserMeta) | **PUT** /user-meta/update | Update/delete user meta |
| [**updateUserMetaNamespace**](UserMetaServiceApi.md#updateUserMetaNamespace) | **PUT** /user-meta/namespace | Admin: update namespaces |
| [**userBookmarks**](UserMetaServiceApi.md#userBookmarks) | **POST** /user-meta/bookmarks | Special API for Bookmarks, will load userMeta and the associated nodes, and return as a node list |


<a id="deleteUserMetaTags"></a>
# **deleteUserMetaTags**
> RestDeleteUserMetaTagsResponse deleteUserMetaTags(namespace, tags)

Delete one or all tags for a given namespace (use * for all tags)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
val namespace : kotlin.String = namespace_example // kotlin.String | Delete tags from this namespace
val tags : kotlin.String = tags_example // kotlin.String | Delete this tag
try {
    val result : RestDeleteUserMetaTagsResponse = apiInstance.deleteUserMetaTags(namespace, tags)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#deleteUserMetaTags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#deleteUserMetaTags")
    e.printStackTrace()
}
```

### Parameters
| **namespace** | **kotlin.String**| Delete tags from this namespace | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **tags** | **kotlin.String**| Delete this tag | |

### Return type

[**RestDeleteUserMetaTagsResponse**](RestDeleteUserMetaTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listUserMetaNamespace"></a>
# **listUserMetaNamespace**
> RestUserMetaNamespaceCollection listUserMetaNamespace()

List defined meta namespaces

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
try {
    val result : RestUserMetaNamespaceCollection = apiInstance.listUserMetaNamespace()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#listUserMetaNamespace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#listUserMetaNamespace")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestUserMetaNamespaceCollection**](RestUserMetaNamespaceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listUserMetaTags"></a>
# **listUserMetaTags**
> RestListUserMetaTagsResponse listUserMetaTags(namespace)

List Tags for a given namespace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
val namespace : kotlin.String = namespace_example // kotlin.String | List user meta tags for this namespace
try {
    val result : RestListUserMetaTagsResponse = apiInstance.listUserMetaTags(namespace)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#listUserMetaTags")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#listUserMetaTags")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **namespace** | **kotlin.String**| List user meta tags for this namespace | |

### Return type

[**RestListUserMetaTagsResponse**](RestListUserMetaTagsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="putUserMetaTag"></a>
# **putUserMetaTag**
> RestPutUserMetaTagResponse putUserMetaTag(namespace, body)

Add a new value to Tags for a given namespace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
val namespace : kotlin.String = namespace_example // kotlin.String | Add a tag value for this namespace
val body : RestPutUserMetaTagRequest =  // RestPutUserMetaTagRequest |
try {
    val result : RestPutUserMetaTagResponse = apiInstance.putUserMetaTag(namespace, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#putUserMetaTag")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#putUserMetaTag")
    e.printStackTrace()
}
```

### Parameters
| **namespace** | **kotlin.String**| Add a tag value for this namespace | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestPutUserMetaTagRequest**](RestPutUserMetaTagRequest.md)|  | |

### Return type

[**RestPutUserMetaTagResponse**](RestPutUserMetaTagResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="searchUserMeta"></a>
# **searchUserMeta**
> RestUserMetaCollection searchUserMeta(body)

Search a list of meta by node Id or by User id and by namespace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
val body : IdmSearchUserMetaRequest =  // IdmSearchUserMetaRequest |
try {
    val result : RestUserMetaCollection = apiInstance.searchUserMeta(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#searchUserMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#searchUserMeta")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**IdmSearchUserMetaRequest**](IdmSearchUserMetaRequest.md)|  | |

### Return type

[**RestUserMetaCollection**](RestUserMetaCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateUserMeta"></a>
# **updateUserMeta**
> IdmUpdateUserMetaResponse updateUserMeta(body)

Update/delete user meta

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
val body : IdmUpdateUserMetaRequest =  // IdmUpdateUserMetaRequest |
try {
    val result : IdmUpdateUserMetaResponse = apiInstance.updateUserMeta(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#updateUserMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#updateUserMeta")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**IdmUpdateUserMetaRequest**](IdmUpdateUserMetaRequest.md)|  | |

### Return type

[**IdmUpdateUserMetaResponse**](IdmUpdateUserMetaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updateUserMetaNamespace"></a>
# **updateUserMetaNamespace**
> IdmUpdateUserMetaNamespaceResponse updateUserMetaNamespace(body)

Admin: update namespaces

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
val body : IdmUpdateUserMetaNamespaceRequest =  // IdmUpdateUserMetaNamespaceRequest |
try {
    val result : IdmUpdateUserMetaNamespaceResponse = apiInstance.updateUserMetaNamespace(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#updateUserMetaNamespace")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#updateUserMetaNamespace")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**IdmUpdateUserMetaNamespaceRequest**](IdmUpdateUserMetaNamespaceRequest.md)|  | |

### Return type

[**IdmUpdateUserMetaNamespaceResponse**](IdmUpdateUserMetaNamespaceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="userBookmarks"></a>
# **userBookmarks**
> RestBulkMetaResponse userBookmarks(body)

Special API for Bookmarks, will load userMeta and the associated nodes, and return as a node list

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserMetaServiceApi()
val body : RestUserBookmarksRequest =  // RestUserBookmarksRequest |
try {
    val result : RestBulkMetaResponse = apiInstance.userBookmarks(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserMetaServiceApi#userBookmarks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserMetaServiceApi#userBookmarks")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestUserBookmarksRequest**](RestUserBookmarksRequest.md)|  | |

### Return type

[**RestBulkMetaResponse**](RestBulkMetaResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
