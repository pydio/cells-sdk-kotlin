package com.pydio.kotlin.sdk.transport.auth

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pydio.kotlin.sdk.utils.GsonSingleton
import java.lang.reflect.Type
import java.text.ParseException

class Token {
    // Set by Cells layers to contain the corresponding encoded accountID
    var subject: String? = null

    // value is the real useful token => access_token in OAuth2
    // TODO check model. Should value and token type be nullable here?
    var value: String? = null
    var tokenType: String? = null

    // idToken contains encoded information about current session, typically the claims
    var idToken: String? = null
    var scope: String? = null


    var refreshToken: String? = null
    var expiresIn: Long = 0
    var expirationTime: Long = 0
    var refreshingSinceTs: Long = 0
    val isExpired: Boolean
        get() {
            if (expirationTime == -1L) {
                return false
            }
            if (value.isNullOrEmpty()) {
                return true
            }
            val expSince = currentTimeInSeconds() - expirationTime
            val expired = expSince > 0
//            if (expired) {
//                Log.w(logTag,"Token for $subject is expired since $expSince seconds")
//                Thread.dumpStack()
//            }
            return expired
        }

    fun setExpiry(expiresIn: Long) {
        if (expiresIn == -1L) {
            expirationTime = -1
            this.expiresIn = -1
        } else {
            expirationTime = currentTimeInSeconds() + expiresIn
            this.expiresIn = expiresIn
        }
    }

    private fun currentTimeInSeconds(): Long {
        return System.currentTimeMillis() / 1000
    }

    companion object {
        private const val logTag = "Token"
        fun encode(t: Token?): String {
            val gson = Gson()
            return gson.toJson(t)
        }

        fun decode(json: String?): Token {
            return Gson().fromJson(json, Token::class.java)
        }

        @Throws(ParseException::class)
        fun decodeOAuthJWT(jwt: String?): Token {

            val myType: Type = object : TypeToken<Map<String, Any>>() {}.type
            val jwtMap: Map<String, Any> = Gson().fromJson(jwt, myType)

            // Now create a Token object and populate it manually from the map
            val token = Token().apply {
                value = jwtMap["access_token"] as String
                setExpiry((jwtMap["expires_in"] as Number).toLong()) // Safely cast to Number then convert to Long
                scope = jwtMap["scope"] as String
                idToken = jwtMap["id_token"] as String
                refreshToken = jwtMap["refresh_token"] as String
                tokenType = jwtMap["token_type"] as String
            }
            return token
//            val t = Token()
//            val jo = JSONObject(jwt)
//            t.value = jo.getString("access_token")
//            t.setExpiry(jo.getInt("expires_in").toLong())
//            t.scope = jo.getString("scope")
//            t.idToken = jo.getString("id_token")
//            t.refreshToken = jo.getString("refresh_token")
//            t.tokenType = jo.getString("token_type")
//            return t
        }
    }
}
