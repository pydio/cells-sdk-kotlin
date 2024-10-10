package com.pydio.kotlin.sdk.integration

import com.pydio.kotlin.sdk.api.Transport
import com.pydio.kotlin.sdk.client.CellsClient
import com.pydio.kotlin.sdk.utils.MemoryStore
import com.pydio.kotlin.sdk.utils.tests.RemoteServerConfig
import com.pydio.kotlin.sdk.utils.tests.TestClientFactory
import com.pydio.kotlin.sdk.utils.tests.TestCredentialService
import com.pydio.kotlin.sdk.utils.tests.TestUtils
import org.junit.After
import org.junit.Before
import org.junit.Test

class BasicCrudTest {

    private var factory: TestClientFactory? = null
    private val configs: MutableMap<String, RemoteServerConfig> = HashMap()
    private var testRunID: String? = null

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
    fun testSimpleCRUD() {
        var foundAtLeastOne = false
        configs.forEach { (_, config) ->
            if (!config.skipServer && config.skipVerify) {
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

    fun basicCRUD(conf: RemoteServerConfig) {

        val transport: Transport = TestUtils.getTransport(factory!!, conf)
        val client: CellsClient = factory!!.getClient(transport) as CellsClient

        println("... Testing CRUD for ${transport.stateID}")

        val baseDir = "/"
        val name = "hello-" + testRunID + ".txt"
        var message = "Hello Pydio! - this is a message from test run #" + testRunID

        // Upload
//        var content = message.toByteArray()
//        var source: ByteArrayInputStream = ByteArrayInputStream(content)
//        client.upload(source, content.size, "text/plain",
//            conf.defaultWS, baseDir, name, true, { progress ->
//                System.out.printf("\r%d bytes written\n", progress)
//                ""
//            })
//
//        ByteArrayOutputStream().use { out ->
//            client.download(conf.defaultWS, baseDir + name, out, null)
//            out.flush()
//            val retrievedMsg: String? = out.toString(StandardCharsets.UTF_8)
//            println("Retrieved: " + retrievedMsg)
//            Assert.assertEquals(message, retrievedMsg)
//        }
        // Update fails in P8
//        if (!transport.getServer().isLegacy()) {
//            message += " -- Add with some additional content"
//            content = message.toByteArray()
//            source = ByteArrayInputStream(content)
//            client.upload(source, content.size, "text/plain",
//                conf.defaultWS, baseDir, name, true, { progress ->
//                    System.out.printf("\r%d bytes written\n", progress)
//                    ""
//                })
//
//            // Read updated
//            var retrievedMsg: String? = ""
//            for (i in 0..9) {
//                try {
//                    ByteArrayOutputStream().use { out ->
//                        client.download(conf.defaultWS, baseDir + name, out, null)
//                        out.flush()
//                        retrievedMsg = out.toString(StandardCharsets.UTF_8)
//                        println("Retrieved: " + retrievedMsg)
//
//                        if (message == retrievedMsg) {
//                            break
//                        }
//                        Thread.sleep(2000)
//                        println("Wait 2s before retry...")
//                    }
//                } catch (e: InterruptedException) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace()
//                }
//            }
//            Assert.assertEquals(message, retrievedMsg)
//        }
//
//        // Delete
//        client.delete(conf.defaultWS, arrayOf<String>("/" + name))
//
//        // Assert.assertNotNull(msg);
//        // Assert.assertEquals("EMPTY", msg.type());
//        var deleted = false
//        for (i in 0..9) {
//            try {
//                // Check if uploaded files is still there
//
//                val founds: MutableList<String?> = ArrayList<String?>()
//                client.ls(conf.defaultWS, baseDir, null, { node ->
//                    if (name == node.getName()) founds.add(name)
//                })
//                if (founds.size == 0) {
//                    deleted = true
//                    break
//                }
//                Thread.sleep(2000)
//                println("Wait 2s before retry...")
//            } catch (e: InterruptedException) {
//                // TODO Auto-generated catch block
//                e.printStackTrace()
//            }
//        }
//
//        Assert.assertTrue(deleted)
//
//        // TODO finish implementing the CRUD and corresponding checks.
    }

//    private class DummyHandler : NodeHandler {
//        private var i = 0
//
//        public override fun onNode(node: Node) {
//            println("#" + (++i) + " " + node.getName())
//            // System.out.println(node.getPath());
//        }
//    }
//
//    private fun printableId(techId: String?): String {
//        return StateID.fromId(techId).toString()
//    }
}