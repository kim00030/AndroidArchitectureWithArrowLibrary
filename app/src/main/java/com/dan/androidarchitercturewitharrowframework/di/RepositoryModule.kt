package com.dan.androidarchitercturewitharrowframework.di

import com.dan.androidarchitercturewitharrowframework.store.data.repository.ProductRepositoryImpl
import com.dan.androidarchitercturewitharrowframework.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository

}