package com.hightech.inventoryapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hightech.inventoryapp.data.InventoryRepositoryImpl
import com.hightech.inventoryapp.data.local.Item
import com.hightech.inventoryapp.domain.usecase.InventoryInteractor
import com.hightech.inventoryapp.utils.BACKGROUND

class InventoryViewModel constructor(private val interactor: InventoryInteractor) :
    ViewModel() {

    val allItems: LiveData<List<Item>> = interactor.getItems()

    fun addNewItem(itemName: String, itemPrice: String, itemCount: String) {
        val newItem = getNewItemEntry(itemName, itemPrice, itemCount)
        insert(newItem)
    }

    private fun getNewItemEntry(
        itemName: String,
        itemPrice: String,
        quantityInStock: String
    ): Item {
        return Item(
            itemName = itemName,
            itemPrice = itemPrice.toDouble(),
            quantityInStock = quantityInStock.toInt()
        )
    }

    fun insert(item: Item) {
        BACKGROUND.submit {
            interactor.insert(item)
        }
    }

}

class InventoryViewModelFactory(private val interactor: InventoryInteractor) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return InventoryViewModel(interactor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}