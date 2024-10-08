package com.pydio.kotlin.sdk.utils

import com.pydio.kotlin.sdk.api.CustomEncoder
import net.thauvin.erik.urlencoder.UrlEncoderUtil
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
class SimpleEncoder : CustomEncoder {

    override fun base64Encode(inValue: ByteArray): ByteArray {
        return Base64.UrlSafe.encodeToByteArray(inValue)
    }

    override fun base64Encode(inValue: String): String {
        val asBytes = inValue.toByteArray(Charsets.UTF_8)
        val encoded = base64Encode(asBytes)
        return encoded.toString(Charsets.UTF_8)
    }

    override fun base64Decode(inValue: ByteArray): ByteArray {
        return Base64.UrlSafe.decode(inValue)
    }

    override fun base64Decode(inValue: String): String {
        val asBytes = inValue.toByteArray(Charsets.UTF_8)
        val decoded = base64Decode(asBytes)
        return decoded.toString(Charsets.UTF_8)
    }

    override fun utf8Encode(value: String): String {
        return UrlEncoderUtil.encode(value)
    }

    override fun utf8Decode(value: String): String {
        return UrlEncoderUtil.decode(value)
    }

    override fun getUTF8Bytes(str: String): ByteArray {
        return str.toByteArray(Charsets.UTF_8)
    }
}
