package com.hightech.inventoryapp

import android.app.Application
import android.util.Log
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MyApp : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        applicationScope.launch {
            setup()
        }
    }

    private fun setup() {
        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(16, TimeUnit.MINUTES)
            .build()

        Log.d("MyApp", "WorkManager: Periodic Work request for sync is scheduled")
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "com.hightech.inventoryapp.RefreshDataWorker",
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }
}