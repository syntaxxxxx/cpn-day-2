package com.hightech.inventoryapp.presentation

import android.content.Context
import com.hightech.entity.InventoryItem
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hightech.domain.usecase.InventoryInteractor
import com.hightech.inventoryapp.utils.Injection
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

class InventoryViewModelFactory constructor(private val interactor: InventoryInteractor) : ViewModelProvider.Factory {

    companion object {
        @Volatile
        private var INSTANCE: InventoryViewModelFactory? = null

        fun getInstance(context: Context): InventoryViewModelFactory = INSTANCE ?: synchronized(this) {
            INSTANCE ?: InventoryViewModelFactory(Injection.provideInteractor(context))
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(interactor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}