package com.hightech.inventoryapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hightech.InventoryItemapp.databinding.ListItemBinding
import com.hightech.entity.InventoryItem
import com.hightech.entity.getFormattedPrice

class ListItemAdapter(private val onItemClicked: (InventoryItem) -> Unit): ListAdapter<InventoryItem, ListItemAdapter.ListItemViewHolder>(
    DiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val currentPosition = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(currentPosition)
        }
        holder.bind(currentPosition)
    }

    class ListItemViewHolder(private var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: InventoryItem) {
            binding.apply {
                itemName.text = item.itemName
                itemPrice.text = item.getFormattedPrice()
                itemQuantity.text = item.quantityInStock.toString()
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<InventoryItem>() {
            override fun areItemsTheSame(oldItem: InventoryItem, newItem: InventoryItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: InventoryItem, newItem: InventoryItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}