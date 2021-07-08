package com.hightech.inventoryapp.data

import androidx.lifecycle.LiveData
import com.hightech.inventoryapp.data.local.InventoryDao
import com.hightech.inventoryapp.data.local.Item
import com.hightech.inventoryapp.domain.InventoryRepository

class InventoryRepositoryImpl constructor(private val dao: InventoryDao) : InventoryRepository {

    companion object {
        @Volatile
        private var INSTANCE: InventoryRepositoryImpl? = null

        fun getInstance(dao: InventoryDao): InventoryRepositoryImpl = INSTANCE ?: synchronized(this) {
            INSTANCE ?: InventoryRepositoryImpl(dao)
        }
    }

    override fun getItems() : LiveData<List<Item>> = dao.getItems()
    override fun insert(item: Item) = dao.insert(item)

}