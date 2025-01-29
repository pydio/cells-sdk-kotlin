import com.pydio.kotlin.openapi.kmp.api.NodeServiceApi
import com.pydio.kotlin.openapi.kmp.model.RestCreateRequest
import com.pydio.kotlin.openapi.kmp.model.RestIncomingNode
import com.pydio.kotlin.openapi.kmp.model.RestLookupRequest
import com.pydio.kotlin.openapi.kmp.model.RestNodeLocator
import com.pydio.kotlin.openapi.kmp.model.RestNodeLocators
import com.pydio.kotlin.openapi.kmp.model.TreeNodeType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class TestZero {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val dispatcher = UnconfinedTestDispatcher()

    @Test
    fun testIt() = runTest(dispatcher) {

        val name = "test-kotlin-kmm-${unique()}.txt"
        val newPath = "common-files/$name"
        val apiInstance = NodeServiceApi("${SERVER_URL}/a", getMyHttpClient())

        try {
            val q1 = RestCreateRequest(
                inputs = listOf(
                    RestIncomingNode(
                        type = TreeNodeType.LEAF,
                        locator = RestNodeLocator(path = newPath),
                        contentType = "text/plain"
                    )
                ),
                recursive = false,
            )
            val r1 = apiInstance.create(q1)
            assertTrue(r1.success, "create node for $newPath failed, status: ${r1.response.status}")
            assertEquals(r1.body().nodes.size, 1)
            val nodeUuid = r1.body().nodes.get(0).uuid
            assertNotNull(nodeUuid)

            val q2 = RestLookupRequest(
                locators = RestNodeLocators(listOf(RestNodeLocator(path = newPath))),
            )
            val r2 = apiInstance.lookup(q2)
            assertTrue(r2.success, "lookup node at $newPath failed, status: ${r2.response.status}")
            assertTrue(r2.body().nodes.isNotEmpty())

            var found = false
            var foundUuid: String? = null
            r2.body().nodes.forEach {
                if (it.path == newPath) {
                    if (it.uuid == nodeUuid) {
                        found = true
                        foundUuid = it.uuid
                    }
                }
            }
            assertTrue(found)

            val r3 = apiInstance.getByUuid(uuid = foundUuid!!)
            assertTrue(r3.success, "lookup node with uuid $foundUuid failed, status: ${r3.response.status}")
            assertNotNull(r3.body())

            //
            //
            //                val r4 = apiInstance.performAction(
            //                    name = NamePerformAction.delete,
            //                    parameters = RestActionParameters (
            //                        nodes = listOf(RestNodeLocator(uuid = r1.nodes[0].uuid))
            //                    )
            //                )
            //                r4.status shouldBe RestActionStatus.Background

//                 putS3Object("common-files/test-simple-put-${unique()}.txt")
        } catch (e: Exception) {
            e.printStackTrace()
            assertTrue(false)
        }
    }
}
