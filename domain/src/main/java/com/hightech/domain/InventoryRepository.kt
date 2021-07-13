package com.hightech.domain

import androidx.lifecycle.LiveData
import com.hightech.entity.InventoryItem

interface InventoryRepository {
    fun getItems() : LiveData<List<InventoryItem>>
    suspend fun insert(item: InventoryItem)
    fun getItemBy(id: Int): LiveData<InventoryItem>
    suspend fun delete(item: InventoryItem)
    suspend fun update(item: InventoryItem)
}