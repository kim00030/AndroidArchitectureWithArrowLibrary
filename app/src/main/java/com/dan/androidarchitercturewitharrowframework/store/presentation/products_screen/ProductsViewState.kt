package com.dan.androidarchitercturewitharrowframework.store.presentation.products_screen

import com.dan.androidarchitercturewitharrowframework.store.domain.model.Product

/**
 * State for Products received from server
 * By this state, the View will be on composition
 */
data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
