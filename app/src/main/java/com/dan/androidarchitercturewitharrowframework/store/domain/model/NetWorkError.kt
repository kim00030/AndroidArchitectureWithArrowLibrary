package com.dan.androidarchitercturewitharrowframework.store.domain.model

data class NetWorkError(
    val error: ApiError,
    val t: Throwable? = null
)

enum class ApiError(val message: String) {
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown error")
}

sealed class ApiError2 {
    data class NetworkError(val message: String = "Network Error")
    data class UnknownResponse(val message: String = "Unknown Response")
    data class UnknownError(val message: String = "Unknown Error")
}