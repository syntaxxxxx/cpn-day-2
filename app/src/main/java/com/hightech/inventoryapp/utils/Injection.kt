package com.hightech.inventoryapp.utils

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