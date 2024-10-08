package com.pydio.kotlin.sdk.transport

import com.pydio.kotlin.sdk.api.CustomEncoder
import com.pydio.kotlin.sdk.utils.KotlinCustomEncoder
import org.junit.Assert
import org.junit.Test

/**
 * Basic tests to insure encoding/decoding of states work as expected.
 */
class StateIDTest {
    @Test
    fun testID() {
        val stateID = StateID("doe@example.com", "https://example.com")
        val encodedID = stateID.id

        val doubleEncodedID = StateID.utf8Encode(encodedID)
        val doubleDecoded = StateID.utf8Decode(doubleEncodedID)
        val decodedStateID = StateID.fromId(doubleDecoded)

        val stateID2 = StateID("doe@example.com", "https://example.com")
        val stateID3 = StateID("joe@example.com", "https://example.com")
        Assert.assertTrue(stateID.id.equals(stateID2.id))
        Assert.assertNotEquals(stateID, stateID3)

        Assert.assertEquals(stateID.username, decodedStateID!!.username)
        Assert.assertEquals(stateID.serverUrl, decodedStateID.serverUrl)
    }

    @Test
    fun testDerivedStateID() {
        val stateID = StateID(
            "doe@example.com",
            "http://example.com:6767",
            "/common-files/Documents/Subfolder"
        )
        val account = stateID.account()
        Assert.assertEquals("http://example.com:6767", account.serverUrl)
        Assert.assertNull(account.path)
        Assert.assertNull(account.slug)
        Assert.assertNull(account.file)
        Assert.assertNull(account.fileName)

        val ws = stateID.workspace()
        Assert.assertEquals("http://example.com:6767", ws!!.serverUrl)
        Assert.assertEquals("/common-files", ws.path)
        Assert.assertEquals("common-files", ws.slug)
        Assert.assertEquals("/", ws.file)
        Assert.assertNull(ws.fileName)
    }

    @Test
    fun testIDWithPath() {
        val stateID = StateID(
            "doe@example.com",
            "http://example.com:6767",
            "/common-files/Documents/Subfolder"
        )
        val encodedID = stateID.id

        val decodedStateID = StateID.fromId(encodedID)

        Assert.assertEquals("doe@example.com", decodedStateID!!.username)
        Assert.assertEquals("http://example.com:6767", decodedStateID.serverUrl)
        Assert.assertEquals("/common-files/Documents/Subfolder", decodedStateID.path)
        Assert.assertEquals("common-files", decodedStateID.slug)
        Assert.assertEquals("/Documents/Subfolder", decodedStateID.file)
        Assert.assertEquals("Subfolder", decodedStateID.fileName)
        Assert.assertEquals("/Documents", decodedStateID.parentFile)


        Assert.assertEquals(stateID.username, decodedStateID.username)
        Assert.assertEquals(stateID.serverUrl, decodedStateID.serverUrl)
        Assert.assertEquals(stateID.file, decodedStateID.file)
    }

    @Test
    fun testRoots() {
        val stateID = StateID("user", "https://example.com")
        val encodedID = stateID.id
        val decodedStateID = StateID.fromId(encodedID)

        Assert.assertNull(decodedStateID!!.path)
        Assert.assertNull(decodedStateID.file)
        Assert.assertNull(decodedStateID.fileName)
        Assert.assertNull(decodedStateID.parentFile)

        val stateID2 = stateID.withPath("/common-files")
        Assert.assertEquals("/common-files", stateID2.path)
        Assert.assertEquals("/", stateID2.file)
        Assert.assertNull(stateID2.fileName)
        Assert.assertNull(stateID2.parentFile)

        val stateID3 = stateID.withPath("/common-files/")
        Assert.assertNotEquals(stateID2.id, stateID3.id)
        Assert.assertEquals("/common-files/", stateID3.path)
        Assert.assertEquals("/", stateID3.file)
        Assert.assertNull(stateID3.fileName)
        Assert.assertNull(stateID3.parentFile)

        val stateID4 = stateID.withPath("/common-files/folder")
        Assert.assertEquals("/common-files/folder", stateID4.path)
        Assert.assertEquals("/folder", stateID4.file)
        Assert.assertEquals("folder", stateID4.fileName)
        Assert.assertEquals("/", stateID4.parentFile)
    }

    @Test
    fun testChild() {
        val stateID = StateID("user", "https://example.com", "/default")
        val child = stateID.child("folder")

        Assert.assertEquals("/default/folder", child.path)
        Assert.assertEquals("/folder", child.file)
        Assert.assertEquals("folder", child.fileName)

        val child2 = child.child("")
        Assert.assertEquals("/default/folder", child2.path)
        Assert.assertEquals("/folder", child2.file)
        Assert.assertEquals("folder", child2.fileName)
    }

    @Test
    fun testIDWithSpaceInPath() {
        val slug = "common-files"
        val parPath = "/Sample Documents to test.../Broken Names"
        val name = "Ô my $$… & ¼ !! @ https:breaking.com yeßßß #3.jpg"
        val breakingPath = "/$slug$parPath/$name"
        val stateID = StateID("doe@example.com", "http://example.com:6767", breakingPath)
        val encodedID = stateID.id

        val decodedStateID = StateID.fromId(encodedID)

        Assert.assertEquals("doe@example.com", decodedStateID!!.username)
        Assert.assertEquals("http://example.com:6767", decodedStateID.serverUrl)
        Assert.assertEquals(breakingPath, decodedStateID.path)
        Assert.assertEquals(slug, decodedStateID.slug)
        Assert.assertEquals("$parPath/$name", decodedStateID.file)

        Assert.assertEquals(stateID.username, decodedStateID.username)
        Assert.assertEquals(stateID.serverUrl, decodedStateID.serverUrl)
        Assert.assertEquals(stateID.file, decodedStateID.file)
    }

    @Test
    fun testIDWithIncomplete() {
        val encoder: CustomEncoder = KotlinCustomEncoder()

        val url = "http://example.com:6767"
        var stateID = StateID.fromId(encoder.utf8Encode(url))

        Assert.assertNull(stateID!!.username)
        Assert.assertNull(stateID.path)
        Assert.assertEquals(url, stateID.serverUrl)

        val userName = "john@example.com"
        stateID = StateID.fromId(encoder.utf8Encode(userName) + "@" + encoder.utf8Encode(url))

        Assert.assertEquals(userName, stateID!!.username)
        Assert.assertNull(stateID.path)
        Assert.assertEquals(url, stateID.serverUrl)

        stateID = StateID.fromId(null)
        Assert.assertNull(stateID)
        stateID = StateID.fromId("")
        Assert.assertNull(stateID)
    }
}
