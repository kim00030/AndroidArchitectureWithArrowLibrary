package com.dan.androidarchitercturewitharrowframework.store.domain.repository

import arrow.core.Either
import com.dan.androidarchitercturewitharrowframework.store.domain.model.NetWorkError
import com.dan.androidarchitercturewitharrowframework.store.domain.model.Product

interface ProductRepository {

    //Either<A,B> from Arrow dependency. left(A) is for failure, right(B) for success
    suspend fun getProducts(): Either<NetWorkError, List<Product>>
}