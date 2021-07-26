package com.hightech.data.di

import androidx.room.Room
import com.hightech.data.local.InventoryRoomDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        get<InventoryRoomDatabase>().inventoryDao()
    }
    single {
        Room.databaseBuilder(androidContext(), InventoryRoomDatabase::class.java, "item_database").build()
    }
}