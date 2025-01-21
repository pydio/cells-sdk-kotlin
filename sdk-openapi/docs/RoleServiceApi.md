# RoleServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteRole**](RoleServiceApi.md#deleteRole) | **DELETE** /role/{Uuid} | Delete a Role by ID |
| [**getRole**](RoleServiceApi.md#getRole) | **GET** /role/{Uuid} | Get a Role by ID |
| [**searchRoles**](RoleServiceApi.md#searchRoles) | **POST** /role | Search Roles |
| [**setRole**](RoleServiceApi.md#setRole) | **PUT** /role/{Uuid} | Create or update a Role |


<a id="deleteRole"></a>
# **deleteRole**
> IdmRole deleteRole(uuid, label, isTeam, groupRole, userRole, lastUpdated, autoApplies, policiesContextEditable, forceOverride)

Delete a Role by ID

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = RoleServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String | Unique identifier of this role
val label : kotlin.String = label_example // kotlin.String | Label of this role
val isTeam : kotlin.Boolean = true // kotlin.Boolean | Whether this role represents a user team or not
val groupRole : kotlin.Boolean = true // kotlin.Boolean | Whether this role is attached to a Group object
val userRole : kotlin.Boolean = true // kotlin.Boolean | Whether this role is attached to a User object
val lastUpdated : kotlin.Int = 56 // kotlin.Int | Last modification date of the role
val autoApplies : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | List of profiles (standard, shared, admin) on which the role will be automatically applied
val policiesContextEditable : kotlin.Boolean = true // kotlin.Boolean | Whether the policies resolve into an editable state
val forceOverride : kotlin.Boolean = true // kotlin.Boolean | Is used in a stack of roles, this one will always be applied last.
try {
    val result : IdmRole = apiInstance.deleteRole(uuid, label, isTeam, groupRole, userRole, lastUpdated, autoApplies, policiesContextEditable, forceOverride)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RoleServiceApi#deleteRole")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RoleServiceApi#deleteRole")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**| Unique identifier of this role | |
| **label** | **kotlin.String**| Label of this role | [optional] |
| **isTeam** | **kotlin.Boolean**| Whether this role represents a user team or not | [optional] |
| **groupRole** | **kotlin.Boolean**| Whether this role is attached to a Group object | [optional] |
| **userRole** | **kotlin.Boolean**| Whether this role is attached to a User object | [optional] |
| **lastUpdated** | **kotlin.Int**| Last modification date of the role | [optional] |
| **autoApplies** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| List of profiles (standard, shared, admin) on which the role will be automatically applied | [optional] |
| **policiesContextEditable** | **kotlin.Boolean**| Whether the policies resolve into an editable state | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **forceOverride** | **kotlin.Boolean**| Is used in a stack of roles, this one will always be applied last. | [optional] |

### Return type

[**IdmRole**](IdmRole.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getRole"></a>
# **getRole**
> IdmRole getRole(uuid, label, isTeam, groupRole, userRole, lastUpdated, autoApplies, policiesContextEditable, forceOverride)

Get a Role by ID

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = RoleServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String | Unique identifier of this role
val label : kotlin.String = label_example // kotlin.String | Label of this role
val isTeam : kotlin.Boolean = true // kotlin.Boolean | Whether this role represents a user team or not
val groupRole : kotlin.Boolean = true // kotlin.Boolean | Whether this role is attached to a Group object
val userRole : kotlin.Boolean = true // kotlin.Boolean | Whether this role is attached to a User object
val lastUpdated : kotlin.Int = 56 // kotlin.Int | Last modification date of the role
val autoApplies : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | List of profiles (standard, shared, admin) on which the role will be automatically applied
val policiesContextEditable : kotlin.Boolean = true // kotlin.Boolean | Whether the policies resolve into an editable state
val forceOverride : kotlin.Boolean = true // kotlin.Boolean | Is used in a stack of roles, this one will always be applied last.
try {
    val result : IdmRole = apiInstance.getRole(uuid, label, isTeam, groupRole, userRole, lastUpdated, autoApplies, policiesContextEditable, forceOverride)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RoleServiceApi#getRole")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RoleServiceApi#getRole")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**| Unique identifier of this role | |
| **label** | **kotlin.String**| Label of this role | [optional] |
| **isTeam** | **kotlin.Boolean**| Whether this role represents a user team or not | [optional] |
| **groupRole** | **kotlin.Boolean**| Whether this role is attached to a Group object | [optional] |
| **userRole** | **kotlin.Boolean**| Whether this role is attached to a User object | [optional] |
| **lastUpdated** | **kotlin.Int**| Last modification date of the role | [optional] |
| **autoApplies** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)| List of profiles (standard, shared, admin) on which the role will be automatically applied | [optional] |
| **policiesContextEditable** | **kotlin.Boolean**| Whether the policies resolve into an editable state | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **forceOverride** | **kotlin.Boolean**| Is used in a stack of roles, this one will always be applied last. | [optional] |

### Return type

[**IdmRole**](IdmRole.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="searchRoles"></a>
# **searchRoles**
> RestRolesCollection searchRoles(body)

Search Roles

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = RoleServiceApi()
val body : RestSearchRoleRequest =  // RestSearchRoleRequest |
try {
    val result : RestRolesCollection = apiInstance.searchRoles(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RoleServiceApi#searchRoles")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RoleServiceApi#searchRoles")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestSearchRoleRequest**](RestSearchRoleRequest.md)|  | |

### Return type

[**RestRolesCollection**](RestRolesCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="setRole"></a>
# **setRole**
> IdmRole setRole(uuid, body)

Create or update a Role

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = RoleServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String | Unique identifier of this role
val body : RoleServiceSetRoleBody =  // RoleServiceSetRoleBody |
try {
    val result : IdmRole = apiInstance.setRole(uuid, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling RoleServiceApi#setRole")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling RoleServiceApi#setRole")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**| Unique identifier of this role | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RoleServiceSetRoleBody**](RoleServiceSetRoleBody.md)|  | |

### Return type

[**IdmRole**](IdmRole.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
