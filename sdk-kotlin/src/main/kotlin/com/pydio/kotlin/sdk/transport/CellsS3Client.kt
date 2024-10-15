package com.pydio.kotlin.sdk.transport

import aws.sdk.kotlin.services.s3.model.GetObjectRequest
import aws.sdk.kotlin.services.s3.model.PutObjectRequest
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider
import aws.smithy.kotlin.runtime.collections.Attributes
import aws.smithy.kotlin.runtime.content.ByteStream
import aws.smithy.kotlin.runtime.http.request.HttpRequest
import com.pydio.kotlin.sdk.api.ErrorCodes
import com.pydio.kotlin.sdk.api.ProgressListener
import com.pydio.kotlin.sdk.api.S3Names
import com.pydio.kotlin.sdk.api.SDKException
import com.pydio.kotlin.sdk.api.ServerURL
import com.pydio.kotlin.sdk.utils.IoHelpers
import com.pydio.kotlin.sdk.utils.Log
import io.minio.MinioClient
import io.minio.PutObjectArgs
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.MalformedURLException
import java.net.URI
import java.net.URL
import java.nio.charset.StandardCharsets

// import aws.sdk.kotlin.services.s3.S3Client as AwsS3Client

const val DEFAULT_BUCKET_NAME = "data"
const val DEFAULT_GATEWAY_SECRET = "gatewaysecret"
const val DEFAULT_S3_REGION_NAME = "us-east-1"

/* Main entry point to communicate with a S3 store */
class CellsS3Client(private val transport: CellsTransport) {

    private val logTag = "CellsS3Client.kt"
    val defaultBucketName = DEFAULT_BUCKET_NAME

    suspend fun getUploadPreSignedRequest(stateID: StateID): HttpRequest? {
        val unsignedRequest = PutObjectRequest {
            bucket = DEFAULT_BUCKET_NAME
            key = stateID.path?.substring(1)
            contentType = S3Names.S3_CONTENT_TYPE_OCTET_STREAM
        }
        // TODO unsignedRequest.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.accessToken)
        //   return getAwsS3Client().presignPutObject(unsignedRequest, 24.hours)
        return null
    }

    suspend fun getUploadPreSignedURL(stateID: StateID): URL? {
        return URL(getUploadPreSignedRequest(stateID)?.url.toString())

    }

    suspend fun getDownloadPreSignedRequest(stateID: StateID): HttpRequest? {
        val unsigned = GetObjectRequest {
            bucket = "io"
            key = stateID.path?.substring(1)
        }

        // return getAwsS3Client().presignGetObject(unsigned, 24.hours)
        return null

    }


    @Throws(SDKException::class)
    suspend fun getDownloadPreSignedURL2(ws: String, file: String): URL? {
        val filename = getCleanPath(ws, file)
        val unsigned = GetObjectRequest {
            bucket = "io"
            key = filename
        }
        // TODO request.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.accessToken)
        // val request = s3.presignGetObject(unsigned, 24.hours)
        //val request = getAwsS3Client().presignGetObject(unsigned, 24.hours)
        // return URL(request.url.toString())
        return null
    }

    @Throws(SDKException::class)
    fun getStreamingPreSignedURL(slug: String, file: String, contentType: String): URL? {
        return null
        //        val filename = getCleanPath(slug, file)
//        val request = GeneratePresignedUrlRequest(DEFAULT_BUCKET_NAME, filename)
//        request.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.accessToken)
//        request.addRequestParameter(S3Names.RESPONSE_CONTENT_TYPE, contentType)
//        return s3Client().generatePresignedUrl(request)
    }

