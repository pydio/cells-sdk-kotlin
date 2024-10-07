package com.pydio.kotlin.sdk.transport.auth

/**
 * String constants for the com.pydio.kotlin.sdk.transport.auth package
 */
interface AuthNames {
    companion object {
        const val AUTH_HEADER = "Authorization"
        const val USER_AGENT_HEADER = "User-Agent"
        const val DEFAULT_TOKEN_TYPE = "Bearer"
    }
}
