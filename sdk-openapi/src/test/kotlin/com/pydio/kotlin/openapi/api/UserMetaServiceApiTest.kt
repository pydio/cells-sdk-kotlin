/**
 * Please note: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
@file:Suppress("ArrayInDataClass", "EnumEntryName", "RemoveRedundantQualifierName", "UnusedImport")

package com.pydio.kotlin.openapi.api

import io.kotlintest.specs.ShouldSpec

class UserMetaServiceApiTest : ShouldSpec() {
  init {
    // uncomment below to create an instance of UserMetaServiceApi
    // val apiInstance = UserMetaServiceApi()

    // to test deleteUserMetaTags
    should("test deleteUserMetaTags") {
      // uncomment below to test deleteUserMetaTags
      // val namespace : kotlin.String = namespace_example // kotlin.String | Delete tags from this
      // namespace
      // val tags : kotlin.String = tags_example // kotlin.String | Delete this tag
      // val result : RestDeleteUserMetaTagsResponse = apiInstance.deleteUserMetaTags(namespace,
      // tags)
      // result shouldBe ("TODO")
    }

    // to test listUserMetaNamespace
    should("test listUserMetaNamespace") {
      // uncomment below to test listUserMetaNamespace
      // val result : RestUserMetaNamespaceCollection = apiInstance.listUserMetaNamespace()
      // result shouldBe ("TODO")
    }

    // to test listUserMetaTags
    should("test listUserMetaTags") {
      // uncomment below to test listUserMetaTags
      // val namespace : kotlin.String = namespace_example // kotlin.String | List user meta tags
      // for this namespace
      // val result : RestListUserMetaTagsResponse = apiInstance.listUserMetaTags(namespace)
      // result shouldBe ("TODO")
    }

    // to test putUserMetaTag
    should("test putUserMetaTag") {
      // uncomment below to test putUserMetaTag
      // val namespace : kotlin.String = namespace_example // kotlin.String | Add a tag value for
      // this namespace
      // val body : RestPutUserMetaTagRequest =  // RestPutUserMetaTagRequest |
      // val result : RestPutUserMetaTagResponse = apiInstance.putUserMetaTag(namespace, body)
      // result shouldBe ("TODO")
    }

    // to test searchUserMeta
    should("test searchUserMeta") {
      // uncomment below to test searchUserMeta
      // val body : IdmSearchUserMetaRequest =  // IdmSearchUserMetaRequest |
      // val result : RestUserMetaCollection = apiInstance.searchUserMeta(body)
      // result shouldBe ("TODO")
    }

    // to test updateUserMeta
    should("test updateUserMeta") {
      // uncomment below to test updateUserMeta
      // val body : IdmUpdateUserMetaRequest =  // IdmUpdateUserMetaRequest |
      // val result : IdmUpdateUserMetaResponse = apiInstance.updateUserMeta(body)
      // result shouldBe ("TODO")
    }

    // to test updateUserMetaNamespace
    should("test updateUserMetaNamespace") {
      // uncomment below to test updateUserMetaNamespace
      // val body : IdmUpdateUserMetaNamespaceRequest =  // IdmUpdateUserMetaNamespaceRequest |
      // val result : IdmUpdateUserMetaNamespaceResponse = apiInstance.updateUserMetaNamespace(body)
      // result shouldBe ("TODO")
    }

    // to test userBookmarks
    should("test userBookmarks") {
      // uncomment below to test userBookmarks
      // val body : RestUserBookmarksRequest =  // RestUserBookmarksRequest |
      // val result : RestBulkMetaResponse = apiInstance.userBookmarks(body)
      // result shouldBe ("TODO")
    }
  }
}
