# ACLServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteAcl**](ACLServiceApi.md#deleteAcl) | **POST** /acl/bulk/delete | Delete one or more ACLs |
| [**putAcl**](ACLServiceApi.md#putAcl) | **PUT** /acl | Store an ACL |
| [**searchAcls**](ACLServiceApi.md#searchAcls) | **POST** /acl | Search Acls |


<a id="deleteAcl"></a>
# **deleteAcl**
> RestDeleteResponse deleteAcl(body)

Delete one or more ACLs

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ACLServiceApi()
val body : IdmACL =  // IdmACL | ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
try {
    val result : RestDeleteResponse = apiInstance.deleteAcl(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ACLServiceApi#deleteAcl")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ACLServiceApi#deleteAcl")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**IdmACL**](IdmACL.md)| ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace. | |

### Return type

[**RestDeleteResponse**](RestDeleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="putAcl"></a>
# **putAcl**
> IdmACL putAcl(body)

Store an ACL

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ACLServiceApi()
val body : IdmACL =  // IdmACL | ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
try {
    val result : IdmACL = apiInstance.putAcl(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ACLServiceApi#putAcl")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ACLServiceApi#putAcl")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**IdmACL**](IdmACL.md)| ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace. | |

### Return type

[**IdmACL**](IdmACL.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="searchAcls"></a>
# **searchAcls**
> RestACLCollection searchAcls(body)

Search Acls

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ACLServiceApi()
val body : RestSearchACLRequest =  // RestSearchACLRequest |
try {
    val result : RestACLCollection = apiInstance.searchAcls(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ACLServiceApi#searchAcls")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ACLServiceApi#searchAcls")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestSearchACLRequest**](RestSearchACLRequest.md)|  | |

### Return type

[**RestACLCollection**](RestACLCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
