package com.dan.androidarchitercturewitharrowframework.store.domain.model

/**
 * Data model for a case of network error
 */
data class NetWorkError(
    val error: ApiError,
    val t: Throwable? = null
)

enum class ApiError(val message: String) {
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown error")
}