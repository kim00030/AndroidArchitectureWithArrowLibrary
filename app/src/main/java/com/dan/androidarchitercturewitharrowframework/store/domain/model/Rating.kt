package com.dan.androidarchitercturewitharrowframework.store.domain.model

/**
 * a property of Product data model
 * @see Product
 */
data class Rating(
    val count: Int,
    val rate: Double
)