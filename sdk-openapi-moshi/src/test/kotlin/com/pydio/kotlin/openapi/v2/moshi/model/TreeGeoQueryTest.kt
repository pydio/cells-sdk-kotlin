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

package com.pydio.kotlin.openapi.v2.moshi.model

import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

import com.pydio.kotlin.openapi.v2.moshi.model.TreeGeoQuery
import com.pydio.kotlin.openapi.v2.moshi.model.TreeGeoPoint

class TreeGeoQueryTest : ShouldSpec() {
    init {
        // uncomment below to create an instance of TreeGeoQuery
        //val modelInstance = TreeGeoQuery()

        // to test the property `bottomRight`
        should("test bottomRight") {
            // uncomment below to test the property
            //modelInstance.bottomRight shouldBe ("TODO")
        }

        // to test the property `center`
        should("test center") {
            // uncomment below to test the property
            //modelInstance.center shouldBe ("TODO")
        }

        // to test the property `distance` - Example formats supported: \"5in\" \"5inch\" \"7yd\" \"7yards\" \"9ft\" \"9feet\" \"11km\" \"11kilometers\" \"3nm\" \"3nauticalmiles\" \"13mm\" \"13millimeters\" \"15cm\" \"15centimeters\" \"17mi\" \"17miles\" \"19m\" \"19meters\" If the unit cannot be determined, the entire string is parsed and the unit of meters is assumed.
        should("test distance") {
            // uncomment below to test the property
            //modelInstance.distance shouldBe ("TODO")
        }

        // to test the property `topLeft`
        should("test topLeft") {
            // uncomment below to test the property
            //modelInstance.topLeft shouldBe ("TODO")
        }

    }
}
