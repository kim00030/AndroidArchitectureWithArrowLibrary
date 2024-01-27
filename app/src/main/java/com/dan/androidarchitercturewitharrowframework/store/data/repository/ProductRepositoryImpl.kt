package com.dan.androidarchitercturewitharrowframework.store.data.repository

import arrow.core.Either
import com.dan.androidarchitercturewitharrowframework.store.data.mapper.toNetworkError
import com.dan.androidarchitercturewitharrowframework.store.data.remote.ProductApi
import com.dan.androidarchitercturewitharrowframework.store.domain.model.NetWorkError
import com.dan.androidarchitercturewitharrowframework.store.domain.model.Product
import com.dan.androidarchitercturewitharrowframework.store.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * Implementation of ProductRepository interface
 * @see ProductRepository
 */
class ProductRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): Either<NetWorkError, List<Product>> {
        return Either.catch {
            productApi.getProducts()
        }.mapLeft {
            it.toNetworkError()
        }
    }
}