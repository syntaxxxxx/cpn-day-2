package com.hightech.domain.usecase

import androidx.lifecycle.LiveData
import com.hightech.entity.InventoryItem

interface InventoryItemInteractor {
    fun getItems() : LiveData<List<InventoryItem>>
    suspend fun insert(item: InventoryItem)
    fun getItemBy(id: Int): LiveData<InventoryItem>
    suspend fun delete(item: InventoryItem)
    suspend fun update(item: InventoryItem)
    suspend fun sell(item: InventoryItem)
}