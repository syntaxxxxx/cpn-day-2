package com.hightech.inventoryapp

import android.app.Application
import com.hightech.inventoryapp.data.InventoryRepositoryImpl
import com.hightech.inventoryapp.data.local.InventoryRoomDatabase

class InventoryApplication : Application() {
    val database: InventoryRoomDatabase by lazy { InventoryRoomDatabase.getDatabase(this) }
    val repository: InventoryRepositoryImpl by lazy { InventoryRepositoryImpl.getInstance(database.inventoryDao()) }
}