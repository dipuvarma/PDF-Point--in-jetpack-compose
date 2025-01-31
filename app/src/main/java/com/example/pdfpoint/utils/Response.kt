package com.example.pdfpoint.utils

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error<T>(val exception: Throwable) : Response<T>()
    object Loading : Response<Nothing>()
}