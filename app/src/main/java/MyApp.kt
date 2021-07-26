package com.hightech.inventoryapp

import android.app.Application
import com.hightech.data.di.databaseModule
import com.hightech.data.di.repositoryModule
import com.hightech.domain.di.useCaseModule
import com.hightech.inventoryapp.presentation.di.viewModelModule
import org.koin.core.context.startKoin

class MyApp : Application() {

//    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(listOf(
                databaseModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            ))
        }
//        applicationScope.launch {
//            setup()
//        }
    }
}

//    private fun setup() {
//        val repeatingRequest = PeriodicWorkRequestBuilder<RefreshDataWorker>(16, TimeUnit.MINUTES)
//            .build()
//
//        Log.d("MyApp", "WorkManager: Periodic Work request for sync is scheduled")
//        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
//            "com.hightech.inventoryapp.RefreshDataWorker",
//            ExistingPeriodicWorkPolicy.KEEP,
//            repeatingRequest
//        )
//    }
//}