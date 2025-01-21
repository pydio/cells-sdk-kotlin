
# InstallProxyConfig

## Properties
| Name | Type | Description | Notes |
| ------------ | ------------- | ------------- | ------------- |
| **binds** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **certificate** | [**InstallTLSCertificate**](InstallTLSCertificate.md) |  |  [optional] |
| **computedHash** | **kotlin.String** |  |  [optional] |
| **headerMods** | [**kotlin.collections.List&lt;InstallHeaderMod&gt;**](InstallHeaderMod.md) |  |  [optional] |
| **letsEncrypt** | [**InstallTLSLetsEncrypt**](InstallTLSLetsEncrypt.md) |  |  [optional] |
| **maintenance** | **kotlin.Boolean** |  |  [optional] |
| **maintenanceConditions** | **kotlin.collections.List&lt;kotlin.String&gt;** |  |  [optional] |
| **reverseProxyURL** | **kotlin.String** |  |  [optional] |
| **routing** | [**kotlin.collections.List&lt;InstallRule&gt;**](InstallRule.md) |  |  [optional] |
| **ssLRedirect** | **kotlin.Boolean** |  |  [optional] |
| **selfSigned** | [**InstallTLSSelfSigned**](InstallTLSSelfSigned.md) |  |  [optional] |
