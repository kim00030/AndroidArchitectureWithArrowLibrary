package com.dan.androidarchitercturewitharrowframework.store.data.mapper

import com.dan.androidarchitercturewitharrowframework.store.domain.model.ApiError
import com.dan.androidarchitercturewitharrowframework.store.domain.model.NetWorkError
import retrofit2.HttpException
import java.io.IOException

/**
 * Extension of Throwable to convert NetworkError object
 * that Either object expects for failure case (left-side)
 */
fun Throwable.toNetworkError(): NetWorkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }

    return NetWorkError(
        error = error,
        t = this
    )
}