package com.hightech.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hightech.entity.InventoryItem

@Dao
interface InventoryItemDao {

    @Query("SELECT * from InventoryItem ORDER BY id DESC")
    fun getItems(): LiveData<List<InventoryItem>>

    @Query("SELECT * from InventoryItem WHERE id = :id")
    fun getItemBy(id: Int) : LiveData<InventoryItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: InventoryItem)

    @Update
    suspend fun update(item: InventoryItem)

    @Delete
    suspend fun delete(item: InventoryItem)
}