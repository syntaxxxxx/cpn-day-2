package com.hightech.inventoryapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hightech.InventoryItemapp.databinding.FragmentFirstBinding

class ListItemFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val inventoryViewModel: InventoryViewModel by activityViewModels()

    private val listItemAdapter : ListItemAdapter by lazy {
        ListItemAdapter(
            onItemClicked = {
                Log.d("Adapter", it.itemName)
                findNavController().navigate(
                    ListItemFragmentDirections.actionListItemFragmentToListDetailsFragment(it.id)
                )
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = listItemAdapter
        }

        inventoryViewModel.allItems.observe(viewLifecycleOwner, { allItems ->
            Log.d("Hai", "$allItems")
            allItems.let {
                listItemAdapter.submitList(it)
            }
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ListItemFragmentDirections.actionListItemFragmentToAddItemFragment(0))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}