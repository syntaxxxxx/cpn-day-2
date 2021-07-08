package com.hightech.inventoryapp.domain

import androidx.lifecycle.LiveData
import com.hightech.inventoryapp.data.local.Item

interface InventoryRepository {
    fun getItems() : LiveData<List<Item>>
    fun insert(item: Item)
}