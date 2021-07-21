package com.hightech.inventoryapp

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.hightech.data.InventoryRepositoryImpl
import com.hightech.data.local.InventoryRoomDatabase
import com.hightech.domain.InventoryRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class RefreshDataWorker(
    appContext: Context,
    params: WorkerParameters,
) : CoroutineWorker(appContext, params) {

    val database = InventoryRoomDatabase.getDatabase(applicationContext)
    val repository = InventoryRepositoryImpl(database.inventoryDao())

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                repository.getItems()
                Log.d("RefreshDataWorker", "WorkManager: Work request for sync is run")
                Result.success()
            } catch (t: Exception) {
                Log.d("RefreshDataWorker", "$t")
                Result.retry()
            }
        }
    }

}
