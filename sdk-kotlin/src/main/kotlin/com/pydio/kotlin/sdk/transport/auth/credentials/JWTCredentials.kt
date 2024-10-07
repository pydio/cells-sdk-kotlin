package com.pydio.kotlin.sdk.transport.auth.credentials

import com.pydio.kotlin.sdk.api.CredentialType
import com.pydio.kotlin.sdk.api.Credentials
import com.pydio.kotlin.sdk.transport.auth.Token

class JWTCredentials(private val username: String, val token: Token) : Credentials {

    override fun getUsername(): String {
        return username
    }

    override fun getType(): CredentialType {
        return CredentialType.JWT
    }

    override fun getEncodedValue(): String {
        return token.toString()
    }
}
