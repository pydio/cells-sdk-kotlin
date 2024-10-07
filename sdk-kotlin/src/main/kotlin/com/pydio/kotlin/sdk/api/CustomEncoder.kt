package com.pydio.kotlin.sdk.api

interface CustomEncoder {
    fun base64Encode(inValue: ByteArray): ByteArray
    fun base64Encode(inValue: String): String
    fun base64Decode(inValue: ByteArray): ByteArray
    fun base64Decode(inValue: String): String
    fun utf8Encode(value: String): String
    fun utf8Decode(value: String): String
    fun getUTF8Bytes(str: String): ByteArray
}
