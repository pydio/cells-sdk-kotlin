# UserServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**deleteUser**](UserServiceApi.md#deleteUser) | **DELETE** /user/{Login} | Delete a user |
| [**getUser**](UserServiceApi.md#getUser) | **GET** /user/{Login} | Get a user by login |
| [**putRoles**](UserServiceApi.md#putRoles) | **PUT** /user/roles/{Login} | Just save a user roles, without other datas |
| [**putUser**](UserServiceApi.md#putUser) | **PUT** /user/{Login} | Create or update a user |
| [**searchUsers**](UserServiceApi.md#searchUsers) | **POST** /user | List/Search users |


<a id="deleteUser"></a>
# **deleteUser**
> RestDeleteResponse deleteUser(login, uuid, groupPath, attributes, password, oldPassword, isGroup, groupLabel, lastConnected, policiesContextEditable)

Delete a user

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserServiceApi()
val login : kotlin.String = login_example // kotlin.String | User login is used to connect, field is empty for groups
val uuid : kotlin.String = uuid_example // kotlin.String | User unique identifier
val groupPath : kotlin.String = groupPath_example // kotlin.String | Path to the parent group
val attributes : kotlin.String = attributes_example // kotlin.String | A free list of attributes  This is a request variable of the map type. The query format is \"map_name[key]=value\", e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\"bob\"]=18
val password : kotlin.String = password_example // kotlin.String | Password can be passed to be updated (but never read back), field is empty for groups
val oldPassword : kotlin.String = oldPassword_example // kotlin.String | OldPassword must be set when a user updates her own password
val isGroup : kotlin.Boolean = true // kotlin.Boolean | Whether this object is a group or a user
val groupLabel : kotlin.String = groupLabel_example // kotlin.String | Label of the group, field is empty for users
val lastConnected : kotlin.Int = 56 // kotlin.Int | Last successful connection timestamp
val policiesContextEditable : kotlin.Boolean = true // kotlin.Boolean | Context-resolved to quickly check if user is editable or not.
try {
    val result : RestDeleteResponse = apiInstance.deleteUser(login, uuid, groupPath, attributes, password, oldPassword, isGroup, groupLabel, lastConnected, policiesContextEditable)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserServiceApi#deleteUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserServiceApi#deleteUser")
    e.printStackTrace()
}
```

### Parameters
| **login** | **kotlin.String**| User login is used to connect, field is empty for groups | |
| **uuid** | **kotlin.String**| User unique identifier | [optional] |
| **groupPath** | **kotlin.String**| Path to the parent group | [optional] |
| **attributes** | **kotlin.String**| A free list of attributes  This is a request variable of the map type. The query format is \&quot;map_name[key]&#x3D;value\&quot;, e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\&quot;bob\&quot;]&#x3D;18 | [optional] |
| **password** | **kotlin.String**| Password can be passed to be updated (but never read back), field is empty for groups | [optional] |
| **oldPassword** | **kotlin.String**| OldPassword must be set when a user updates her own password | [optional] |
| **isGroup** | **kotlin.Boolean**| Whether this object is a group or a user | [optional] |
| **groupLabel** | **kotlin.String**| Label of the group, field is empty for users | [optional] |
| **lastConnected** | **kotlin.Int**| Last successful connection timestamp | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **policiesContextEditable** | **kotlin.Boolean**| Context-resolved to quickly check if user is editable or not. | [optional] |

### Return type

[**RestDeleteResponse**](RestDeleteResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getUser"></a>
# **getUser**
> IdmUser getUser(login, uuid, groupPath, attributes, password, oldPassword, isGroup, groupLabel, lastConnected, policiesContextEditable)

Get a user by login

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserServiceApi()
val login : kotlin.String = login_example // kotlin.String | User login is used to connect, field is empty for groups
val uuid : kotlin.String = uuid_example // kotlin.String | User unique identifier
val groupPath : kotlin.String = groupPath_example // kotlin.String | Path to the parent group
val attributes : kotlin.String = attributes_example // kotlin.String | A free list of attributes  This is a request variable of the map type. The query format is \"map_name[key]=value\", e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\"bob\"]=18
val password : kotlin.String = password_example // kotlin.String | Password can be passed to be updated (but never read back), field is empty for groups
val oldPassword : kotlin.String = oldPassword_example // kotlin.String | OldPassword must be set when a user updates her own password
val isGroup : kotlin.Boolean = true // kotlin.Boolean | Whether this object is a group or a user
val groupLabel : kotlin.String = groupLabel_example // kotlin.String | Label of the group, field is empty for users
val lastConnected : kotlin.Int = 56 // kotlin.Int | Last successful connection timestamp
val policiesContextEditable : kotlin.Boolean = true // kotlin.Boolean | Context-resolved to quickly check if user is editable or not.
try {
    val result : IdmUser = apiInstance.getUser(login, uuid, groupPath, attributes, password, oldPassword, isGroup, groupLabel, lastConnected, policiesContextEditable)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserServiceApi#getUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserServiceApi#getUser")
    e.printStackTrace()
}
```

### Parameters
| **login** | **kotlin.String**| User login is used to connect, field is empty for groups | |
| **uuid** | **kotlin.String**| User unique identifier | [optional] |
| **groupPath** | **kotlin.String**| Path to the parent group | [optional] |
| **attributes** | **kotlin.String**| A free list of attributes  This is a request variable of the map type. The query format is \&quot;map_name[key]&#x3D;value\&quot;, e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\&quot;bob\&quot;]&#x3D;18 | [optional] |
| **password** | **kotlin.String**| Password can be passed to be updated (but never read back), field is empty for groups | [optional] |
| **oldPassword** | **kotlin.String**| OldPassword must be set when a user updates her own password | [optional] |
| **isGroup** | **kotlin.Boolean**| Whether this object is a group or a user | [optional] |
| **groupLabel** | **kotlin.String**| Label of the group, field is empty for users | [optional] |
| **lastConnected** | **kotlin.Int**| Last successful connection timestamp | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **policiesContextEditable** | **kotlin.Boolean**| Context-resolved to quickly check if user is editable or not. | [optional] |

### Return type

[**IdmUser**](IdmUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="putRoles"></a>
# **putRoles**
> IdmUser putRoles(login, body)

Just save a user roles, without other datas

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserServiceApi()
val login : kotlin.String = login_example // kotlin.String | User login is used to connect, field is empty for groups
val body : UserServicePutRolesBody =  // UserServicePutRolesBody |
try {
    val result : IdmUser = apiInstance.putRoles(login, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserServiceApi#putRoles")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserServiceApi#putRoles")
    e.printStackTrace()
}
```

### Parameters
| **login** | **kotlin.String**| User login is used to connect, field is empty for groups | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**UserServicePutRolesBody**](UserServicePutRolesBody.md)|  | |

### Return type

[**IdmUser**](IdmUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="putUser"></a>
# **putUser**
> IdmUser putUser(login, body)

Create or update a user

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserServiceApi()
val login : kotlin.String = login_example // kotlin.String | User login is used to connect, field is empty for groups
val body : UserServicePutUserBody =  // UserServicePutUserBody |
try {
    val result : IdmUser = apiInstance.putUser(login, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserServiceApi#putUser")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserServiceApi#putUser")
    e.printStackTrace()
}
```

### Parameters
| **login** | **kotlin.String**| User login is used to connect, field is empty for groups | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**UserServicePutUserBody**](UserServicePutUserBody.md)|  | |

### Return type

[**IdmUser**](IdmUser.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="searchUsers"></a>
# **searchUsers**
> RestUsersCollection searchUsers(body)

List/Search users

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = UserServiceApi()
val body : RestSearchUserRequest =  // RestSearchUserRequest |
try {
    val result : RestUsersCollection = apiInstance.searchUsers(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling UserServiceApi#searchUsers")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling UserServiceApi#searchUsers")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestSearchUserRequest**](RestSearchUserRequest.md)|  | |

### Return type

[**RestUsersCollection**](RestUsersCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
