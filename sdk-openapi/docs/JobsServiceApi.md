# JobsServiceApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
| ------------- | ------------- | ------------- |
| [**listTasksLogs**](JobsServiceApi.md#listTasksLogs) | **POST** /jobs/tasks/logs | Technical Logs, in Json or CSV format |
| [**userControlJob**](JobsServiceApi.md#userControlJob) | **PUT** /jobs/user | Send Control Commands to one or many jobs / tasks |
| [**userCreateJob**](JobsServiceApi.md#userCreateJob) | **PUT** /jobs/user/{JobName} | Create a predefined job to be run directly |
| [**userDeleteTasks**](JobsServiceApi.md#userDeleteTasks) | **POST** /jobs/tasks/delete | Send a control command to clean tasks on a given job |
| [**userListJobs**](JobsServiceApi.md#userListJobs) | **POST** /jobs/user | List jobs associated with current user |


<a id="listTasksLogs"></a>
# **listTasksLogs**
> RestLogMessageCollection listTasksLogs(body)

Technical Logs, in Json or CSV format

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = JobsServiceApi()
val body : LogListLogRequest =  // LogListLogRequest | ListLogRequest launches a parameterised query in the log repository and streams the results.
try {
    val result : RestLogMessageCollection = apiInstance.listTasksLogs(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JobsServiceApi#listTasksLogs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JobsServiceApi#listTasksLogs")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**LogListLogRequest**](LogListLogRequest.md)| ListLogRequest launches a parameterised query in the log repository and streams the results. | |

### Return type

[**RestLogMessageCollection**](RestLogMessageCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="userControlJob"></a>
# **userControlJob**
> JobsCtrlCommandResponse userControlJob(body)

Send Control Commands to one or many jobs / tasks

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = JobsServiceApi()
val body : JobsCtrlCommand =  // JobsCtrlCommand |
try {
    val result : JobsCtrlCommandResponse = apiInstance.userControlJob(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JobsServiceApi#userControlJob")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JobsServiceApi#userControlJob")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**JobsCtrlCommand**](JobsCtrlCommand.md)|  | |

### Return type

[**JobsCtrlCommandResponse**](JobsCtrlCommandResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="userCreateJob"></a>
# **userCreateJob**
> RestUserJobResponse userCreateJob(jobName, body)

Create a predefined job to be run directly

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = JobsServiceApi()
val jobName : kotlin.String = jobName_example // kotlin.String | Name of the job to create in the user space
val body : RestUserJobRequest =  // RestUserJobRequest |
try {
    val result : RestUserJobResponse = apiInstance.userCreateJob(jobName, body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JobsServiceApi#userCreateJob")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JobsServiceApi#userCreateJob")
    e.printStackTrace()
}
```

### Parameters
| **jobName** | **kotlin.String**| Name of the job to create in the user space | |
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**RestUserJobRequest**](RestUserJobRequest.md)|  | |

### Return type

[**RestUserJobResponse**](RestUserJobResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="userDeleteTasks"></a>
# **userDeleteTasks**
> JobsDeleteTasksResponse userDeleteTasks(body)

Send a control command to clean tasks on a given job

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = JobsServiceApi()
val body : JobsDeleteTasksRequest =  // JobsDeleteTasksRequest |
try {
    val result : JobsDeleteTasksResponse = apiInstance.userDeleteTasks(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JobsServiceApi#userDeleteTasks")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JobsServiceApi#userDeleteTasks")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**JobsDeleteTasksRequest**](JobsDeleteTasksRequest.md)|  | |

### Return type

[**JobsDeleteTasksResponse**](JobsDeleteTasksResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a id="userListJobs"></a>
# **userListJobs**
> RestUserJobsCollection userListJobs(body)

List jobs associated with current user

### Example
```kotlin
// Import classes:
//import com.pydio.kotlin.openapi.infrastructure.*
//import com.pydio.kotlin.openapi.model.*

val apiInstance = JobsServiceApi()
val body : JobsListJobsRequest =  // JobsListJobsRequest |
try {
    val result : RestUserJobsCollection = apiInstance.userListJobs(body)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling JobsServiceApi#userListJobs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling JobsServiceApi#userListJobs")
    e.printStackTrace()
}
```

### Parameters
| Name | Type | Description  | Notes |
| ------------- | ------------- | ------------- | ------------- |
| **body** | [**JobsListJobsRequest**](JobsListJobsRequest.md)|  | |

### Return type

[**RestUserJobsCollection**](RestUserJobsCollection.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json
