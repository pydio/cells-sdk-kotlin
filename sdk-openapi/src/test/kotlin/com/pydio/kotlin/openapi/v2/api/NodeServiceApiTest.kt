/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.pydio.kotlin.openapi.v2.api

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import com.pydio.kotlin.openapi.v2.api.NodeServiceApi
import com.pydio.kotlin.openapi.v2.model.IdmSearchUserMetaRequest
import com.pydio.kotlin.openapi.v2.model.JobsCtrlCommand
import com.pydio.kotlin.openapi.v2.model.RestActionParameters
import com.pydio.kotlin.openapi.v2.model.RestBackgroundAction
import com.pydio.kotlin.openapi.v2.model.RestBatchUpdateMetaList
import com.pydio.kotlin.openapi.v2.model.RestCreateCheckRequest
import com.pydio.kotlin.openapi.v2.model.RestCreateCheckResponse
import com.pydio.kotlin.openapi.v2.model.RestCreateRequest
import com.pydio.kotlin.openapi.v2.model.RestError
import com.pydio.kotlin.openapi.v2.model.RestListTemplatesResponse
import com.pydio.kotlin.openapi.v2.model.RestLookupRequest
import com.pydio.kotlin.openapi.v2.model.RestNamespaceValuesOperation
import com.pydio.kotlin.openapi.v2.model.RestNamespaceValuesResponse
import com.pydio.kotlin.openapi.v2.model.RestNode
import com.pydio.kotlin.openapi.v2.model.RestNodeCollection
import com.pydio.kotlin.openapi.v2.model.RestNodeUpdates
import com.pydio.kotlin.openapi.v2.model.RestPerformActionResponse
import com.pydio.kotlin.openapi.v2.model.RestPublicLinkDeleteSuccess
import com.pydio.kotlin.openapi.v2.model.RestPublicLinkRequest
import com.pydio.kotlin.openapi.v2.model.RestSelection
import com.pydio.kotlin.openapi.v2.model.RestShareLink
import com.pydio.kotlin.openapi.v2.model.RestUserMetaList
import com.pydio.kotlin.openapi.v2.model.RestUserMetaNamespaceCollection

class NodeServiceApiTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of NodeServiceApi
        //val apiInstance = NodeServiceApi()

        // to test backgroundActionInfo
        should("test backgroundActionInfo") {
            // uncomment below to test backgroundActionInfo
            //val name : kotlin.String = name_example // kotlin.String | 
            //val jobUuid : kotlin.String = jobUuid_example // kotlin.String | 
            //val result : RestBackgroundAction = apiInstance.backgroundActionInfo(name, jobUuid)
            //result shouldBe ("TODO")
        }

        // to test batchUpdateMeta
        should("test batchUpdateMeta") {
            // uncomment below to test batchUpdateMeta
            //val body : RestBatchUpdateMetaList =  // RestBatchUpdateMetaList | 
            //val result : RestBatchUpdateMetaList = apiInstance.batchUpdateMeta(body)
            //result shouldBe ("TODO")
        }

        // to test controlBackgroundAction
        should("test controlBackgroundAction") {
            // uncomment below to test controlBackgroundAction
            //val name : kotlin.String = name_example // kotlin.String | 
            //val jobUuid : kotlin.String = jobUuid_example // kotlin.String | 
            //val command : JobsCtrlCommand =  // JobsCtrlCommand | 
            //val result : RestBackgroundAction = apiInstance.controlBackgroundAction(name, jobUuid, command)
            //result shouldBe ("TODO")
        }

        // to test create
        should("test create") {
            // uncomment below to test create
            //val body : RestCreateRequest =  // RestCreateRequest | 
            //val result : RestNodeCollection = apiInstance.create(body)
            //result shouldBe ("TODO")
        }

        // to test createCheck
        should("test createCheck") {
            // uncomment below to test createCheck
            //val body : RestCreateCheckRequest =  // RestCreateCheckRequest | Request for pre-checking nodes before uploading or creating them.
            //val result : RestCreateCheckResponse = apiInstance.createCheck(body)
            //result shouldBe ("TODO")
        }

        // to test createPublicLink
        should("test createPublicLink") {
            // uncomment below to test createPublicLink
            //val uuid : kotlin.String = uuid_example // kotlin.String | 
            //val publicLinkRequest : RestPublicLinkRequest =  // RestPublicLinkRequest | 
            //val result : RestShareLink = apiInstance.createPublicLink(uuid, publicLinkRequest)
            //result shouldBe ("TODO")
        }

        // to test createSelection
        should("test createSelection") {
            // uncomment below to test createSelection
            //val body : RestSelection =  // RestSelection | Request to create a selection from a list of nodes.
            //val result : RestSelection = apiInstance.createSelection(body)
            //result shouldBe ("TODO")
        }

        // to test deletePublicLink
        should("test deletePublicLink") {
            // uncomment below to test deletePublicLink
            //val linkUuid : kotlin.String = linkUuid_example // kotlin.String | 
            //val result : RestPublicLinkDeleteSuccess = apiInstance.deletePublicLink(linkUuid)
            //result shouldBe ("TODO")
        }

        // to test getByUuid
        should("test getByUuid") {
            // uncomment below to test getByUuid
            //val uuid : kotlin.String = uuid_example // kotlin.String | 
            //val path : kotlin.String = path_example // kotlin.String | 
            //val result : RestNode = apiInstance.getByUuid(uuid, path)
            //result shouldBe ("TODO")
        }

        // to test getPublicLink
        should("test getPublicLink") {
            // uncomment below to test getPublicLink
            //val linkUuid : kotlin.String = linkUuid_example // kotlin.String | 
            //val result : RestShareLink = apiInstance.getPublicLink(linkUuid)
            //result shouldBe ("TODO")
        }

        // to test listNamespaceValues
        should("test listNamespaceValues") {
            // uncomment below to test listNamespaceValues
            //val namespace : kotlin.String = namespace_example // kotlin.String | List persisted values for this namespace
            //val operationOperation : kotlin.String = operationOperation_example // kotlin.String | 
            //val operationValues : kotlin.collections.List<kotlin.String> =  // kotlin.collections.List<kotlin.String> | 
            //val result : RestNamespaceValuesResponse = apiInstance.listNamespaceValues(namespace, operationOperation, operationValues)
            //result shouldBe ("TODO")
        }

        // to test listNamespaces
        should("test listNamespaces") {
            // uncomment below to test listNamespaces
            //val result : RestUserMetaNamespaceCollection = apiInstance.listNamespaces()
            //result shouldBe ("TODO")
        }

        // to test listVersions
        should("test listVersions") {
            // uncomment below to test listVersions
            //val uuid : kotlin.String = uuid_example // kotlin.String | 
            //val path : kotlin.String = path_example // kotlin.String | 
            //val result : RestNodeCollection = apiInstance.listVersions(uuid, path)
            //result shouldBe ("TODO")
        }

        // to test lookup
        should("test lookup") {
            // uncomment below to test lookup
            //val body : RestLookupRequest =  // RestLookupRequest | 
            //val result : RestNodeCollection = apiInstance.lookup(body)
            //result shouldBe ("TODO")
        }

        // to test patchNode
        should("test patchNode") {
            // uncomment below to test patchNode
            //val uuid : kotlin.String = uuid_example // kotlin.String | 
            //val nodeUpdates : RestNodeUpdates =  // RestNodeUpdates | 
            //val result : RestNode = apiInstance.patchNode(uuid, nodeUpdates)
            //result shouldBe ("TODO")
        }

        // to test performAction
        should("test performAction") {
            // uncomment below to test performAction
            //val name : kotlin.String = name_example // kotlin.String | 
            //val parameters : RestActionParameters =  // RestActionParameters | 
            //val jobUuid : kotlin.String = jobUuid_example // kotlin.String | 
            //val result : RestPerformActionResponse = apiInstance.performAction(name, parameters, jobUuid)
            //result shouldBe ("TODO")
        }

        // to test searchMeta
        should("test searchMeta") {
            // uncomment below to test searchMeta
            //val body : IdmSearchUserMetaRequest =  // IdmSearchUserMetaRequest | 
            //val result : RestUserMetaList = apiInstance.searchMeta(body)
            //result shouldBe ("TODO")
        }

        // to test templates
        should("test templates") {
            // uncomment below to test templates
            //val templateType : kotlin.String = templateType_example // kotlin.String | 
            //val result : RestListTemplatesResponse = apiInstance.templates(templateType)
            //result shouldBe ("TODO")
        }

        // to test updateNamespaceValues
        should("test updateNamespaceValues") {
            // uncomment below to test updateNamespaceValues
            //val namespace : kotlin.String = namespace_example // kotlin.String | List persisted values for this namespace
            //val operation : RestNamespaceValuesOperation =  // RestNamespaceValuesOperation | 
            //val result : RestNamespaceValuesResponse = apiInstance.updateNamespaceValues(namespace, operation)
            //result shouldBe ("TODO")
        }

        // to test updatePublicLink
        should("test updatePublicLink") {
            // uncomment below to test updatePublicLink
            //val linkUuid : kotlin.String = linkUuid_example // kotlin.String | 
            //val publicLinkRequest : RestPublicLinkRequest =  // RestPublicLinkRequest | 
            //val result : RestShareLink = apiInstance.updatePublicLink(linkUuid, publicLinkRequest)
            //result shouldBe ("TODO")
        }

        // to test userBookmarks
        should("test userBookmarks") {
            // uncomment below to test userBookmarks
            //val all : kotlin.Boolean = true // kotlin.Boolean | 
            //val result : RestNodeCollection = apiInstance.userBookmarks(all)
            //result shouldBe ("TODO")
        }

    }
}
