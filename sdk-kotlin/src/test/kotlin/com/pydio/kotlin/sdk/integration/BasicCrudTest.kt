package com.pydio.kotlin.sdk.integration

import com.pydio.kotlin.sdk.api.ProgressListener
import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.transport.CellsMinioClient
import com.pydio.kotlin.sdk.transport.CellsS3Client
import com.pydio.kotlin.sdk.transport.CellsTransport
import com.pydio.kotlin.sdk.transport.StateID
import com.pydio.kotlin.sdk.utils.IoHelpers
import com.pydio.kotlin.sdk.utils.MemoryStore
import com.pydio.kotlin.sdk.utils.tests.RemoteServerConfig
import com.pydio.kotlin.sdk.utils.tests.TestClientFactory
import com.pydio.kotlin.sdk.utils.tests.TestCredentialService
import com.pydio.kotlin.sdk.utils.tests.TestUtils
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory
import java.io.InputStream
import java.net.HttpURLConnection

class BasicCrudTest {

    private var testRunID: String? = null
    private var factory: TestClientFactory? = null
    private val configs: MutableMap<String, RemoteServerConfig> = HashMap()
    val logger = LoggerFactory.getLogger("com.pydio.kotlin.sdk.integration.BasicCrudTest")

    @Before
    fun setup() {
        testRunID = TestUtils.randomString(4)
        factory = TestClientFactory(
            TestCredentialService(MemoryStore(), MemoryStore()), MemoryStore(), MemoryStore()
        )
        SetupUtils().loadConfigs().forEach { k, v -> configs[k] = v }
    }

    @After
    fun teardown() {
        // do nothing
    }

    @Test
    fun testSimpleCRUD() = runBlocking {
        var foundAtLeastOne = false
        configs.forEach { (_, config) ->
            if (!config.skipServer && config.isAdmin) {
                println("... Simple CRUD can run on ${config.stateID}")
                testWorkspaces(config)
                basicCRUD(config)
                foundAtLeastOne = true
            }
        }
        if (!foundAtLeastOne) {
            println("[Warning] No fitting configuration found, skip TestSimpleCRUD")
        }
    }

    private fun testWorkspaces(conf: RemoteServerConfig) {
        check(factory != null)
        val transport: Transport = TestUtils.getTransport(factory!!, conf)
        println("... Listing workspaces for ${transport.stateID}")
        factory!!.getClient(transport).getWorkspaceList {
            println("#" + " " + it.slug)
        }
    }

    suspend fun basicCRUD(conf: RemoteServerConfig) {
        val transport: Transport = TestUtils.getTransport(factory!!, conf)
        val name = "hello-$testRunID.txt"
        val targetStateID = transport.stateID.withPath("/${conf.defaultWS}/$name")
        var message = "Hello Pydio! - this is a message from test run #$testRunID"
        println("... Testing CRUD for ${transport.stateID}")

        uploadTest(transport as CellsTransport, targetStateID, message)
    }

    private suspend fun uploadTest(
        transport: CellsTransport,
        stateID: StateID,
        content: String,
    ) {
        val minioClient = CellsMinioClient(transport)
        minioClient.upload(
            stateID = stateID,
            content = content,
            progressListener = DebugPL()
        )
    }

    class DebugPL : ProgressListener {
        override fun onProgress(processed: Long): String? {
            println("[DEBUG] Progress: ${processed}")
            return null
        }
    }


    private suspend fun uploadTest2(
        transport: CellsTransport,
        s3Client: CellsS3Client,
        stateID: StateID,
        content: InputStream,
    ): Long {

        var connection: HttpURLConnection? = null
        try {
            val preSignedURL = s3Client.getUploadPreSignedURL(stateID)
            check(preSignedURL != null)
            val serverUrl = transport.server.newURL(preSignedURL.path).withQuery(preSignedURL.query)
            connection = transport.withUserAgent(serverUrl.openConnection())
            connection.doOutput = true
            val output = connection.outputStream
            return IoHelpers.pipeRead(content, output)
        } finally {
            IoHelpers.closeQuietly(connection)
        }
    }


//    private suspend fun uploadTest2(
//        transport: CellsTransport,
//        s3Client: CellsS3Client,
//        stateID: StateID,
//        content: String,
//    ) {
//
//        val unsignedRequest = PutObjectRequest {
//            bucket = s3Client.defaultBucketName
//            key = stateID.path?.substring(1)
//            contentType = S3Names.S3_CONTENT_TYPE_OCTET_STREAM
//        }
//
//
//        val awsS3Client = s3Client.getAwsS3Client()
//
//        val preSignedRequest = awsS3Client.presignPutObject(unsignedRequest, 24.hours)
//
//        val putRequest = Request
//            .Builder()
//            .url(preSignedRequest.url.toString())
//            .apply {
//                preSignedRequest.headers.forEach { key, values ->
//                    header(key, values.joinToString(", "))
//                }
//            }.put(content.toRequestBody())
//            .build()
//
//        val response = transport.authenticatedClient().build().newCall(putRequest).execute()
//        println("## After Put - Success: ${response.isSuccessful}")
//        println("\t ${response.code} - ${response.message}")
//        assert(response.isSuccessful)
//    }

//    suspend fun putObjectPresigned(
//        bucketName: String,
//        keyName: String,
//        content: String,
//    ) {
//        // Create a PutObjectRequest.
//        val unsignedRequest =
//            PutObjectRequest {
//                bucket = bucketName
//                key = keyName
//            }
//
//        val presignedRequest = s3.presignPutObject(unsignedRequest, 24.hours)
//
//        // Use the URL and any headers from the presigned HttpRequest in a subsequent HTTP PUT request to retrieve the object.
//        // Create a PUT request using the OKHttpClient API.
//        val putRequest =
//            Request
//                .Builder()
//                .url(presignedRequest.url.toString())
//                .apply {
//                    presignedRequest.headers.forEach { key, values ->
//                        header(key, values.joinToString(", "))
//                    }
//                }.put(content.toRequestBody())
//                .build()
//
//        val response = OkHttpClient().newCall(putRequest).execute()
//        assert(response.isSuccessful)
//    }

//    @Test
//    fun putObjectPresignTest() =
//        runBlocking {
//            val bucketName = "bucketName"
//            val keyName = "keyName"
//
//            val contents = "Hello World"
//            logger.info("start putObjectPresignTest")
//            var returnedContent: String? = null
//            try {
//                putObjectPresigned(bucketName, keyName, contents)
//
//                returnedContent =
//                    s3.getObject(
//                        GetObjectRequest {
//                            bucket = bucketName
//                            key = keyName
//                        },
//                    ) { resp ->
//                        val respString = resp.body?.decodeToString()
//                        respString
//                    }
//            } catch (e: Exception) {
//                logger.error("Exception thrown: ${e.message}")
////            } finally {
////                deleteObject(s3, bucketName, keyName)
//            }
////            Assertions.assertEquals(contents, returnedContent)
//            logger.info("putObjectPresigned returned the same content")
//        }

}


