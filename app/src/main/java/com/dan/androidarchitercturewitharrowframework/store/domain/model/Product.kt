package com.dan.androidarchitercturewitharrowframework.store.domain.model
//Data model that maps the product information receiving from server
data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)