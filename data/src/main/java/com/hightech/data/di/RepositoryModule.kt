//package com.hightech.data.di
//
//import com.hightech.data.InventoryRepositoryImpl
//import com.hightech.domain.InventoryRepository
//import org.koin.dsl.module
//
//val repositoryModule = module {
//    single<InventoryRepository> {
//        InventoryRepositoryImpl(get())
//    }
//}