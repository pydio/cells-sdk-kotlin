package com.pydio.kotlin.sdk.integration

//import com.pydio.kotlin.sdk.transport.CellsMinioClient
import com.pydio.kotlin.sdk.api.ProgressListener
import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.client.CellsClient
import com.pydio.kotlin.sdk.transport.CellsTransport
import com.pydio.kotlin.sdk.transport.StateID
import com.pydio.kotlin.sdk.utils.MemoryStore
import com.pydio.kotlin.sdk.utils.tests.NoAwsS3Client
import com.pydio.kotlin.sdk.utils.tests.RemoteServerConfig
import com.pydio.kotlin.sdk.utils.tests.TestClientFactory
import com.pydio.kotlin.sdk.utils.tests.TestCredentialService
import com.pydio.kotlin.sdk.utils.tests.TestUtils
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory

class SimpleCrudTest {

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

        val transport: CellsTransport = TestUtils.getTransport(factory!!, conf) as CellsTransport
        println("... Testing CRUD for ${transport.stateID}")

        val name = "hello-$testRunID.txt"
        val targetStateID = transport.stateID.withPath("/${conf.defaultWS}/$name")
        var message = "Hello Pydio! - this is a message from test run #$testRunID"

        // Upload a simple text file
        uploadStringAsFile(transport, targetStateID, message)
        // Check created file
        dlAndCheck(transport, targetStateID, message)

        // Update the file content and re-check
        message += "\n... With some extra content"
        uploadStringAsFile(transport, targetStateID, message)
        dlAndCheck(transport, targetStateID, message)

        // Delete
        delete(transport, targetStateID, true)
    }

    private suspend fun uploadStringAsFile(
        transport: CellsTransport,
        stateID: StateID,
        content: String,
    ) {
//        val minioClient = CellsMinioClient(transport)
//        minioClient.upload(
//            stateID = stateID,
//            content = content,
//            progressListener = DebugPL()
//        )
    }

    private suspend fun dlAndCheck(
        transport: CellsTransport,
        stateID: StateID,
        expected: String,
    ) {
//        val minioClient = CellsMinioClient(transport)
//        var retrievedMsg = ""
//        for (i in 0 until 10) {
//            val out = ByteArrayOutputStream()
//            try {
//                minioClient.download(
//                    stateID = stateID,
//                    outputStream = out,
//                    progressListener = DebugPL()
//                )
//                out.flush()
//                retrievedMsg = out.toString(StandardCharsets.UTF_8.name())
//                if (expected == retrievedMsg) {
//                    break
//                }
//                println("Try #${i + 1} failed. Waiting 2s before retry.")
//                Thread.sleep(2000)
//            } catch (e: Exception) {
//                println("Unexpected Exception: $e")
//                e.printStackTrace()
//            } finally {
//                out.close()
//            }
//        }
//        assert(expected == retrievedMsg)
    }

    private fun delete(transport: CellsTransport, targetStateID: StateID, checkDeleted: Boolean) {
        val cellsClient = CellsClient(transport, NoAwsS3Client())
        val slug = targetStateID.slug!!
        val name = targetStateID.fileName!!
        cellsClient.delete(slug, arrayOf(targetStateID.file!!), true)
        if (checkDeleted) {
            var deleted = false
            for (i in 0 until 10) {
                try {
                    // Check if deleted file is still there
                    val founds = mutableListOf<String>()
                    cellsClient.ls(slug, targetStateID.parent().file!!, null) { node ->
                        val currName = TestUtils.getNameFromPath(node.path!!)
                        if (name == currName) {
                            founds.add(name)
                        }
                    }
                    if (founds.isEmpty()) {
                        deleted = true
                        break
                    }
                    println("Try #${i + 1} failed. Waiting 2s before retry.")
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            assert(deleted == true)
        }
    }

    class DebugPL : ProgressListener {
        override fun onProgress(processed: Long): String? {
            println("[DEBUG] Progress: $processed")
            return null
        }
    }
}
