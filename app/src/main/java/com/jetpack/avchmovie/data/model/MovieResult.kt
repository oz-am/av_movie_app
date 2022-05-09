package com.jetpack.avchmovie.data.model

import com.google.gson.annotations.SerializedName

data class MovieResult(
    val page: Int,
    var results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
