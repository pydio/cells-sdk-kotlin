package com.pydio.kotlin.sdk.utils.tests

import com.pydio.kotlin.sdk.transport.StateID

/**
 * Simple object that exposes the basic information to be provided
 * to define a test `Session`
 */
data class RemoteServerConfig(
    val skipServer: Boolean = true,
    val urlString: String,
    val skipVerify: Boolean = false,
    var username: String,
    val isAdmin: Boolean = false,
    val pat: String? = null,
    val pwd: String? = null,
    val defaultWS: String? = null,
) {
    val stateID: StateID
        get() {
            return StateID(username, urlString)
        }
}
