package com.pydio.kotlin.sdk.api

/**
 * Generic interface to manage credentials.
 */
interface Credentials {
    fun getUsername(): String
    fun getType(): CredentialType
    fun getEncodedValue(): String?
}

enum class CredentialType {
    PAT, JWT, LEGACY_PASSWORD
}
