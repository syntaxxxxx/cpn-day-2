package com.hightech.domain.usecase

import androidx.lifecycle.LiveData
import com.hightech.domain.InventoryItemRepository
import com.hightech.entity.InventoryItem
import javax.inject.Inject

class InventoryItemUseCase @Inject constructor(private val repository: InventoryItemRepository) : InventoryItemInteractor {

//    companion object {
//        @Volatile
//        private var INSTANCE: InventoryItemUseCase? = null
//
//        fun getInstance(repository: InventoryItemRepository): InventoryItemUseCase = INSTANCE ?: synchronized(this) {
//            INSTANCE ?: InventoryItemUseCase(repository)
//        }
//    }

    override fun getItems(): LiveData<List<InventoryItem>> = repository.getItems()
    override suspend fun insert(item: InventoryItem) = repository.insert(item)
    override fun getItemBy(id: Int): LiveData<InventoryItem> = repository.getItemBy(id)
    override suspend fun delete(item: InventoryItem) = repository.delete(item)
    override suspend fun update(item: InventoryItem) = repository.update(item)

}