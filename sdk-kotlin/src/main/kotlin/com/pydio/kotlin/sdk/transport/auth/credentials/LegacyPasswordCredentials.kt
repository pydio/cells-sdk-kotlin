package com.pydio.kotlin.sdk.transport.auth.credentials

import com.pydio.kotlin.sdk.api.CredentialType
import com.pydio.kotlin.sdk.api.Credentials
import com.pydio.kotlin.sdk.api.PasswordCredentials

class LegacyPasswordCredentials(private val login: String, private val password: String) :
    PasswordCredentials {

    override fun getUsername(): String {
        return login
    }

    override fun getType(): CredentialType {
        return CredentialType.LEGACY_PASSWORD
    }

    override fun getEncodedValue(): String {
        return getPassword()
    }

    override fun getPassword(): String {
        return password
    }
}
