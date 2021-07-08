package com.hightech.inventoryapp.presentation.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hightech.inventoryapp.R
import com.hightech.inventoryapp.data.local.Item
import com.hightech.inventoryapp.databinding.FragmentFirstBinding
import com.hightech.inventoryapp.databinding.FragmentListDetailsBinding

class ListDetailsFragment : Fragment() {

    private var _binding: FragmentListDetailsBinding? = null
    private val binding get() = _binding!!

    private val safeArgs : ListDetailsFragmentArgs by navArgs()
    lateinit var item: Item

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}