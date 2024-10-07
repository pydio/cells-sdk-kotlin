package com.pydio.kotlin.sdk.utils.tests

import com.pydio.kotlin.sdk.api.SDKException
import com.pydio.kotlin.sdk.api.Store
import com.pydio.kotlin.sdk.transport.StateID
import com.pydio.kotlin.sdk.transport.auth.CredentialService
import com.pydio.kotlin.sdk.transport.auth.Token

class TestCredentialService(tokenStore: Store<Token>, passwordStore: Store<String>) :
    CredentialService(tokenStore, passwordStore) {

    @Throws(SDKException::class)
    override fun requestRefreshToken(stateID: StateID) {
    }
}
