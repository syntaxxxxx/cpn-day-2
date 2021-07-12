package com.hightech.inventoryapp.utils

import android.content.Context
import com.hightech.data.InventoryItemRepositoryImpl
import com.hightech.data.local.InventoryRoomDatabase
import com.hightech.domain.InventoryItemRepository
import com.hightech.domain.usecase.InventoryItemInteractor
import com.hightech.domain.usecase.InventoryItemUseCase

//object Injection {
//
//    fun provideRepository(context: Context) : InventoryItemRepository {
//        val database = InventoryRoomDatabase.getDatabase(context)
//        return InventoryItemRepositoryImpl(database.InventoryItemDao())
//    }
//
//    fun provideInteractor(context: Context) : InventoryItemInteractor {
//        val repository = provideRepository(context)
//        return InventoryItemUseCase(repository)
//    }
//
//}