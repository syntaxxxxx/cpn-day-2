package com.hightech.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.hightech.data.local.InventoryDao
import com.hightech.domain.InventoryRepository
import com.hightech.entity.InventoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InventoryRepositoryImpl constructor(private val dao: InventoryDao) :
    InventoryRepository {

    override fun getItems(): LiveData<List<InventoryItem>> = dao.getItems()
    override suspend fun insert(item: InventoryItem) {
        withContext(Dispatchers.IO) {
            Log.d("Dispatchers.IO", Thread.currentThread().name)
            dao.insert(item)
        }
    }
    override fun getItemBy(id: Int): LiveData<InventoryItem> = dao.getItemBy(id)
    override suspend fun delete(item: InventoryItem) = dao.delete(item)
    override suspend fun update(item: InventoryItem) = dao.update(item)

}