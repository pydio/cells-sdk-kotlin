package com.pydio.kotlin.sdk.utils

import com.google.gson.Gson

// Simply centralize the definition of the Gson service that is used throughout the lib.
object GsonSingleton {
    val instance: Gson by lazy { Gson() }
}
