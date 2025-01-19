# NodeServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**backgroundActionInfo**](NodeServiceApi.md#backgroundActionInfo) | **GET** /n/action/{Name}/{JobUuid} | Retrieve information about an action running in background |
| [**batchUpdateMeta**](NodeServiceApi.md#batchUpdateMeta) | **PATCH** /n/meta/batch | Update/delete user meta in batch. Passed UserMetas must contain a NodeUuid |
| [**controlBackgroundAction**](NodeServiceApi.md#controlBackgroundAction) | **PATCH** /n/action/{Name}/{JobUuid} | Send control commands to a background job |
| [**create**](NodeServiceApi.md#create) | **POST** /n/nodes/create | Create one or many files (empty or hydrated from a TemplateUuid) or folders |
| [**createCheck**](NodeServiceApi.md#createCheck) | **POST** /n/nodes/create/precheck | Apply some pre-validation checks on node name before sending an upload |
| [**createPublicLink**](NodeServiceApi.md#createPublicLink) | **POST** /n/node/{Uuid}/link | Create a public link on a given node |
| [**createSelection**](NodeServiceApi.md#createSelection) | **POST** /n/selection | Create and persist a temporary selection of nodes, that can be used by other actions |
| [**deletePublicLink**](NodeServiceApi.md#deletePublicLink) | **DELETE** /n/link/{LinkUuid} | Remove a public link |
| [**getByUuid**](NodeServiceApi.md#getByUuid) | **GET** /n/node/{Uuid} | Load a node by its Uuid |
| [**getPublicLink**](NodeServiceApi.md#getPublicLink) | **GET** /n/link/{LinkUuid} | Load public link information by Uuid |
| [**listNamespaceValues**](NodeServiceApi.md#listNamespaceValues) | **GET** /n/meta/namespace/{Namespace} | List values for a given namespace |
| [**listNamespaces**](NodeServiceApi.md#listNamespaces) | **GET** /n/meta/namespace | List defined meta namespaces |
| [**listVersions**](NodeServiceApi.md#listVersions) | **GET** /n/node/{Uuid}/versions | List all known versions of a node |
| [**lookup**](NodeServiceApi.md#lookup) | **POST** /n/nodes | Generic request to either list (using Locators) or search (using Query) for nodes |
| [**patchNode**](NodeServiceApi.md#patchNode) | **PATCH** /n/node/{Uuid} | PatchNode is used to update a node specific meta. It is used for reserved meta as well (bookmarks, contentLock) |
| [**performAction**](NodeServiceApi.md#performAction) | **POST** /n/action/{Name} | Trigger an action on the tree. Returns a JobInfo describing a background task. |
| [**searchMeta**](NodeServiceApi.md#searchMeta) | **POST** /n/meta/find | Search a list of meta by node Id or by User id and by namespace |
| [**templates**](NodeServiceApi.md#templates) | **GET** /n/templates | List available templates for hydrating empty files |
| [**updateNamespaceValues**](NodeServiceApi.md#updateNamespaceValues) | **PATCH** /n/meta/namespace/{Namespace} | Add/delete a values for a given namespace |
| [**updatePublicLink**](NodeServiceApi.md#updatePublicLink) | **PATCH** /n/link/{LinkUuid} | Update public link settings |
| [**userBookmarks**](NodeServiceApi.md#userBookmarks) | **GET** /n/nodes/bookmarks | Special API for Bookmarks, will load userMeta and the associated nodes, and return as a node list |


<a id="backgroundActionInfo"></a>
# **backgroundActionInfo**
> RestBackgroundAction backgroundActionInfo(name, jobUuid)

Retrieve information about an action running in background

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val name : kotlin.String = name_example // kotlin.String |
val jobUuid : kotlin.String = jobUuid_example // kotlin.String |
try {
    val result : RestBackgroundAction = apiInstance.backgroundActionInfo(name, jobUuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#backgroundActionInfo")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#backgroundActionInfo")
    e.printStackTrace()
}
```

### Parameters
| **name** | **kotlin.String**|  | [enum: delete, restore, copy, move, extract, compress] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **jobUuid** | **kotlin.String**|  | |

### Return type

[**RestBackgroundAction**](RestBackgroundAction.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="batchUpdateMeta"></a>
# **batchUpdateMeta**
> RestBatchUpdateMetaList batchUpdateMeta(body)

Update/delete user meta in batch. Passed UserMetas must contain a NodeUuid

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val body : RestBatchUpdateMetaList =  // RestBatchUpdateMetaList |
try {
    val result : RestBatchUpdateMetaList = apiInstance.batchUpdateMeta(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#batchUpdateMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#batchUpdateMeta")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestBatchUpdateMetaList**](RestBatchUpdateMetaList.md)|  | |

### Return type

[**RestBatchUpdateMetaList**](RestBatchUpdateMetaList.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="controlBackgroundAction"></a>
# **controlBackgroundAction**
> RestBackgroundAction controlBackgroundAction(name, jobUuid, command)

Send control commands to a background job

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val name : kotlin.String = name_example // kotlin.String |
val jobUuid : kotlin.String = jobUuid_example // kotlin.String |
val command : JobsCtrlCommand =  // JobsCtrlCommand |
try {
    val result : RestBackgroundAction = apiInstance.controlBackgroundAction(name, jobUuid, command)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#controlBackgroundAction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#controlBackgroundAction")
    e.printStackTrace()
}
```

### Parameters
| **name** | **kotlin.String**|  | [enum: delete, restore, copy, move, extract, compress] |
| **jobUuid** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **command** | [**JobsCtrlCommand**](JobsCtrlCommand.md)|  | |

### Return type

[**RestBackgroundAction**](RestBackgroundAction.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="create"></a>
# **create**
> RestNodeCollection create(body)

Create one or many files (empty or hydrated from a TemplateUuid) or folders

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val body : RestCreateRequest =  // RestCreateRequest |
try {
    val result : RestNodeCollection = apiInstance.create(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#create")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#create")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestCreateRequest**](RestCreateRequest.md)|  | |

### Return type

[**RestNodeCollection**](RestNodeCollection.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createCheck"></a>
# **createCheck**
> RestCreateCheckResponse createCheck(body)

Apply some pre-validation checks on node name before sending an upload

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val body : RestCreateCheckRequest =  // RestCreateCheckRequest | Request for pre-checking nodes before uploading or creating them.
try {
    val result : RestCreateCheckResponse = apiInstance.createCheck(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#createCheck")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#createCheck")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestCreateCheckRequest**](RestCreateCheckRequest.md)| Request for pre-checking nodes before uploading or creating them. | |

### Return type

[**RestCreateCheckResponse**](RestCreateCheckResponse.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createPublicLink"></a>
# **createPublicLink**
> RestShareLink createPublicLink(uuid, publicLinkRequest)

Create a public link on a given node

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String |
val publicLinkRequest : RestPublicLinkRequest =  // RestPublicLinkRequest |
try {
    val result : RestShareLink = apiInstance.createPublicLink(uuid, publicLinkRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#createPublicLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#createPublicLink")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **publicLinkRequest** | [**RestPublicLinkRequest**](RestPublicLinkRequest.md)|  | |

### Return type

[**RestShareLink**](RestShareLink.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createSelection"></a>
# **createSelection**
> RestSelection createSelection(body)

Create and persist a temporary selection of nodes, that can be used by other actions

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val body : RestSelection =  // RestSelection | Request to create a selection from a list of nodes.
try {
    val result : RestSelection = apiInstance.createSelection(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#createSelection")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#createSelection")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestSelection**](RestSelection.md)| Request to create a selection from a list of nodes. | |

### Return type

[**RestSelection**](RestSelection.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deletePublicLink"></a>
# **deletePublicLink**
> RestPublicLinkDeleteSuccess deletePublicLink(linkUuid)

Remove a public link

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val linkUuid : kotlin.String = linkUuid_example // kotlin.String |
try {
    val result : RestPublicLinkDeleteSuccess = apiInstance.deletePublicLink(linkUuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#deletePublicLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#deletePublicLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **linkUuid** | **kotlin.String**|  | |

### Return type

[**RestPublicLinkDeleteSuccess**](RestPublicLinkDeleteSuccess.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getByUuid"></a>
# **getByUuid**
> RestNode getByUuid(uuid, path)

Load a node by its Uuid

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String |
val path : kotlin.String = path_example // kotlin.String |
try {
    val result : RestNode = apiInstance.getByUuid(uuid, path)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#getByUuid")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#getByUuid")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **path** | **kotlin.String**|  | [optional] |

### Return type

[**RestNode**](RestNode.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getPublicLink"></a>
# **getPublicLink**
> RestShareLink getPublicLink(linkUuid)

Load public link information by Uuid

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val linkUuid : kotlin.String = linkUuid_example // kotlin.String |
try {
    val result : RestShareLink = apiInstance.getPublicLink(linkUuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#getPublicLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#getPublicLink")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **linkUuid** | **kotlin.String**|  | |

### Return type

[**RestShareLink**](RestShareLink.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listNamespaceValues"></a>
# **listNamespaceValues**
> RestNamespaceValuesResponse listNamespaceValues(namespace, operationOperation, operationValues)

List values for a given namespace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val namespace : kotlin.String = namespace_example // kotlin.String | List persisted values for this namespace
val operationOperation : kotlin.String = operationOperation_example // kotlin.String |
val operationValues : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> |
try {
    val result : RestNamespaceValuesResponse = apiInstance.listNamespaceValues(namespace, operationOperation, operationValues)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#listNamespaceValues")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#listNamespaceValues")
    e.printStackTrace()
}
```

### Parameters
| **namespace** | **kotlin.String**| List persisted values for this namespace | |
| **operationOperation** | **kotlin.String**|  | [default to PUT] [enum: PUT, DELETE] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **operationValues** | [**kotlin.collections.List&lt;kotlin.String&gt;**](kotlin.String.md)|  | |

### Return type

[**RestNamespaceValuesResponse**](RestNamespaceValuesResponse.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listNamespaces"></a>
# **listNamespaces**
> RestUserMetaNamespaceCollection listNamespaces()

List defined meta namespaces

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
try {
    val result : RestUserMetaNamespaceCollection = apiInstance.listNamespaces()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#listNamespaces")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#listNamespaces")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestUserMetaNamespaceCollection**](RestUserMetaNamespaceCollection.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listVersions"></a>
# **listVersions**
> RestNodeCollection listVersions(uuid, path)

List all known versions of a node

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String |
val path : kotlin.String = path_example // kotlin.String |
try {
    val result : RestNodeCollection = apiInstance.listVersions(uuid, path)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#listVersions")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#listVersions")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **path** | **kotlin.String**|  | [optional] |

### Return type

[**RestNodeCollection**](RestNodeCollection.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="lookup"></a>
# **lookup**
> RestNodeCollection lookup(body)

Generic request to either list (using Locators) or search (using Query) for nodes

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val body : RestLookupRequest =  // RestLookupRequest |
try {
    val result : RestNodeCollection = apiInstance.lookup(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#lookup")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#lookup")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestLookupRequest**](RestLookupRequest.md)|  | |

### Return type

[**RestNodeCollection**](RestNodeCollection.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="patchNode"></a>
# **patchNode**
> RestNode patchNode(uuid, nodeUpdates)

PatchNode is used to update a node specific meta. It is used for reserved meta as well (bookmarks, contentLock)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String |
val nodeUpdates : RestNodeUpdates =  // RestNodeUpdates |
try {
    val result : RestNode = apiInstance.patchNode(uuid, nodeUpdates)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#patchNode")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#patchNode")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **nodeUpdates** | [**RestNodeUpdates**](RestNodeUpdates.md)|  | |

### Return type

[**RestNode**](RestNode.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="performAction"></a>
# **performAction**
> RestPerformActionResponse performAction(name, parameters, jobUuid)

Trigger an action on the tree. Returns a JobInfo describing a background task.

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val name : kotlin.String = name_example // kotlin.String |
val parameters : RestActionParameters =  // RestActionParameters |
val jobUuid : kotlin.String = jobUuid_example // kotlin.String |
try {
    val result : RestPerformActionResponse = apiInstance.performAction(name, parameters, jobUuid)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#performAction")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#performAction")
    e.printStackTrace()
}
```

### Parameters
| **name** | **kotlin.String**|  | [enum: delete, restore, copy, move, extract, compress] |
| **parameters** | [**RestActionParameters**](RestActionParameters.md)|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **jobUuid** | **kotlin.String**|  | [optional] |

### Return type

[**RestPerformActionResponse**](RestPerformActionResponse.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="searchMeta"></a>
# **searchMeta**
> RestUserMetaList searchMeta(body)

Search a list of meta by node Id or by User id and by namespace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val body : IdmSearchUserMetaRequest =  // IdmSearchUserMetaRequest |
try {
    val result : RestUserMetaList = apiInstance.searchMeta(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#searchMeta")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#searchMeta")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**IdmSearchUserMetaRequest**](IdmSearchUserMetaRequest.md)|  | |

### Return type

[**RestUserMetaList**](RestUserMetaList.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="templates"></a>
# **templates**
> RestListTemplatesResponse templates(templateType)

List available templates for hydrating empty files

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val templateType : kotlin.String = templateType_example // kotlin.String |
try {
    val result : RestListTemplatesResponse = apiInstance.templates(templateType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#templates")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#templates")
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


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="updateNamespaceValues"></a>
# **updateNamespaceValues**
> RestNamespaceValuesResponse updateNamespaceValues(namespace, operation)

Add/delete a values for a given namespace

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val namespace : kotlin.String = namespace_example // kotlin.String | List persisted values for this namespace
val operation : RestNamespaceValuesOperation =  // RestNamespaceValuesOperation |
try {
    val result : RestNamespaceValuesResponse = apiInstance.updateNamespaceValues(namespace, operation)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#updateNamespaceValues")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#updateNamespaceValues")
    e.printStackTrace()
}
```

### Parameters
| **namespace** | **kotlin.String**| List persisted values for this namespace | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **operation** | [**RestNamespaceValuesOperation**](RestNamespaceValuesOperation.md)|  | |

### Return type

[**RestNamespaceValuesResponse**](RestNamespaceValuesResponse.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="updatePublicLink"></a>
# **updatePublicLink**
> RestShareLink updatePublicLink(linkUuid, publicLinkRequest)

Update public link settings

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val linkUuid : kotlin.String = linkUuid_example // kotlin.String |
val publicLinkRequest : RestPublicLinkRequest =  // RestPublicLinkRequest |
try {
    val result : RestShareLink = apiInstance.updatePublicLink(linkUuid, publicLinkRequest)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#updatePublicLink")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#updatePublicLink")
    e.printStackTrace()
}
```

### Parameters
| **linkUuid** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **publicLinkRequest** | [**RestPublicLinkRequest**](RestPublicLinkRequest.md)|  | |

### Return type

[**RestShareLink**](RestShareLink.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="userBookmarks"></a>
# **userBookmarks**
> RestNodeCollection userBookmarks(all)

Special API for Bookmarks, will load userMeta and the associated nodes, and return as a node list

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.v2.moshi.infrastructure.*
//import com.pydio.kotlin.openapi.v2.moshi.model.*

val apiInstance = NodeServiceApi()
val all : kotlin.Boolean = true // kotlin.Boolean |
try {
    val result : RestNodeCollection = apiInstance.userBookmarks(all)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling NodeServiceApi#userBookmarks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling NodeServiceApi#userBookmarks")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **all** | **kotlin.Boolean**|  | [optional] |

### Return type

[**RestNodeCollection**](RestNodeCollection.md)

### Authorization


Configure Bearer:
    ApiClient.apiKey["Authorization"] = ""
    ApiClient.apiKeyPrefix["Authorization"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json