    fun getMinioClient(transport: CellsTransport): MinioClient {

        val minioClient = MinioClient.builder().httpClient(transport.authenticatedClient().build())
            .endpoint(transport.server.url())
            // .credentials("root", "password")
            .build()
        return minioClient

    }

//    private fun getS3Client(transport: CellsTransport, accountID: StateID): AmazonS3Client {
//        SignerFactory.registerSigner(CellsSigner.CELLS_SIGNER_ID, CellsSigner::class.java)
//        var conf = ClientConfiguration()
//            .withSignerOverride(CellsSigner.CELLS_SIGNER_ID)
//            .withUserAgentOverride(transport.getUserAgent()) // default adds a prefix with the AWS SDK agent that we do not want to expose
//        if (transport.server.isSSLUnverified) {
//            conf = conf.withTrustManager(ServerURLImpl.SKIP_VERIFY_TRUST_MANAGER[0])
//        }
//
//        val region = Region.getRegion(Regions.fromName(Regions.US_EAST_1.getName()))
//        val chain = AWSCredentialsProviderChain(CellsAuthProvider(transport, accountID))
//        val s3Client = AmazonS3Client(chain, region, conf)
//        s3Client.endpoint = transport.server.url()
//        s3Client.setS3ClientOptions(
//            S3ClientOptions.builder()
//                .setPayloadSigningEnabled(false)
//                .disableChunkedEncoding()
//                .setPathStyleAccess(true)
//                // TODO fix and re-enable md5 checks..
//                .skipContentMd5Check(true)
//                .build()
//        )
//
//        return s3Client
//    }

//    fun getAwsS3Client(): AwsS3Client {

//    fun getAwsS3Client(): AwsS3Client {
//
//
//        var config: OkHttpClient.Builder.() -> Unit = {
//            followRedirects(false)
//            followSslRedirects(false)
//            retryOnConnectionFailure(true)
//        }
////
//
////
//        val s3 = AwsS3Client {
//            //  httpClient = MyHttpEngine()
//            region = DEFAULT_S3_REGION_NAME
//            logMode = LogMode.LogRequestWithBody + LogMode.LogResponseWithBody
//            // TODO improve this to enable refresh when necessary
//            credentialsProvider = SimpleCredentialsProvider(transport)
//            endpointUrl = Url.parse(transport.server.serverURL.id)
//        }
//        return s3
//    }


    suspend fun upload(
        stateID: StateID,
        source: InputStream,
        length: Long,
        mime: String?,
        progressListener: ProgressListener?
    ) {
        println("#### About to upload")
        val req = getUploadPreSignedRequest(stateID)
        val serverUrl: ServerURL = try {
            transport.server.newURL(req!!.url.path.decoded)
        } catch (e: MalformedURLException) { // This should never happen with a pre-signed.
            throw SDKException(
                ErrorCodes.internal_error,
                "Invalid pre-signed path: " + req!!.url.path,
                e
            )
        }
        try {
            val con = transport.withUserAgent(serverUrl.openConnection())
            con.requestMethod = "PUT"
            con.doOutput = true
            con.setRequestProperty("Content-Type", mime ?: "application/octet-stream")
            con.setFixedLengthStreamingMode(length)
            con.outputStream.use { out ->
                try {
                    println("#### About to pipe")
                    IoHelpers.pipeReadWithIncrementalProgress(source, out, progressListener)
                    println("#### After pipe")
                } catch (se: SDKException) {
                    println("#### Got an error")
                    se.printStackTrace()
                    if (SDKException.isCancellation(se)) {
                        IoHelpers.closeQuietly(out)
                    }
                    throw se
                } catch (se: Exception) {
                    println("#### Got an exception ${se.message}")
                    se.printStackTrace()
                }

            }
            con.connect()
            // TODO implement multi part upload
            Log.d(logTag, "PUT request done with status " + con.responseCode)
        } catch (e: IOException) {
            throw SDKException.conWriteFailed("Cannot write to server", e)
        }
        // return Message.create(Message.SUCCESS, "SUCCESS");
    }

