package com.hightech.inventoryapp.presentation.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.hightech.inventoryapp.InventoryApplication
import com.hightech.inventoryapp.R
import com.hightech.inventoryapp.databinding.FragmentAddItemBinding
import com.hightech.inventoryapp.presentation.InventoryViewModel
import com.hightech.inventoryapp.presentation.InventoryViewModelFactory

class AddItemFragment : Fragment() {

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    private val inventoryViewModel: InventoryViewModel by activityViewModels {
        InventoryViewModelFactory((activity?.application as InventoryApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            saveAction.setOnClickListener {
                inventoryViewModel.addNewItem(
                    binding.itemName.text.toString(),
                    binding.itemPrice.text.toString(),
                    binding.itemCount.text.toString()
                )
//                findNavController().navigate(R.id.action_addItemFragment_to_listItemFragment)
            }
        }
    }
}