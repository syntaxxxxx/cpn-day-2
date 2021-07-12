package com.hightech.data.di

import com.hightech.data.InventoryItemRepositoryImpl
import com.hightech.domain.InventoryItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindRepository(repository: InventoryItemRepositoryImpl) : InventoryItemRepository

}