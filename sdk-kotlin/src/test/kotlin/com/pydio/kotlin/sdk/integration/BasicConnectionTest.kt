package com.pydio.kotlin.sdk.integration

import com.pydio.kotlin.sdk.api.ServerConnection
import com.pydio.kotlin.sdk.utils.MemoryStore
import com.pydio.kotlin.sdk.utils.tests.RemoteServerConfig
import com.pydio.kotlin.sdk.utils.tests.TestClientFactory
import com.pydio.kotlin.sdk.utils.tests.TestCredentialService
import com.pydio.kotlin.sdk.utils.tests.TestUtils
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import javax.net.ssl.SSLHandshakeException

/**
 * Performs basic tests against a running Cells Server instance.
 *
 * You must first adapt the "src/test/resources/accounts/ *.properties" files (at least one of them) to match your setup.
 *
 * You can then launch the test with:  `./gradlew build -Dtest.profile=integration`
 */
class BasicConnectionTest {

    private var factory: TestClientFactory? = null
    private var configs: MutableMap<String, RemoteServerConfig> = HashMap()
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
    fun testSkipVerify() {
        var foundAtLeastOne = false
        configs.forEach { (_, config) ->
            if (!config.skipServer && config.skipVerify) {
                println("[Debug] Test SkipVerify for ${config.stateID}")
                doPerformSkipTest(config.urlString)
                foundAtLeastOne = true
            }
        }
        if (!foundAtLeastOne) {
            println("[Warning] No fitting configuration found, skip TestSkipVerify")
        }
    }

    fun doPerformSkipTest(urlString: String) {
        var gotAnError = false
        try {
            val sc = ServerConnection.fromAddress(urlString, false)
            sc.ping()
            Assert.assertFalse(true) // we should never reach this point
        } catch (_: SSLHandshakeException) {
            gotAnError = true
        }
        Assert.assertTrue(gotAnError)
        try {
            val sc = ServerConnection.fromAddress(urlString, true)
            sc.ping()
            gotAnError = false
        } catch (_: SSLHandshakeException) {
            Assert.assertFalse(true) // we should never reach this point
        }
        Assert.assertFalse(gotAnError)
    }

//    private fun printFileContents(inputStream: InputStream?) {
//        inputStream?.use { stream ->
//            val content = stream.readBytes().toString(Charsets.UTF_8)
//            println(content)
//        } ?: println("Input stream is null")
//    }
}
