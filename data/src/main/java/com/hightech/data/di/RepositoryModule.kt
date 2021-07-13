package com.hightech.data.di

import com.hightech.data.InventoryItemRepositoryImpl
import com.hightech.domain.InventoryItemRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<InventoryItemRepository> { InventoryItemRepositoryImpl(get()) }
}