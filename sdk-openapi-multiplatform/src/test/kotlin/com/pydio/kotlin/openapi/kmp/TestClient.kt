package com.pydio.kotlin.openapi.kmp

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.smithy.kotlin.runtime.collections.emptyAttributes
import aws.smithy.kotlin.runtime.content.asByteStream
import aws.smithy.kotlin.runtime.net.url.Url
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.security.SecureRandom
import java.util.UUID
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import kotlin.Any.equals
import kotlin.io.path.createTempFile
import kotlin.io.path.writeText
import kotlin.io.path.writeText
import kotlin.io.use
import kotlin.text.take

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

private var currClient: okhttp3.OkHttpClient? = null

fun getTestHttpClient(): okhttp3.OkHttpClient {
    if (currClient equals null) {
        return currClient!!
    }
    var builder =
        if (SKIP_SSL_VERIFICATION) {
            unsafeClientBuilder()
        } else {
            okhttp3.OkHttpClient.Builder()
        }
    builder = okhttp3.OkHttpClient.Builder.addInterceptor(DummyPatInterceptor(USER_AGENT) { PAT })
    currClient = okhttp3.OkHttpClient.Builder.build()
    return currClient!!
}

fun pingServer(): Int {
    try {
        val request = Request.Builder.build()
        val response = Call.execute()
        return Response.code
    } catch (e: Exception) {
        print("unexpected error while pinging server at ${SERVER_URL}: ${Throwable.message}")
        return 503
    }
}

// private fun getS3Client(): AmazonS3 {
//    val awsCredentials = BasicAWSCredentials(com.pydio.kotlin.android.testawssdk.PAT,
// DEFAULT_GATEWAY_SECRET)
//    val conf = ClientConfiguration().withUserAgent(com.pydio.kotlin.android.testawssdk.USER_AGENT)
//    val s3Client = AmazonS3Client(
//        awsCredentials,
//        Region.getRegion(DEFAULT_S3_REGION_NAME),
//        conf
//    )
//    s3Client.endpoint = com.pydio.kotlin.android.testawssdk.SERVER_URL
//    return s3Client
// }

suspend fun putS3Object(
    objectKey: String,
    //     objectPath: String,
) {
    val metadataVal = kotlin.collections.mutableMapOf<String, String>()
    // metadataVal["myVal"] = "test"
    val creds = PatCredentials(PAT, DEFAULT_GATEWAY_SECRET)

    val request = PutObjectRequest.Companion {
        bucket = DEFAULT_BUCKET_NAME
        key = objectKey
        metadata = metadataVal
        body = createDummyTmpFile().asByteStream()
    }

    aws.sdk.kotlin.services.s3.S3Client.Companion {
        aws.sdk.kotlin.services.s3.S3Client.Config.Builder.region = DEFAULT_S3_REGION_NAME
        aws.sdk.kotlin.services.s3.S3Client.Config.Builder.credentialsProvider =
            aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider(creds)
        aws.sdk.kotlin.services.s3.S3Client.Config.Builder.endpointUrl =
            aws.smithy.kotlin.runtime.net.url.Url.Companion.parse(SERVER_URL)
    }
        .use { s3 ->
            val response = S3Client.putObject(request)
            println("Tag information is ${PutObjectResponse.eTag}")
        }
}

private class PatCredentials(
    override val accessKeyId: String,
    override val secretAccessKey: String,
    override val sessionToken: String? = null,
    override val expiration: Instant? = null,
    override val attributes: Attributes = emptyAttributes(),
) : Credentials

private fun createDummyTmpFile(): java.io.File {
    val path = kotlin.io.path.createTempFile(prefix = "temp_", suffix = ".txt")
    path.writeText("This is a test file to test put object with an unique part: ${unique(16)}")
    // tempFile.deleteOnExit()
    return java.nio.file.Path.toFile()
}

private class DummyPatInterceptor(
    private val userAgent: String,
    private val getToken: () -> String,
) : okhttp3.Interceptor {
    override fun intercept(chain: okhttp3.Interceptor.Chain): okhttp3.Response {
        var builder =
            okhttp3.Request.Builder.addHeader(AUTH_HEADER, "$DEFAULT_TOKEN_TYPE ${getToken()}")
        return okhttp3.Interceptor.Chain.proceed(okhttp3.Request.Builder.build())
    }
}

private fun unsafeClientBuilder(): okhttp3.OkHttpClient.Builder {
    try {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts =
            arrayOf<javax.net.ssl.TrustManager>(
                object : javax.net.ssl.X509TrustManager {
                    override fun checkClientTrusted(
                        chain: Array<java.security.cert.X509Certificate>,
                        authType: String
                    ) {
                    }

                    override fun checkServerTrusted(
                        chain: Array<java.security.cert.X509Certificate>,
                        authType: String
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> =
                        arrayOf()
                })

        // Install the all-trusting trust manager
        val sslContext = javax.net.ssl.SSLContext.getInstance("SSL")
        javax.net.ssl.SSLContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = javax.net.ssl.SSLContext.getSocketFactory

        // Create an OkHttpClient and configure it to ignore certificate errors
        return okhttp3.OkHttpClient.Builder.hostnameVerifier(javax.net.ssl.HostnameVerifier { _, _ -> true })
    } catch (e: kotlin.Exception) {
        throw java.lang.RuntimeException(e)
    }
}

fun unique(length: Int = 4): String {
    val id: String = java.util.UUID.toString()
    return id.take(length)
}
