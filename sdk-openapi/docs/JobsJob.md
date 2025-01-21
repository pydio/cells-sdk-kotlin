
# JobsJob

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **actions** | [**kotlin.collections.List&lt;JobsAction&gt;**](JobsAction.md) |  |  [optional] |
| **autoClean** | **kotlin.Boolean** |  |  [optional] |
| **autoRestart** | **kotlin.Boolean** |  |  [optional] |
| **autoStart** | **kotlin.Boolean** |  |  [optional] |
| **contextMetaFilter** | [**JobsContextMetaFilter**](JobsContextMetaFilter.md) |  |  [optional] |
| **createdAt** | **kotlin.Int** |  |  [optional] |
| **custom** | **kotlin.Boolean** |  |  [optional] |
| **dataSourceFilter** | [**JobsDataSourceSelector**](JobsDataSourceSelector.md) |  |  [optional] |
| **eventNames** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **hooks** | [**kotlin.collections.List&lt;JobsJobHook&gt;**](JobsJobHook.md) |  |  [optional] |
| **ID** | **kotlin.String** |  |  [optional] |
| **idmFilter** | [**JobsIdmSelector**](JobsIdmSelector.md) |  |  [optional] |
| **inactive** | **kotlin.Boolean** |  |  [optional] |
| **label** | **kotlin.String** |  |  [optional] |
| **languages** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **maxConcurrency** | **kotlin.Int** |  |  [optional] |
| **mergeAction** | [**JobsAction**](JobsAction.md) |  |  [optional] |
| **metadata** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** | Additional user-defined metadata, can be used for icon, documentation, pre-requisites, etc. |  [optional] |
| **modifiedAt** | **kotlin.Int** |  |  [optional] |
| **nodeEventFilter** | [**JobsNodesSelector**](JobsNodesSelector.md) |  |  [optional] |
| **owner** | **kotlin.String** |  |  [optional] |
| **parameters** | [**kotlin.collections.List&lt;JobsJobParameter&gt;**](JobsJobParameter.md) |  |  [optional] |
| **resourcesDependencies** | [**kotlin.collections.List&lt;ProtobufAny&gt;**](ProtobufAny.md) |  |  [optional] |
| **schedule** | [**JobsSchedule**](JobsSchedule.md) |  |  [optional] |
| **tasks** | [**kotlin.collections.List&lt;JobsTask&gt;**](JobsTask.md) |  |  [optional] |
| **tasksSilentUpdate** | **kotlin.Boolean** |  |  [optional] |
| **timeout** | **kotlin.String** |  |  [optional] |
| **userEventFilter** | [**JobsUsersSelector**](JobsUsersSelector.md) |  |  [optional] |
| **versionMeta** | **kotlin.collections.Map&lt;kotlin.String, kotlin.String&gt;** |  |  [optional] |
