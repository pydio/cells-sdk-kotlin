package com.pydio.kotlin.sdk.client

import com.pydio.kotlin.sdk.api.Client
import com.pydio.kotlin.sdk.api.Server
import com.pydio.kotlin.sdk.api.Store
import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.transport.CellsTransport
import com.pydio.kotlin.sdk.transport.ServerFactory
import com.pydio.kotlin.sdk.transport.auth.CredentialService

/**
 * Extends a server factory to manage client concepts.
 */
abstract class ClientFactory(
    credentialService: CredentialService,
    serverStore: Store<Server>,
    transportStore: Store<Transport>
) : ServerFactory(credentialService, serverStore, transportStore) {
    /**
     * Implement this: it is the single entry point to inject the S3 client
     * that is platform specific
     */
    protected abstract fun getCellsClient(transport: CellsTransport): CellsClient

    fun getClient(transport: Transport): Client {
        return getCellsClient(transport as CellsTransport)
    }

    // FIXME this has been broken when migrating to kotlin
//    override fun initAppData() {
//        val instance = getInstance()
//
//        // Workaround to insure client data are OK:
//        // if the AppName has changed, we consider client data are already correctly set.
//        if (ClientData.DEFAULT_APP_NAME == instance.name) {
//            super.initAppData()
//            instance.packageID = this.javaClass.getPackage().name
//            instance.label = "Cells Java Client"
//            instance.name = "CellsJavaClient"
//            Log.i(
//                "Client factory", "### After Setting client data, App name: "
//                        + instance.name + " - " + instance
//            )
//            updateInstance(instance)
//        }
//    }
}
