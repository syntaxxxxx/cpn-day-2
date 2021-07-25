package com.hightech.inventoryapp

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.hightech.data.InventoryRepositoryImpl
import com.hightech.data.local.InventoryRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RefreshDataWorker(
    appContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {

        val database = InventoryRoomDatabase.getDatabase(applicationContext)
        val repository = InventoryRepositoryImpl(database.inventoryDao())

            return try {
                val test = repository.getItems()
                Log.d("Worker", "$test")
                Log.d("Worker", "WorkManager: Work request for sync is run")
                Result.success()
            } catch (t: Exception) {
                Log.d("Worker", "$t")
                Result.retry()
        }
    }

}