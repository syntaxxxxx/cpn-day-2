package com.hightech.inventoryapp.domain.usecase

import androidx.lifecycle.LiveData
import com.hightech.inventoryapp.data.local.Item
import com.hightech.inventoryapp.domain.InventoryRepository

class InventoryUseCase constructor(private val repo: InventoryRepository) : InventoryInteractor {

    override fun getItems(): LiveData<List<Item>> {
        return repo.getItems()
    }

    override fun insert(item: Item) {
        repo.insert(item)
    }

}