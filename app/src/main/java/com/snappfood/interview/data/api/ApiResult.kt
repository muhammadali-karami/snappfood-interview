package com.snappfood.interview.data.api

sealed class ApiResult<out T> {
    data object Empty : ApiResult<Nothing>()
    data object Loading : ApiResult<Nothing>()
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val message: String, val cause: Throwable? = null) : ApiResult<Nothing>()
}