package com.hightech.inventoryapp.presentation.di

import com.hightech.inventoryapp.presentation.InventoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { InventoryViewModel(get()) }
}