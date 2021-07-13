package com.hightech.inventoryapp.presentation.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hightech.InventoryItemapp.databinding.FragmentListDetailsBinding
import com.hightech.entity.InventoryItem
import com.hightech.entity.getFormattedPrice
import com.hightech.inventoryapp.presentation.InventoryViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ListDetailsFragment : Fragment() {

    private var _binding: FragmentListDetailsBinding? = null
    private val binding get() = _binding!!

    private val safeArgs: ListDetailsFragmentArgs by navArgs()
    lateinit var item: InventoryItem

    private val inventoryViewModel: InventoryViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = safeArgs.id
        Log.d("ListDetailsFragment", "$id")

        inventoryViewModel.getItemBy(id).observe(viewLifecycleOwner, { selectedItem ->
            item = selectedItem
            bind(item)
        })
    }

    private fun bind(item : InventoryItem) {
        binding.apply {
            itemName.text = item.itemName
            itemPrice.text = item.getFormattedPrice()
            itemCount.text = item.quantityInStock.toString()
            sellItem.setOnClickListener { inventoryViewModel.sellItem(item) }
            deleteItem.setOnClickListener { showConfirmationDialog() }
            editItem.setOnClickListener { editItem() }
        }
    }

    private fun showConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(android.R.string.dialog_alert_title)
            .setMessage("Are you sure want to delete?")
            .setCancelable(false)
            .setNegativeButton("NO") { _, _ -> }
            .setPositiveButton("YES") { _, _ ->
                inventoryViewModel.delete(item)
                findNavController().navigateUp()
            }.show()
    }

    private fun editItem() {
        findNavController().navigate(
            ListDetailsFragmentDirections.actionListDetailsFragmentToAddItemFragment(item.id)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}