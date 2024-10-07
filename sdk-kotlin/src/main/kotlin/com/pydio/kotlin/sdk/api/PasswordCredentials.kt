package com.pydio.kotlin.sdk.api

/**
 * Credentials based on username and password. Rather use OAuth flows or personal access token.
 */
interface PasswordCredentials : Credentials {
    fun getPassword(): String
}
