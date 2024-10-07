package com.pydio.kotlin.sdk.transport

import com.pydio.kotlin.sdk.api.SdkNames
import java.util.Locale

class ClientData {

    var lastUpdateTime = 0L
    var platform = ""
    var version = "0.1"
    var packageID = ""
    var name = DEFAULT_APP_NAME
    var label = DEFAULT_APP_LABEL
    var clientID = SdkNames.DEFAULT_CLIENT_ID

    var clientSecret = SdkNames.DEFAULT_CLIENT_SECRET
    var versionCode: Long = 1
    fun userAgent(): String {
        var userAgent = String.format(Locale.US, "%s-%s/%d", name, version, versionCode)
        if (platform.isNotEmpty()) {
            userAgent = "$platform/$userAgent"
        }
        if (packageID.isNotEmpty()) {
            userAgent = "$userAgent/$packageID"
        }
        return userAgent
    }

    companion object {
        const val DEFAULT_APP_LABEL = "Kotlin SDK for Cells"
        const val DEFAULT_APP_NAME = "CellsKotlinSDK"
        private const val lock = "lock"
        private var instance: ClientData? = null
        @JvmStatic
        fun getInstance(): ClientData {
            synchronized(lock) {
                instance?.let{
                    return it
                }
                val nd = ClientData()
                instance = nd
                return nd
            }
        }

        @JvmStatic
        fun updateInstance(clientData: ClientData?) {
            synchronized(lock) { instance = clientData }
        }
    }
}
