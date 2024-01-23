package com.dan.androidarchitercturewitharrowframework.store.data.remote

import com.dan.androidarchitercturewitharrowframework.store.domain.model.Product
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}