    suspend fun upload2(
        stateID: StateID,
        content: String,
        mime: String?,
        progressListener: ProgressListener?
    ) {
        println("#### About to upload2")

        val unsignedRequest = PutObjectRequest {
            bucket = DEFAULT_BUCKET_NAME
            key = stateID.path?.substring(1)
            contentType = S3Names.S3_CONTENT_TYPE_OCTET_STREAM
            body = ByteStream.fromString(content)
        }

//        // TODO unsignedRequest.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.accessToken)
//        getAwsS3Client().use { s3 ->
//            val response = s3.putObject(unsignedRequest)
//            println("Tag information is ${response.eTag}")
//        }
    }

    suspend fun upload3(
        stateID: StateID,
        content: String,
        mime: String = S3Names.S3_CONTENT_TYPE_OCTET_STREAM,
        progressListener: ProgressListener?
    ) {
        println("#### About to upload3")

        val minioClient = getMinioClient(transport)
        val path = stateID.path?.substring(1) ?: ""
        val args = PutObjectArgs.builder().bucket(DEFAULT_BUCKET_NAME).`object`(path)
            .stream(
                ByteArrayInputStream(content.toByteArray(StandardCharsets.UTF_8)),
                content.length.toLong(),
                -1L
            )
            .contentType(mime)
            .build()
        minioClient.putObject(args)
    }

    suspend fun download(
        stateID: StateID,
        target: OutputStream,
        progressListener: ProgressListener?
    ): Long {
        var input: InputStream? = null
        return try {
            val req = getDownloadPreSignedRequest(stateID)
            val preSignedURL = URI.create(req!!.url.toString())
                .toURL()        // return Message.create(Message.SUCCESS, "SUCCESS");


            val serverUrl = try {
                transport.server.newURL(preSignedURL.path).withQuery(preSignedURL.query)
            } catch (e: MalformedURLException) { // This should never happen with a pre-signed.
                throw SDKException(
                    ErrorCodes.internal_error, "Invalid pre-signed path: " + preSignedURL.path, e
                )
            }
            val con = transport.withUserAgent(serverUrl.openConnection())
            con.connect()
            input = con.inputStream
            IoHelpers.pipeReadWithIncrementalProgress(input, target, progressListener)

        } catch (e: IOException) {
            if (e.message!!.contains("ENOSPC")) { // no space left on device
                throw SDKException.noSpaceLeft(e)
            }
            throw SDKException.conReadFailed("could not download from $stateID", e)
        } finally {
            IoHelpers.closeQuietly(input)
        }
    }


    companion object {
        fun getCleanPath(slug: String, parent: String, fileName: String): String {
            return if ("/" == parent) {
                getCleanPath(slug, "/$fileName")
            } else {
                getCleanPath(slug, "$parent/$fileName")
            }
        }

        fun getCleanPath(stateID: StateID): String {
            return stateID.path?.substring(1) ?: ""
        }

        private fun getCleanPath(slug: String, file: String): String {
            var path = slug + file
            if (path.contains("//")) {
                // This should not happen anymore
                //               Log.w(LOG_TAG, "Found a double slash in $path, this is most probably a bug:")
                Thread.dumpStack()
                path = path.replace("//", "/")
            }
            return path
        }
    }
}

private class SimpleCredentialsProvider(private val transport: CellsTransport) :
    CredentialsProvider {

    override suspend fun resolve(attributes: Attributes): Credentials {
        if (transport.accessToken == null) {
            throw IllegalArgumentException("access token cannot be null")
        }
        return Credentials(
            accessKeyId = transport.accessToken!!,
            secretAccessKey = DEFAULT_GATEWAY_SECRET,
            sessionToken = transport.accessToken
        )
    }
}

//@OptIn(InternalApi::class)
//private class MyHttpEngine : OkHttpEngine("no-http") {
//    override val config: HttpClientEngineConfig = HttpClientEngineConfig.Default
//
//    override suspend fun roundTrip(context: ExecutionContext, request: HttpRequest): HttpCall {
//        println("Here")
//        return super.roundTrip(context, request)
//    }
//
//
//}
