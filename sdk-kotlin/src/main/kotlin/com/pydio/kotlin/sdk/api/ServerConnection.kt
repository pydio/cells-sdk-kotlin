package com.pydio.kotlin.sdk.api

import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class ServerConnection private constructor(
    val url: HttpUrl,
    val skipVerify: Boolean,// Self-signed servers management
    private val client: OkHttpClient,
) {

    companion object {

        fun fromAddress(urlString: String, skipVerify: Boolean = false): ServerConnection {
            val httpUrl = urlString.toHttpUrlOrNull()
            check(httpUrl != null)
            val okhttpClient = if (skipVerify) {
                getUnsafeOkHttpClient()
            } else {
                OkHttpClient.Builder().build()
            }
            return ServerConnection(httpUrl, skipVerify, okhttpClient)
        }

        fun getUnsafeOkHttpClient(): OkHttpClient {
            try {
                // Create a trust manager that does not validate certificate chains
                val trustAllCerts = arrayOf<TrustManager>(
                    object : X509TrustManager {
                        override fun checkClientTrusted(
                            chain: Array<X509Certificate>,
                            authType: String
                        ) {
                        }

                        override fun checkServerTrusted(
                            chain: Array<X509Certificate>,
                            authType: String
                        ) {
                        }

                        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
                    }
                )

                // Install the all-trusting trust manager
                val sslContext = SSLContext.getInstance("SSL")
                sslContext.init(null, trustAllCerts, SecureRandom())

                // Create an ssl socket factory with our all-trusting manager
                val sslSocketFactory = sslContext.socketFactory

                return OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                    .hostnameVerifier { _, _ -> true }
                    .build()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }

    fun ping() {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        println("## About to ping server with ID: $id")
        println("## HTTP Response: ${response.code} - ${response.message}")
    }


    val id: String
        /**
         * Returns a standard id that has been cleaned and normalized.
         */
        get() = if (url.port != 80 && url.port != 443) {
            "${url.scheme}://${url.host}:${url.port}${url.encodedPath}"
        } else {
            "${url.scheme}://${url.host}${url.encodedPath}"
        }

    fun withPath(path: String): ServerConnection {
        var newUrl = url.newBuilder().encodedPath(path).build() // this does a clone under the hood
        return ServerConnection(newUrl, skipVerify = skipVerify, client)
    }
}
