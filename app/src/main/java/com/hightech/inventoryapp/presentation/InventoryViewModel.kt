package com.hightech.inventoryapp.presentation

import com.hightech.entity.InventoryItem
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hightech.domain.usecase.InventoryInteractor
import kotlinx.coroutines.launch

class InventoryViewModel constructor(private val interactor: InventoryInteractor) :
    ViewModel() {

    val allItems: LiveData<List<InventoryItem>> = interactor.getItems()

    fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
        val newItem = getNewItemEntry(itemName, itemPrice, itemCount)
        insert(newItem)
    }

    private fun getNewItemEntry(
        itemName: String,
        itemPrice: String,
        quantityInStock: String
    ): InventoryItem {
        return InventoryItem(
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = quantityInStock.toInt()
        )
    }

    private fun insert(item: InventoryItem) {
        viewModelScope.launch {
            Log.d("viewModelScope", Thread.currentThread().name)
            interactor.insert(item)
        }
    }

    fun getItemBy(id: Int): LiveData<InventoryItem> = interactor.getItemBy(id)

    fun sell(item: InventoryItem) {
        viewModelScope.launch {
            interactor.sell(item)
        }
    }

    fun updateItem(id: Int, itemName: String, itemPrice: String, itemCount: String) {
        val updateItem = InventoryItem(
            id = id,
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = itemCount.toInt()
        )
        update(updateItem)
    }

    private fun update(item: InventoryItem) {
        viewModelScope.launch {
            interactor.update(item)
        }
    }

    fun delete(item: InventoryItem) {
        viewModelScope.launch {
            interactor.delete(item)
        }
    }

}