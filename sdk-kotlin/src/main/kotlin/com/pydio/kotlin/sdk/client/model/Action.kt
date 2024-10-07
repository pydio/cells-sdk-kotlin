package com.pydio.kotlin.sdk.client.model

class Action(
    val name: String,
    val dirDefault: Boolean,
    val fileDefault: Boolean,
    val write: Boolean,
    val read: Boolean,
    val adminOnly: Boolean,
    val userLogged: Boolean,
    val noUser: Boolean
)
