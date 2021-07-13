package com.hightech.domain.di

import com.hightech.domain.usecase.InventoryItemInteractor
import com.hightech.domain.usecase.InventoryItemUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<InventoryItemInteractor> { InventoryItemUseCase(get()) }
}