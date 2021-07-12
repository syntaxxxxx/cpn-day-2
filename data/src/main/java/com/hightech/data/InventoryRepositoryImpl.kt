package com.hightech.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.hightech.data.local.InventoryItemDao
import com.hightech.domain.InventoryItemRepository
import com.hightech.entity.InventoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InventoryItemRepositoryImpl @Inject constructor(private val dao: InventoryItemDao) : InventoryItemRepository {

//    companion object {
//        @Volatile
//        private var INSTANCE: InventoryItemRepositoryImpl? = null
//
//        fun getInstance(dao: InventoryItemDao): InventoryItemRepositoryImpl = INSTANCE ?: synchronized(this) {
//            INSTANCE ?: InventoryItemRepositoryImpl(dao)
//        }
//    }

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