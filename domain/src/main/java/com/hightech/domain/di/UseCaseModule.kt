package com.hightech.domain.di

import com.hightech.domain.usecase.InventoryItemInteractor
import com.hightech.domain.usecase.InventoryItemUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Singleton
    @Binds
    internal abstract fun bindUseCase(useCase: InventoryItemUseCase) : InventoryItemInteractor

}