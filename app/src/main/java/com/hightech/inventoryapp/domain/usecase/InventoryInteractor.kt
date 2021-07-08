package com.hightech.inventoryapp.domain.usecase

import androidx.lifecycle.LiveData
import com.hightech.inventoryapp.data.local.Item

interface InventoryInteractor {
    fun getItems() : LiveData<List<Item>>
    fun insert(item: Item)
}