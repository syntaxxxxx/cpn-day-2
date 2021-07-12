package com.hightech.data.di

import android.content.Context
import androidx.room.Room
import com.hightech.data.local.InventoryItemDao
import com.hightech.data.local.InventoryRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    internal fun provideDatabase(@ApplicationContext context: Context) : InventoryRoomDatabase {
        return Room.databaseBuilder(context, InventoryRoomDatabase::class.java, "item_database").build()
    }

    @Provides
    @Singleton
    internal fun provideDao(database: InventoryRoomDatabase): InventoryItemDao {
        return database.InventoryItemDao()
    }
}