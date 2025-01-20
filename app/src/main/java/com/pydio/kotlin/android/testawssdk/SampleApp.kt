package com.pydio.kotlin.android.testawssdk

import android.app.Application

private val logTag = "MainActivity"

class SampleApp : Application() {

    companion object {
        lateinit var instance: SampleApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
