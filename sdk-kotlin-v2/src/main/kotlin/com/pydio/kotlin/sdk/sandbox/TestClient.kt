package com.pydio.kotlin.sdk.sandbox

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials
import aws.smithy.kotlin.runtime.collections.Attributes
import aws.smithy.kotlin.runtime.collections.emptyAttributes
import aws.smithy.kotlin.runtime.content.asByteStream
import aws.smithy.kotlin.runtime.net.url.Url
import aws.smithy.kotlin.runtime.time.Instant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.UUID
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import kotlin.io.path.createTempFile
import kotlin.io.path.writeText

const val SERVER_URL = "https://localhost:8080"
private const val PAT = "Change Me"

private const val SKIP_SSL_VERIFICATION = true

private const val USER_AGENT = "com.pydio.kotlin.openapi.moshi/v0.1.1 CellsAPI/v2"
private const val AUTH_HEADER = "Authorization"
private const val USER_AGENT_HEADER = "User-Agent"
private const val DEFAULT_TOKEN_TYPE = "Bearer"

const val DEFAULT_GATEWAY_SECRET = "gatewaysecret"
const val DEFAULT_S3_REGION_NAME = "us-east-1"
const val DEFAULT_BUCKET_NAME = "io"

private var currClient: OkHttpClient? = null

fun getTestHttpClient(): OkHttpClient {
    if (currClient != null) {
        return currClient!!
    }
    var builder =
        if (SKIP_SSL_VERIFICATION) {
            unsafeClientBuilder()
        } else {
            OkHttpClient.Builder()
        }
    builder = builder.addInterceptor(DummyPatInterceptor(USER_AGENT) { PAT })
    currClient = builder.build()
    return currClient!!
}

fun pingServer(): Int {
    try {
        val request = Request.Builder().url(SERVER_URL).build()
        val response = getTestHttpClient().newCall(request).execute()
        return response.code
    } catch (e: Exception) {
        print("unexpected error while pinging server at ${SERVER_URL}: ${e.message}")
        return 503
    }
}

suspend fun putS3Object(
    objectKey: String,
    //     objectPath: String,
) {
    val metadataVal = mutableMapOf<String, String>()
    // metadataVal["myVal"] = "test"
    val creds = PatCredentials(PAT, DEFAULT_GATEWAY_SECRET)

    val request = PutObjectRequest {
        bucket = DEFAULT_BUCKET_NAME
        key = objectKey
        metadata = metadataVal
        body = createDummyTmpFile().asByteStream()
    }

    S3Client {
        region = DEFAULT_S3_REGION_NAME
        credentialsProvider = StaticCredentialsProvider(creds)
        endpointUrl = Url.parse(SERVER_URL)
    }
        .use { s3 ->
            val response = s3.putObject(request)
            println("Tag information is ${response.eTag}")
        }
}

private class PatCredentials(
    override val accessKeyId: String,
    override val secretAccessKey: String,
    override val sessionToken: String? = null,
    override val expiration: Instant? = null,
    override val attributes: Attributes = emptyAttributes(),
) : Credentials

private fun createDummyTmpFile(): File {
    val path = createTempFile(prefix = "temp_", suffix = ".txt")
    path.writeText("This is a test file to test put object with an unique part: ${unique(16)}")
    // tempFile.deleteOnExit()
    return path.toFile()
}

private class DummyPatInterceptor(
    private val userAgent: String,
    private val getToken: () -> String,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var builder =
            chain
                .request()
                .newBuilder()
                .addHeader(USER_AGENT_HEADER, userAgent)
                .addHeader(AUTH_HEADER, "$DEFAULT_TOKEN_TYPE ${getToken()}")
        return chain.proceed(builder.build())
    }
}

private fun unsafeClientBuilder(): OkHttpClient.Builder {
    try {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts =
            arrayOf<TrustManager>(
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
                })

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        // Create an OkHttpClient and configure it to ignore certificate errors
        return OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier(HostnameVerifier { _, _ -> true })
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

fun unique(length: Int = 4): String {
    val id: String = UUID.randomUUID().toString()
    return id.take(length)
}
