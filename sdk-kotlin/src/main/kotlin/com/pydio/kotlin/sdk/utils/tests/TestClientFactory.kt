package com.pydio.kotlin.sdk.utils.tests

import com.pydio.kotlin.sdk.api.Server
import com.pydio.kotlin.sdk.api.Store
import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.client.CellsClient
import com.pydio.kotlin.sdk.client.ClientFactory
import com.pydio.kotlin.sdk.transport.CellsTransport
import com.pydio.kotlin.sdk.transport.auth.CredentialService

/**
 * This provides a convenient factory that works for everything,
 * except for file transfers TO or FROM a Cells server.
 */
class TestClientFactory(
    credentialService: CredentialService,
    serverStore: Store<Server>,
    transportStore: Store<Transport>
) : ClientFactory(credentialService, serverStore, transportStore) {

    override fun getCellsClient(transport: CellsTransport): CellsClient {
        return CellsClient(transport, NoAwsS3Client())
    }
}
