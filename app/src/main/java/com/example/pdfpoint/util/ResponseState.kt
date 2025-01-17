package com.example.pdfpoint.util

sealed class ResponseState<out T> {
    data class Success<out T>(val data: T) : ResponseState<T>()
    data class Error<T>(val message: Throwable) : ResponseState<T>()
    object Loading : ResponseState<Nothing>()
}