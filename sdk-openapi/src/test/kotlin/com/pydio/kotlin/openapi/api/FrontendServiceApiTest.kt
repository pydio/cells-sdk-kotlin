/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.api

import io.kotlintest.specs.ShouldSpec

class FrontendServiceApiTest : ShouldSpec() {
  init {
    // uncomment below to create an instance of FrontendServiceApi
    // val apiInstance = FrontendServiceApi()

    // to test frontBootConf
    should("test frontBootConf") {
      // uncomment below to test frontBootConf
      // val result : RestFrontBootConfResponse = apiInstance.frontBootConf()
      // result shouldBe ("TODO")
    }

    // to test frontEnrollAuth
    should("test frontEnrollAuth") {
      // uncomment below to test frontEnrollAuth
      // val body : RestFrontEnrollAuthRequest =  // RestFrontEnrollAuthRequest |
      // val result : RestFrontEnrollAuthResponse = apiInstance.frontEnrollAuth(body)
      // result shouldBe ("TODO")
    }

    // to test frontMessages
    should("test frontMessages") {
      // uncomment below to test frontMessages
      // val lang : kotlin.String = lang_example // kotlin.String |
      // val result : RestFrontMessagesResponse = apiInstance.frontMessages(lang)
      // result shouldBe ("TODO")
    }

    // to test frontPlugins
    should("test frontPlugins") {
      // uncomment below to test frontPlugins
      // val lang : kotlin.String = lang_example // kotlin.String |
      // val result : RestFrontPluginsResponse = apiInstance.frontPlugins(lang)
      // result shouldBe ("TODO")
    }

    // to test frontPutBinary
    should("test frontPutBinary") {
      // uncomment below to test frontPutBinary
      // val binaryType : kotlin.String = binaryType_example // kotlin.String | Currently supported
      // values are USER and GLOBAL
      // val uuid : kotlin.String = uuid_example // kotlin.String | Id of the binary
      // val result : RestFrontBinaryResponse = apiInstance.frontPutBinary(binaryType, uuid)
      // result shouldBe ("TODO")
    }

    // to test frontServeBinary
    should("test frontServeBinary") {
      // uncomment below to test frontServeBinary
      // val binaryType : kotlin.String = binaryType_example // kotlin.String | Currently supported
      // values are USER and GLOBAL
      // val uuid : kotlin.String = uuid_example // kotlin.String | Id of the binary
      // val result : RestFrontBinaryResponse = apiInstance.frontServeBinary(binaryType, uuid)
      // result shouldBe ("TODO")
    }

    // to test frontSession
    should("test frontSession") {
      // uncomment below to test frontSession
      // val body : RestFrontSessionRequest =  // RestFrontSessionRequest |
      // val result : RestFrontSessionResponse = apiInstance.frontSession(body)
      // result shouldBe ("TODO")
    }

    // to test frontState
    should("test frontState") {
      // uncomment below to test frontState
      // val xpath : kotlin.String = xpath_example // kotlin.String |
      // val result : RestFrontStateResponse = apiInstance.frontState(xpath)
      // result shouldBe ("TODO")
    }

    // to test settingsMenu
    should("test settingsMenu") {
      // uncomment below to test settingsMenu
      // val result : RestSettingsMenuResponse = apiInstance.settingsMenu()
      // result shouldBe ("TODO")
    }
  }
}
