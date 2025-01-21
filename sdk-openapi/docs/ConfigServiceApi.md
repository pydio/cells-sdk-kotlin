# ConfigServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**configFormsDiscovery**](ConfigServiceApi.md#configFormsDiscovery) | **GET** /config/discovery/forms/{ServiceName} | Publish Forms definition for building screens in frontend |
| [**controlService**](ConfigServiceApi.md#controlService) | **POST** /config/ctl | [Not Implemented]  Start/Stop a service |
| [**createEncryptionKey**](ConfigServiceApi.md#createEncryptionKey) | **POST** /config/encryption/create | Create a new master key |
| [**createPeerFolder**](ConfigServiceApi.md#createPeerFolder) | **PUT** /config/peers/{PeerAddress} | Create a folder on a given path for a given peer (filesystem) |
| [**createStorageBucket**](ConfigServiceApi.md#createStorageBucket) | **PUT** /config/buckets/{BucketName} | List Buckets on a given object storage |
| [**deleteDataSource**](ConfigServiceApi.md#deleteDataSource) | **DELETE** /config/datasource/{Name} | Delete a datasource |
| [**deleteEncryptionKey**](ConfigServiceApi.md#deleteEncryptionKey) | **POST** /config/encryption/delete | Delete an existing master key |
| [**endpointsDiscovery**](ConfigServiceApi.md#endpointsDiscovery) | **GET** /config/discovery | Publish available endpoints |
| [**exportEncryptionKey**](ConfigServiceApi.md#exportEncryptionKey) | **POST** /config/encryption/export | Export a master key for backup purpose, protected with a password |
| [**getConfig**](ConfigServiceApi.md#getConfig) | **GET** /config/{FullPath} | Generic config Get using a full path in the config tree |
| [**getDataSource**](ConfigServiceApi.md#getDataSource) | **GET** /config/datasource/{Name} | Load datasource information |
| [**getVersioningPolicy**](ConfigServiceApi.md#getVersioningPolicy) | **GET** /config/versioning/{Uuid} | Load a given versioning policy |
| [**importEncryptionKey**](ConfigServiceApi.md#importEncryptionKey) | **PUT** /config/encryption/import | Import a previously exported master key, requires the password created at export time |
| [**listDataSources**](ConfigServiceApi.md#listDataSources) | **GET** /config/datasource | List all defined datasources |
| [**listEncryptionKeys**](ConfigServiceApi.md#listEncryptionKeys) | **POST** /config/encryption/list | List registered master keys |
| [**listPeerFolders**](ConfigServiceApi.md#listPeerFolders) | **POST** /config/peers/{PeerAddress} | List folders on a peer, starting from root |
| [**listPeersAddresses**](ConfigServiceApi.md#listPeersAddresses) | **GET** /config/peers | List all detected peers (servers on which the app is running) |
| [**listProcesses**](ConfigServiceApi.md#listProcesses) | **POST** /config/processes | List running Processes, with option PeerId or ServiceName filter |
| [**listRegistry**](ConfigServiceApi.md#listRegistry) | **POST** /config/registry |  |
| [**listServices**](ConfigServiceApi.md#listServices) | **GET** /config/ctl | List all services and their status |
| [**listSites**](ConfigServiceApi.md#listSites) | **GET** /config/sites/{Filter} | List configured sites |
| [**listStorageBuckets**](ConfigServiceApi.md#listStorageBuckets) | **POST** /config/buckets | List Buckets on a given object storage |
| [**listVersioningPolicies**](ConfigServiceApi.md#listVersioningPolicies) | **GET** /config/versioning | List all defined versioning policies |
| [**listVirtualNodes**](ConfigServiceApi.md#listVirtualNodes) | **GET** /config/virtualnodes | List all defined virtual nodes |
| [**openApiDiscovery**](ConfigServiceApi.md#openApiDiscovery) | **GET** /config/discovery/openapi | Publish available REST APIs |
| [**putConfig**](ConfigServiceApi.md#putConfig) | **PUT** /config/{FullPath} | Generic config Put, using a full path in the config tree |
| [**putDataSource**](ConfigServiceApi.md#putDataSource) | **POST** /config/datasource/{Name} | Create or update a datasource |
| [**schedulerActionFormDiscovery**](ConfigServiceApi.md#schedulerActionFormDiscovery) | **GET** /config/scheduler/actions/{ActionName} | Publish scheduler action XML form for building screens in frontend |
| [**schedulerActionsDiscovery**](ConfigServiceApi.md#schedulerActionsDiscovery) | **GET** /config/scheduler/actions | Publish scheduler registered actions |


<a id="configFormsDiscovery"></a>
# **configFormsDiscovery**
> RestDiscoveryResponse configFormsDiscovery(serviceName)

Publish Forms definition for building screens in frontend

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val serviceName : kotlin.String = serviceName_example // kotlin.String | Retrieve a configuration form for a given service
try {
    val result : RestDiscoveryResponse = apiInstance.configFormsDiscovery(serviceName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#configFormsDiscovery")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#configFormsDiscovery")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **serviceName** | **kotlin.String**| Retrieve a configuration form for a given service | |

### Return type

[**RestDiscoveryResponse**](RestDiscoveryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="controlService"></a>
# **controlService**
> CtlService controlService(body)

[Not Implemented]  Start/Stop a service

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : RestControlServiceRequest =  // RestControlServiceRequest |
try {
    val result : CtlService = apiInstance.controlService(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#controlService")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#controlService")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestControlServiceRequest**](RestControlServiceRequest.md)|  | |

### Return type

[**CtlService**](CtlService.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createEncryptionKey"></a>
# **createEncryptionKey**
> EncryptionAdminCreateKeyResponse createEncryptionKey(body)

Create a new master key

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : EncryptionAdminCreateKeyRequest =  // EncryptionAdminCreateKeyRequest |
try {
    val result : EncryptionAdminCreateKeyResponse = apiInstance.createEncryptionKey(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#createEncryptionKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#createEncryptionKey")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**EncryptionAdminCreateKeyRequest**](EncryptionAdminCreateKeyRequest.md)|  | |

### Return type

[**EncryptionAdminCreateKeyResponse**](EncryptionAdminCreateKeyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createPeerFolder"></a>
# **createPeerFolder**
> RestCreatePeerFolderResponse createPeerFolder(peerAddress, body)

Create a folder on a given path for a given peer (filesystem)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val peerAddress : kotlin.String = peerAddress_example // kotlin.String | Restrict listing to a given peer
val body : RestCreatePeerFolderRequest =  // RestCreatePeerFolderRequest |
try {
    val result : RestCreatePeerFolderResponse = apiInstance.createPeerFolder(peerAddress, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#createPeerFolder")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#createPeerFolder")
    e.printStackTrace()
}
```

### Parameters
| **peerAddress** | **kotlin.String**| Restrict listing to a given peer | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestCreatePeerFolderRequest**](RestCreatePeerFolderRequest.md)|  | |

### Return type

[**RestCreatePeerFolderResponse**](RestCreatePeerFolderResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="createStorageBucket"></a>
# **createStorageBucket**
> RestCreateStorageBucketResponse createStorageBucket(bucketName, body)

List Buckets on a given object storage

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val bucketName : kotlin.String = bucketName_example // kotlin.String |
val body : RestCreateStorageBucketRequest =  // RestCreateStorageBucketRequest |
try {
    val result : RestCreateStorageBucketResponse = apiInstance.createStorageBucket(bucketName, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#createStorageBucket")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#createStorageBucket")
    e.printStackTrace()
}
```

### Parameters
| **bucketName** | **kotlin.String**|  | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestCreateStorageBucketRequest**](RestCreateStorageBucketRequest.md)|  | |

### Return type

[**RestCreateStorageBucketResponse**](RestCreateStorageBucketResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="deleteDataSource"></a>
# **deleteDataSource**
> RestDeleteDataSourceResponse deleteDataSource(name, disabled, storageType, storageConfiguration, objectsServiceName, objectsHost, objectsPort, objectsSecure, objectsBucket, objectsBaseFolder, apiKey, apiSecret, peerAddress, watch, flatStorage, skipSyncOnRestart, encryptionMode, encryptionKey, versioningPolicyName, creationDate, lastSynchronizationDate)

Delete a datasource

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val name : kotlin.String = name_example // kotlin.String | Name of the data source (max length 34)
val disabled : kotlin.Boolean = true // kotlin.Boolean | Whether this data source is disabled or running
val storageType : kotlin.String = storageType_example // kotlin.String | Type of underlying storage (LOCAL, S3, AZURE, GCS)
val storageConfiguration : kotlin.String = storageConfiguration_example // kotlin.String | List of key values describing storage configuration  This is a request variable of the map type. The query format is \"map_name[key]=value\", e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\"bob\"]=18
val objectsServiceName : kotlin.String = objectsServiceName_example // kotlin.String | Corresponding objects service name (underlying s3 service)
val objectsHost : kotlin.String = objectsHost_example // kotlin.String | Corresponding objects service host
val objectsPort : kotlin.Int = 56 // kotlin.Int | Corresponding objects service port
val objectsSecure : kotlin.Boolean = true // kotlin.Boolean | Corresponding objects service connection type
val objectsBucket : kotlin.String = objectsBucket_example // kotlin.String | Corresponding objects service bucket
val objectsBaseFolder : kotlin.String = objectsBaseFolder_example // kotlin.String | Corresponding objects service base folder inside the bucket
val apiKey : kotlin.String = apiKey_example // kotlin.String | Corresponding objects service api key
val apiSecret : kotlin.String = apiSecret_example // kotlin.String | Corresponding objects service api secret
val peerAddress : kotlin.String = peerAddress_example // kotlin.String | Peer address of the data source
val watch : kotlin.Boolean = true // kotlin.Boolean | Not implemented, whether to watch for underlying changes on the FS
val flatStorage : kotlin.Boolean = true // kotlin.Boolean | Store data in flat format (object-storage like)
val skipSyncOnRestart : kotlin.Boolean = true // kotlin.Boolean | Do not trigger resync at start
val encryptionMode : kotlin.String = encryptionMode_example // kotlin.String | Type of encryption applied before sending data to storage
val encryptionKey : kotlin.String = encryptionKey_example // kotlin.String | Encryption key used for encrypting data
val versioningPolicyName : kotlin.String = versioningPolicyName_example // kotlin.String | Versioning policy describes how files are kept in the versioning queue
val creationDate : kotlin.Int = 56 // kotlin.Int | Data Source creation date
val lastSynchronizationDate : kotlin.Int = 56 // kotlin.Int | Data Source last synchronization date
try {
    val result : RestDeleteDataSourceResponse = apiInstance.deleteDataSource(name, disabled, storageType, storageConfiguration, objectsServiceName, objectsHost, objectsPort, objectsSecure, objectsBucket, objectsBaseFolder, apiKey, apiSecret, peerAddress, watch, flatStorage, skipSyncOnRestart, encryptionMode, encryptionKey, versioningPolicyName, creationDate, lastSynchronizationDate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#deleteDataSource")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#deleteDataSource")
    e.printStackTrace()
}
```

### Parameters
| **name** | **kotlin.String**| Name of the data source (max length 34) | |
| **disabled** | **kotlin.Boolean**| Whether this data source is disabled or running | [optional] |
| **storageType** | **kotlin.String**| Type of underlying storage (LOCAL, S3, AZURE, GCS) | [optional] [default to LOCAL] [enum: LOCAL, S3, SMB, CELLS, AZURE, GCS, B2, MANTA, SIA] |
| **storageConfiguration** | **kotlin.String**| List of key values describing storage configuration  This is a request variable of the map type. The query format is \&quot;map_name[key]&#x3D;value\&quot;, e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\&quot;bob\&quot;]&#x3D;18 | [optional] |
| **objectsServiceName** | **kotlin.String**| Corresponding objects service name (underlying s3 service) | [optional] |
| **objectsHost** | **kotlin.String**| Corresponding objects service host | [optional] |
| **objectsPort** | **kotlin.Int**| Corresponding objects service port | [optional] |
| **objectsSecure** | **kotlin.Boolean**| Corresponding objects service connection type | [optional] |
| **objectsBucket** | **kotlin.String**| Corresponding objects service bucket | [optional] |
| **objectsBaseFolder** | **kotlin.String**| Corresponding objects service base folder inside the bucket | [optional] |
| **apiKey** | **kotlin.String**| Corresponding objects service api key | [optional] |
| **apiSecret** | **kotlin.String**| Corresponding objects service api secret | [optional] |
| **peerAddress** | **kotlin.String**| Peer address of the data source | [optional] |
| **watch** | **kotlin.Boolean**| Not implemented, whether to watch for underlying changes on the FS | [optional] |
| **flatStorage** | **kotlin.Boolean**| Store data in flat format (object-storage like) | [optional] |
| **skipSyncOnRestart** | **kotlin.Boolean**| Do not trigger resync at start | [optional] |
| **encryptionMode** | **kotlin.String**| Type of encryption applied before sending data to storage | [optional] [default to CLEAR] [enum: CLEAR, MASTER, USER, USER_PWD] |
| **encryptionKey** | **kotlin.String**| Encryption key used for encrypting data | [optional] |
| **versioningPolicyName** | **kotlin.String**| Versioning policy describes how files are kept in the versioning queue | [optional] |
| **creationDate** | **kotlin.Int**| Data Source creation date | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **lastSynchronizationDate** | **kotlin.Int**| Data Source last synchronization date | [optional] |

### Return type

[**RestDeleteDataSourceResponse**](RestDeleteDataSourceResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="deleteEncryptionKey"></a>
# **deleteEncryptionKey**
> EncryptionAdminDeleteKeyResponse deleteEncryptionKey(body)

Delete an existing master key

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : EncryptionAdminDeleteKeyRequest =  // EncryptionAdminDeleteKeyRequest |
try {
    val result : EncryptionAdminDeleteKeyResponse = apiInstance.deleteEncryptionKey(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#deleteEncryptionKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#deleteEncryptionKey")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**EncryptionAdminDeleteKeyRequest**](EncryptionAdminDeleteKeyRequest.md)|  | |

### Return type

[**EncryptionAdminDeleteKeyResponse**](EncryptionAdminDeleteKeyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="endpointsDiscovery"></a>
# **endpointsDiscovery**
> RestDiscoveryResponse endpointsDiscovery(endpointType)

Publish available endpoints

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val endpointType : kotlin.String = endpointType_example // kotlin.String | Filter result to a specific endpoint type
try {
    val result : RestDiscoveryResponse = apiInstance.endpointsDiscovery(endpointType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#endpointsDiscovery")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#endpointsDiscovery")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endpointType** | **kotlin.String**| Filter result to a specific endpoint type | [optional] |

### Return type

[**RestDiscoveryResponse**](RestDiscoveryResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="exportEncryptionKey"></a>
# **exportEncryptionKey**
> EncryptionAdminExportKeyResponse exportEncryptionKey(body)

Export a master key for backup purpose, protected with a password

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : EncryptionAdminExportKeyRequest =  // EncryptionAdminExportKeyRequest |
try {
    val result : EncryptionAdminExportKeyResponse = apiInstance.exportEncryptionKey(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#exportEncryptionKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#exportEncryptionKey")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**EncryptionAdminExportKeyRequest**](EncryptionAdminExportKeyRequest.md)|  | |

### Return type

[**EncryptionAdminExportKeyResponse**](EncryptionAdminExportKeyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="getConfig"></a>
# **getConfig**
> RestConfiguration getConfig(fullPath, `data`)

Generic config Get using a full path in the config tree

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val fullPath : kotlin.String = fullPath_example // kotlin.String | Full slash-separated path to the config key
val `data` : kotlin.String = `data`_example // kotlin.String | JSON-encoded data to store
try {
    val result : RestConfiguration = apiInstance.getConfig(fullPath, `data`)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#getConfig")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#getConfig")
    e.printStackTrace()
}
```

### Parameters
| **fullPath** | **kotlin.String**| Full slash-separated path to the config key | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **&#x60;data&#x60;** | **kotlin.String**| JSON-encoded data to store | [optional] |

### Return type

[**RestConfiguration**](RestConfiguration.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getDataSource"></a>
# **getDataSource**
> ObjectDataSource getDataSource(name, disabled, storageType, storageConfiguration, objectsServiceName, objectsHost, objectsPort, objectsSecure, objectsBucket, objectsBaseFolder, apiKey, apiSecret, peerAddress, watch, flatStorage, skipSyncOnRestart, encryptionMode, encryptionKey, versioningPolicyName, creationDate, lastSynchronizationDate)

Load datasource information

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val name : kotlin.String = name_example // kotlin.String | Name of the data source (max length 34)
val disabled : kotlin.Boolean = true // kotlin.Boolean | Whether this data source is disabled or running
val storageType : kotlin.String = storageType_example // kotlin.String | Type of underlying storage (LOCAL, S3, AZURE, GCS)
val storageConfiguration : kotlin.String = storageConfiguration_example // kotlin.String | List of key values describing storage configuration  This is a request variable of the map type. The query format is \"map_name[key]=value\", e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\"bob\"]=18
val objectsServiceName : kotlin.String = objectsServiceName_example // kotlin.String | Corresponding objects service name (underlying s3 service)
val objectsHost : kotlin.String = objectsHost_example // kotlin.String | Corresponding objects service host
val objectsPort : kotlin.Int = 56 // kotlin.Int | Corresponding objects service port
val objectsSecure : kotlin.Boolean = true // kotlin.Boolean | Corresponding objects service connection type
val objectsBucket : kotlin.String = objectsBucket_example // kotlin.String | Corresponding objects service bucket
val objectsBaseFolder : kotlin.String = objectsBaseFolder_example // kotlin.String | Corresponding objects service base folder inside the bucket
val apiKey : kotlin.String = apiKey_example // kotlin.String | Corresponding objects service api key
val apiSecret : kotlin.String = apiSecret_example // kotlin.String | Corresponding objects service api secret
val peerAddress : kotlin.String = peerAddress_example // kotlin.String | Peer address of the data source
val watch : kotlin.Boolean = true // kotlin.Boolean | Not implemented, whether to watch for underlying changes on the FS
val flatStorage : kotlin.Boolean = true // kotlin.Boolean | Store data in flat format (object-storage like)
val skipSyncOnRestart : kotlin.Boolean = true // kotlin.Boolean | Do not trigger resync at start
val encryptionMode : kotlin.String = encryptionMode_example // kotlin.String | Type of encryption applied before sending data to storage
val encryptionKey : kotlin.String = encryptionKey_example // kotlin.String | Encryption key used for encrypting data
val versioningPolicyName : kotlin.String = versioningPolicyName_example // kotlin.String | Versioning policy describes how files are kept in the versioning queue
val creationDate : kotlin.Int = 56 // kotlin.Int | Data Source creation date
val lastSynchronizationDate : kotlin.Int = 56 // kotlin.Int | Data Source last synchronization date
try {
    val result : ObjectDataSource = apiInstance.getDataSource(name, disabled, storageType, storageConfiguration, objectsServiceName, objectsHost, objectsPort, objectsSecure, objectsBucket, objectsBaseFolder, apiKey, apiSecret, peerAddress, watch, flatStorage, skipSyncOnRestart, encryptionMode, encryptionKey, versioningPolicyName, creationDate, lastSynchronizationDate)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#getDataSource")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#getDataSource")
    e.printStackTrace()
}
```

### Parameters
| **name** | **kotlin.String**| Name of the data source (max length 34) | |
| **disabled** | **kotlin.Boolean**| Whether this data source is disabled or running | [optional] |
| **storageType** | **kotlin.String**| Type of underlying storage (LOCAL, S3, AZURE, GCS) | [optional] [default to LOCAL] [enum: LOCAL, S3, SMB, CELLS, AZURE, GCS, B2, MANTA, SIA] |
| **storageConfiguration** | **kotlin.String**| List of key values describing storage configuration  This is a request variable of the map type. The query format is \&quot;map_name[key]&#x3D;value\&quot;, e.g. If the map name is Age, the key type is string, and the value type is integer, the query parameter is expressed as Age[\&quot;bob\&quot;]&#x3D;18 | [optional] |
| **objectsServiceName** | **kotlin.String**| Corresponding objects service name (underlying s3 service) | [optional] |
| **objectsHost** | **kotlin.String**| Corresponding objects service host | [optional] |
| **objectsPort** | **kotlin.Int**| Corresponding objects service port | [optional] |
| **objectsSecure** | **kotlin.Boolean**| Corresponding objects service connection type | [optional] |
| **objectsBucket** | **kotlin.String**| Corresponding objects service bucket | [optional] |
| **objectsBaseFolder** | **kotlin.String**| Corresponding objects service base folder inside the bucket | [optional] |
| **apiKey** | **kotlin.String**| Corresponding objects service api key | [optional] |
| **apiSecret** | **kotlin.String**| Corresponding objects service api secret | [optional] |
| **peerAddress** | **kotlin.String**| Peer address of the data source | [optional] |
| **watch** | **kotlin.Boolean**| Not implemented, whether to watch for underlying changes on the FS | [optional] |
| **flatStorage** | **kotlin.Boolean**| Store data in flat format (object-storage like) | [optional] |
| **skipSyncOnRestart** | **kotlin.Boolean**| Do not trigger resync at start | [optional] |
| **encryptionMode** | **kotlin.String**| Type of encryption applied before sending data to storage | [optional] [default to CLEAR] [enum: CLEAR, MASTER, USER, USER_PWD] |
| **encryptionKey** | **kotlin.String**| Encryption key used for encrypting data | [optional] |
| **versioningPolicyName** | **kotlin.String**| Versioning policy describes how files are kept in the versioning queue | [optional] |
| **creationDate** | **kotlin.Int**| Data Source creation date | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **lastSynchronizationDate** | **kotlin.Int**| Data Source last synchronization date | [optional] |

### Return type

[**ObjectDataSource**](ObjectDataSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="getVersioningPolicy"></a>
# **getVersioningPolicy**
> TreeVersioningPolicy getVersioningPolicy(uuid, name, description, versionsDataSourceName, versionsDataSourceBucket, maxTotalSize, maxSizePerFile, ignoreFilesGreaterThan, nodeDeletedStrategy)

Load a given versioning policy

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val uuid : kotlin.String = uuid_example // kotlin.String |
val name : kotlin.String = name_example // kotlin.String |
val description : kotlin.String = description_example // kotlin.String |
val versionsDataSourceName : kotlin.String = versionsDataSourceName_example // kotlin.String |
val versionsDataSourceBucket : kotlin.String = versionsDataSourceBucket_example // kotlin.String |
val maxTotalSize : kotlin.String = maxTotalSize_example // kotlin.String |
val maxSizePerFile : kotlin.String = maxSizePerFile_example // kotlin.String |
val ignoreFilesGreaterThan : kotlin.String = ignoreFilesGreaterThan_example // kotlin.String |
val nodeDeletedStrategy : kotlin.String = nodeDeletedStrategy_example // kotlin.String |
try {
    val result : TreeVersioningPolicy = apiInstance.getVersioningPolicy(uuid, name, description, versionsDataSourceName, versionsDataSourceBucket, maxTotalSize, maxSizePerFile, ignoreFilesGreaterThan, nodeDeletedStrategy)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#getVersioningPolicy")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#getVersioningPolicy")
    e.printStackTrace()
}
```

### Parameters
| **uuid** | **kotlin.String**|  | |
| **name** | **kotlin.String**|  | [optional] |
| **description** | **kotlin.String**|  | [optional] |
| **versionsDataSourceName** | **kotlin.String**|  | [optional] |
| **versionsDataSourceBucket** | **kotlin.String**|  | [optional] |
| **maxTotalSize** | **kotlin.String**|  | [optional] |
| **maxSizePerFile** | **kotlin.String**|  | [optional] |
| **ignoreFilesGreaterThan** | **kotlin.String**|  | [optional] |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **nodeDeletedStrategy** | **kotlin.String**|  | [optional] [default to KeepAll] [enum: KeepAll, KeepLast, KeepNone] |

### Return type

[**TreeVersioningPolicy**](TreeVersioningPolicy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="importEncryptionKey"></a>
# **importEncryptionKey**
> EncryptionAdminImportKeyResponse importEncryptionKey(body)

Import a previously exported master key, requires the password created at export time

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : EncryptionAdminImportKeyRequest =  // EncryptionAdminImportKeyRequest |
try {
    val result : EncryptionAdminImportKeyResponse = apiInstance.importEncryptionKey(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#importEncryptionKey")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#importEncryptionKey")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**EncryptionAdminImportKeyRequest**](EncryptionAdminImportKeyRequest.md)|  | |

### Return type

[**EncryptionAdminImportKeyResponse**](EncryptionAdminImportKeyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="listDataSources"></a>
# **listDataSources**
> RestDataSourceCollection listDataSources()

List all defined datasources

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
try {
    val result : RestDataSourceCollection = apiInstance.listDataSources()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listDataSources")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listDataSources")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestDataSourceCollection**](RestDataSourceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listEncryptionKeys"></a>
# **listEncryptionKeys**
> EncryptionAdminListKeysResponse listEncryptionKeys(body)

List registered master keys

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : EncryptionAdminListKeysRequest =  // EncryptionAdminListKeysRequest |
try {
    val result : EncryptionAdminListKeysResponse = apiInstance.listEncryptionKeys(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listEncryptionKeys")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listEncryptionKeys")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**EncryptionAdminListKeysRequest**](EncryptionAdminListKeysRequest.md)|  | |

### Return type

[**EncryptionAdminListKeysResponse**](EncryptionAdminListKeysResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="listPeerFolders"></a>
# **listPeerFolders**
> RestNodesCollection listPeerFolders(peerAddress, body)

List folders on a peer, starting from root

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val peerAddress : kotlin.String = peerAddress_example // kotlin.String | Restrict listing to a given peer
val body : RestListPeerFoldersRequest =  // RestListPeerFoldersRequest |
try {
    val result : RestNodesCollection = apiInstance.listPeerFolders(peerAddress, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listPeerFolders")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listPeerFolders")
    e.printStackTrace()
}
```

### Parameters
| **peerAddress** | **kotlin.String**| Restrict listing to a given peer | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestListPeerFoldersRequest**](RestListPeerFoldersRequest.md)|  | |

### Return type

[**RestNodesCollection**](RestNodesCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="listPeersAddresses"></a>
# **listPeersAddresses**
> RestListPeersAddressesResponse listPeersAddresses()

List all detected peers (servers on which the app is running)

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
try {
    val result : RestListPeersAddressesResponse = apiInstance.listPeersAddresses()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listPeersAddresses")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listPeersAddresses")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestListPeersAddressesResponse**](RestListPeersAddressesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listProcesses"></a>
# **listProcesses**
> RestListProcessesResponse listProcesses(body)

List running Processes, with option PeerId or ServiceName filter

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : RestListProcessesRequest =  // RestListProcessesRequest |
try {
    val result : RestListProcessesResponse = apiInstance.listProcesses(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listProcesses")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listProcesses")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestListProcessesRequest**](RestListProcessesRequest.md)|  | |

### Return type

[**RestListProcessesResponse**](RestListProcessesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="listRegistry"></a>
# **listRegistry**
> RegistryListResponse listRegistry(body)



### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : RegistryListRequest =  // RegistryListRequest |
try {
    val result : RegistryListResponse = apiInstance.listRegistry(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listRegistry")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listRegistry")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RegistryListRequest**](RegistryListRequest.md)|  | |

### Return type

[**RegistryListResponse**](RegistryListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="listServices"></a>
# **listServices**
> RestServiceCollection listServices(statusFilter)

List all services and their status

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val statusFilter : kotlin.String = statusFilter_example // kotlin.String | Filter services by a given status (ANY, STOPPED, STOPPING, RUNNING)
try {
    val result : RestServiceCollection = apiInstance.listServices(statusFilter)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listServices")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listServices")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **statusFilter** | **kotlin.String**| Filter services by a given status (ANY, STOPPED, STOPPING, RUNNING) | [optional] [default to ANY] [enum: ANY, STOPPED, STARTING, STOPPING, STARTED] |

### Return type

[**RestServiceCollection**](RestServiceCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listSites"></a>
# **listSites**
> RestListSitesResponse listSites(filter)

List configured sites

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val filter : kotlin.String = filter_example // kotlin.String |
try {
    val result : RestListSitesResponse = apiInstance.listSites(filter)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listSites")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listSites")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **filter** | **kotlin.String**|  | |

### Return type

[**RestListSitesResponse**](RestListSitesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listStorageBuckets"></a>
# **listStorageBuckets**
> RestNodesCollection listStorageBuckets(body)

List Buckets on a given object storage

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val body : RestListStorageBucketsRequest =  // RestListStorageBucketsRequest |
try {
    val result : RestNodesCollection = apiInstance.listStorageBuckets(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listStorageBuckets")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listStorageBuckets")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestListStorageBucketsRequest**](RestListStorageBucketsRequest.md)|  | |

### Return type

[**RestNodesCollection**](RestNodesCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="listVersioningPolicies"></a>
# **listVersioningPolicies**
> RestVersioningPolicyCollection listVersioningPolicies()

List all defined versioning policies

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
try {
    val result : RestVersioningPolicyCollection = apiInstance.listVersioningPolicies()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listVersioningPolicies")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listVersioningPolicies")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestVersioningPolicyCollection**](RestVersioningPolicyCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="listVirtualNodes"></a>
# **listVirtualNodes**
> RestNodesCollection listVirtualNodes()

List all defined virtual nodes

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
try {
    val result : RestNodesCollection = apiInstance.listVirtualNodes()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#listVirtualNodes")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#listVirtualNodes")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestNodesCollection**](RestNodesCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="openApiDiscovery"></a>
# **openApiDiscovery**
> RestOpenApiResponse openApiDiscovery(endpointType)

Publish available REST APIs

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val endpointType : kotlin.String = endpointType_example // kotlin.String | Filter result to a specific endpoint type
try {
    val result : RestOpenApiResponse = apiInstance.openApiDiscovery(endpointType)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#openApiDiscovery")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#openApiDiscovery")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **endpointType** | **kotlin.String**| Filter result to a specific endpoint type | [optional] |

### Return type

[**RestOpenApiResponse**](RestOpenApiResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="putConfig"></a>
# **putConfig**
> RestConfiguration putConfig(fullPath, body)

Generic config Put, using a full path in the config tree

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val fullPath : kotlin.String = fullPath_example // kotlin.String | Full slash-separated path to the config key
val body : ConfigServicePutConfigBody =  // ConfigServicePutConfigBody |
try {
    val result : RestConfiguration = apiInstance.putConfig(fullPath, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#putConfig")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#putConfig")
    e.printStackTrace()
}
```

### Parameters
| **fullPath** | **kotlin.String**| Full slash-separated path to the config key | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**ConfigServicePutConfigBody**](ConfigServicePutConfigBody.md)|  | |

### Return type

[**RestConfiguration**](RestConfiguration.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="putDataSource"></a>
# **putDataSource**
> ObjectDataSource putDataSource(name, body)

Create or update a datasource

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val name : kotlin.String = name_example // kotlin.String | Name of the data source (max length 34)
val body : ConfigServicePutDataSourceBody =  // ConfigServicePutDataSourceBody |
try {
    val result : ObjectDataSource = apiInstance.putDataSource(name, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#putDataSource")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#putDataSource")
    e.printStackTrace()
}
```

### Parameters
| **name** | **kotlin.String**| Name of the data source (max length 34) | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**ConfigServicePutDataSourceBody**](ConfigServicePutDataSourceBody.md)|  | |

### Return type

[**ObjectDataSource**](ObjectDataSource.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="schedulerActionFormDiscovery"></a>
# **schedulerActionFormDiscovery**
> RestSchedulerActionFormResponse schedulerActionFormDiscovery(actionName)

Publish scheduler action XML form for building screens in frontend

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
val actionName : kotlin.String = actionName_example // kotlin.String | Name of the action to load
try {
    val result : RestSchedulerActionFormResponse = apiInstance.schedulerActionFormDiscovery(actionName)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#schedulerActionFormDiscovery")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#schedulerActionFormDiscovery")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **actionName** | **kotlin.String**| Name of the action to load | |

### Return type

[**RestSchedulerActionFormResponse**](RestSchedulerActionFormResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a id="schedulerActionsDiscovery"></a>
# **schedulerActionsDiscovery**
> RestSchedulerActionsResponse schedulerActionsDiscovery()

Publish scheduler registered actions

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = ConfigServiceApi()
try {
    val result : RestSchedulerActionsResponse = apiInstance.schedulerActionsDiscovery()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling ConfigServiceApi#schedulerActionsDiscovery")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling ConfigServiceApi#schedulerActionsDiscovery")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**RestSchedulerActionsResponse**](RestSchedulerActionsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json
