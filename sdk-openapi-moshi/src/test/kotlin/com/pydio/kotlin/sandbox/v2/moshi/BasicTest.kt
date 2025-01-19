@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.sandbox.v2.moshi

import com.pydio.kotlin.openapi.v2.moshi.api.NodeServiceApi
import com.pydio.kotlin.openapi.v2.moshi.model.RestCreateRequest
import com.pydio.kotlin.openapi.v2.moshi.model.RestIncomingNode
import com.pydio.kotlin.openapi.v2.moshi.model.RestLookupRequest
import com.pydio.kotlin.openapi.v2.moshi.model.RestNodeLocator
import com.pydio.kotlin.openapi.v2.moshi.model.RestNodeLocators
import com.pydio.kotlin.openapi.v2.moshi.model.TreeNodeType
import io.kotlintest.matchers.numerics.shouldBeGreaterThanOrEqual
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.ShouldSpec
import java.util.UUID

class BasicTest : ShouldSpec() {

  init {
    val apiInstance = NodeServiceApi("${SERVER_URL}/a", getTestHttpClient())

    should("ping server") { pingServer() shouldBe 200 }

    should("test create") {
      val name = "test-kotlin-moshi-${unique()}.txt"

      val newPath = "common-files/$name"
      try {
        val q1 =
            RestCreateRequest(
                inputs =
                    listOf(
                        RestIncomingNode(
                            type = TreeNodeType.LEAF,
                            locator = RestNodeLocator(path = newPath),
                            contentType = "text/plain")),
                recursive = false,
            )
        val r1 = apiInstance.create(q1)
        r1.nodes.size shouldBe 1

        val q2 =
            RestLookupRequest(
                locators = RestNodeLocators(listOf(RestNodeLocator(path = newPath))),
            )
        val r2 = apiInstance.lookup(q2)
        r2.nodes.size shouldBeGreaterThanOrEqual 1
        var found = false
        var foundUuid: String? = null
        r2.nodes.forEach {
          if (it.path == newPath) {
            if (it.uuid == r1.nodes[0].uuid) {
              found = true
              foundUuid = it.uuid
            }
          }
        }
        found shouldBe true
        foundUuid shouldNotBe null

        val r3 = apiInstance.getByUuid(uuid = foundUuid!!)
        r3 shouldNotBe null
        //
        //
        //                val r4 = apiInstance.performAction(
        //                    name = NamePerformAction.delete,
        //                    parameters = RestActionParameters (
        //                        nodes = listOf(RestNodeLocator(uuid = r1.nodes[0].uuid))
        //                    )
        //                )
        //                r4.status shouldBe RestActionStatus.Background

        // putS3Object("common-files/tests.txt")
      } catch (e: Exception) {
        e shouldBe null
      }
    }
  }
}

fun unique(length: Int = 4): String {
  val id: String = UUID.randomUUID().toString()
  return id.take(length)
}
