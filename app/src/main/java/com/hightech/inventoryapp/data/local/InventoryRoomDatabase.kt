package com.hightech.inventoryapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryRoomDatabase : RoomDatabase() {

    abstract fun inventoryDao() : InventoryDao

    companion object {
        @Volatile
        private var INSTANCE : InventoryRoomDatabase? = null

        fun getDatabase(context: Context) : InventoryRoomDatabase {

            /**
             * If the INSTANCE is not null, then return it
             * If it is, then create the database
             * */
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, InventoryRoomDatabase::class.java, "item_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}