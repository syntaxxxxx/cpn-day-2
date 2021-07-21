//package com.hightech.domain.di
//
//import com.hightech.domain.usecase.InventoryInteractor
//import com.hightech.domain.usecase.InventoryUseCase
//import org.koin.dsl.module
//
//val useCaseModule = module {
//    single<InventoryInteractor> {
//        InventoryUseCase(get())
//    }
//}