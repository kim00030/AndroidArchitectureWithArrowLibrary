package com.dan.androidarchitercturewitharrowframework.store.data.remote

import com.dan.androidarchitercturewitharrowframework.store.domain.model.Product
import retrofit2.http.GET

/**
 * End point of api: https://fakestoreapi.com/products
 * Base url is defined in Constants.kt
 */
interface ProductApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}