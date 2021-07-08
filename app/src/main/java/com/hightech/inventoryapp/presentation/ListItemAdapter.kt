package com.hightech.inventoryapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hightech.inventoryapp.data.local.Item
import com.hightech.inventoryapp.data.local.getFormattedPrice
import com.hightech.inventoryapp.databinding.ListItemBinding

class ListItemAdapter(private val onItemClicked: (Item) -> Unit): ListAdapter<Item, ListItemAdapter.ListItemViewHolder>(DiffCallback) {

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

        fun bind(item: Item) {
            binding.apply {
                itemName.text = item.itemName
                itemPrice.text = item.getFormattedPrice()
                itemQuantity.text = item.quantityInStock.toString()
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }

}