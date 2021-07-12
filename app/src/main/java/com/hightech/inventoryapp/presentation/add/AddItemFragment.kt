package com.hightech.inventoryapp.presentation.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hightech.InventoryItemapp.databinding.FragmentAddItemBinding
import com.hightech.entity.InventoryItem
import com.hightech.inventoryapp.presentation.InventoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddItemFragment : Fragment() {

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    private val inventoryViewModel: InventoryViewModel by activityViewModels()
    private val safeArgs: AddItemFragmentArgs by navArgs()
    lateinit var item: InventoryItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = safeArgs.id

        if (id > 0) {
            inventoryViewModel.getItemBy(id).observe(viewLifecycleOwner, { selectedItem ->
                item = selectedItem
                bind(item)
            })
        } else {
            binding.apply {
                saveAction.setOnClickListener {
                        inventoryViewModel.addNewItem(
                            binding.itemName.text.toString(),
                            binding.itemPrice.text.toString(),
                            binding.itemCount.text.toString()
                        )
                    findNavController().navigate(AddItemFragmentDirections.actionAddItemFragmentToListItemFragment())
                }
            }
        }
    }

    private fun bind(item: InventoryItem) {
        binding.apply {
            itemName.setText(item.itemName, TextView.BufferType.SPANNABLE)
            itemPrice.setText(item.itemPrice.toString(), TextView.BufferType.SPANNABLE)
            itemCount.setText(item.quantityInStock.toString(), TextView.BufferType.SPANNABLE)
            saveAction.setOnClickListener { updateItem() }
        }
    }

    private fun updateItem() {
        binding.apply {
            inventoryViewModel.updateItem(
                safeArgs.id,
                itemName.text.toString(),
                itemPrice.text.toString(),
                itemCount.text.toString(),
            )
        }
        findNavController().navigate(AddItemFragmentDirections.actionAddItemFragmentToListItemFragment())
    }
}