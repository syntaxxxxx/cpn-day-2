package com.hightech.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hightech.entity.InventoryItem

@Database(entities = [InventoryItem::class], version = 1, exportSchema = false)
abstract class InventoryRoomDatabase : RoomDatabase() {

    abstract fun InventoryItemDao() : InventoryItemDao

    companion object {
//        @Volatile
//        private var INSTANCE : InventoryRoomDatabase? = null
//
//        fun getDatabase(context: Context) : InventoryRoomDatabase {
//
//            /**
//             * If the INSTANCE is not null, then return it
//             * If it is, then create the database
//             * */
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(context, InventoryRoomDatabase::class.java, "item_database").build()
//                INSTANCE = instance
//                instance
//            }
//        }
    }
}