package com.hightech.inventoryapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InventoryDao {

    @Query("SELECT * from item ORDER BY item_name ASC")
    fun getItems(): LiveData<List<Item>>

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int) : LiveData<Item>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Item)

}