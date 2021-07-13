package com.hightech.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hightech.entity.InventoryItem

@Database(entities = [InventoryItem::class], version = 1, exportSchema = false)
abstract class InventoryRoomDatabase : RoomDatabase() {

    abstract fun inventoryItemDao() : InventoryDao

}