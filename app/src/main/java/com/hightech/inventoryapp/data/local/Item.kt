package com.hightech.inventoryapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.NumberFormat

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "item_name")
    val itemName: String,
    @ColumnInfo(name = "item_price")
    val itemPrice: Double,
    @ColumnInfo(name = "quantity_in_stock")
    val quantityInStock: Int,
)

fun Item.getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(itemPrice)