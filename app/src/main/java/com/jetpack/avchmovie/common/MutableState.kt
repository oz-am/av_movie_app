package com.jetpack.avchmovie.common

data class MutableState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String? = null
)
