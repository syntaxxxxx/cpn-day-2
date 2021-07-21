package com.hightech.inventoryapp.utils

import android.content.Context
import com.hightech.data.InventoryRepositoryImpl
import com.hightech.data.local.InventoryRoomDatabase
import com.hightech.domain.InventoryRepository
import com.hightech.domain.usecase.InventoryInteractor
import com.hightech.domain.usecase.InventoryUseCase

object Injection {

    fun provideRepository(context: Context) : InventoryRepository {
        val database = InventoryRoomDatabase.getDatabase(context)
        return InventoryRepositoryImpl(database.inventoryDao())
    }

    fun provideInteractor(context: Context) : InventoryInteractor {
        val repository = provideRepository(context)
        return InventoryUseCase(repository)
    }

}