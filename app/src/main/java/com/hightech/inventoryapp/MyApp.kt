package com.hightech.inventoryapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup() {

    }
}