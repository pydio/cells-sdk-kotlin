package com.pydio.kotlin.openapi.kmp.auth

class OAuth : Authentication {
    var accessToken: String? = null

    override fun apply(query: MutableMap<String, List<String>>, headers: MutableMap<String, String>) {
        val token: String = accessToken ?: return
        headers["Authorization"] = "Bearer $token"
    }
}
