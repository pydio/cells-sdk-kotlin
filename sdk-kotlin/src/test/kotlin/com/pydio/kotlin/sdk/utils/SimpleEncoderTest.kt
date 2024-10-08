package com.pydio.kotlin.sdk.utils

import org.junit.Assert
import org.junit.Test

class SimpleEncoderTest {

    @Test
    fun testUTF8Encode() {
        val encoder = SimpleEncoder()
        val start1 = "This is 100% testing funky chars // =="
        val target1 = encoder.utf8Encode(start1)

        val restart1 = encoder.utf8Decode(target1)
        Assert.assertEquals(
            "strings should be the same after encoding / decoding",
            start1,
            restart1
        )

        val start2 = "https://www.example.com:8080/"
        val target2 = encoder.utf8Encode(start2)
        Assert.assertTrue("$start2 should contain a slash", start2.contains('/'))
        Assert.assertFalse("$target2 should not contain any slash", target2.contains('/'))
        Assert.assertTrue("$start2 should contain a column", start2.contains(':'))
        Assert.assertFalse("$target2 should not contain any column", target2.contains(':'))

        val start3 = "alice.mottmott@oldies.example.com"
        val target3 = encoder.utf8Encode(start3)
        Assert.assertTrue("$start3 should contain a @", start3.contains('@'))
        Assert.assertFalse("$target3 should not contain any @", target3.contains('@'))
    }

    @Test
    fun testBase64Encode() {
        val encoder = SimpleEncoder()
        val start1 = "This is 100% testing funky chars // =="
        val target1 = encoder.base64Encode(start1)

        val restart1 = encoder.base64Decode(target1)
        Assert.assertEquals(
            "strings should be the same after encoding / decoding",
            start1,
            restart1
        )
    }
}
