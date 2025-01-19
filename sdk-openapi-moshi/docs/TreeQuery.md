
# TreeQuery

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **content** | **kotlin.String** |  |  [optional] |
| **durationDate** | **kotlin.String** |  |  [optional] |
| **etag** | **kotlin.String** |  |  [optional] |
| **extension** | **kotlin.String** |  |  [optional] |
| **fileName** | **kotlin.String** |  |  [optional] |
| **fileNameOrContent** | **kotlin.String** |  |  [optional] |
| **freeString** | **kotlin.String** | Bleve-like search query to search for a specific metadata value. When querying nodes, this will redirect this query to the Search Engine. When filtering an input, this will load an in-memory bleve engine to evaluate the node.  Bleve query string format is a space separated list of &#x60;[+-]key:value&#x60;, where node meta keys must be prepended with \&quot;Meta.\&quot; For Example, for tags: &#x60;+Meta.usermeta-tags:myvalue&#x60; |  [optional] |
| **geoQuery** | [**TreeGeoQuery**](TreeGeoQuery.md) |  |  [optional] |
| **maxDate** | **kotlin.String** |  |  [optional] |
| **maxSize** | **kotlin.String** |  |  [optional] |
| **minDate** | **kotlin.String** |  |  [optional] |
| **minSize** | **kotlin.String** |  |  [optional] |
| **not** | **kotlin.Boolean** |  |  [optional] |
| **pathDepth** | **kotlin.Int** |  |  [optional] |
| **pathPrefix** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **paths** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **type** | [**TreeNodeType**](TreeNodeType.md) |  |  [optional] |
| **uuIDs** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |



