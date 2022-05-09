package com.jetpack.avchmovie.fake

import com.jetpack.avchmovie.data.model.MovieResult
import com.jetpack.avchmovie.data.model.Result
import com.jetpack.avchmovie.data.remote.MovieDbApi

class FakeMovieDbApi : MovieDbApi {
    override suspend fun getMovies(
        apiKey: String,
        language: String,
        page: Int,
        query: String,
        includeAdult: Boolean
    ): MovieResult {
        val resultList = listOf(
            Result(
                "backdropPath",
                "firstAirDate",
                listOf(1, 2),
                1,
                "name",
                listOf("a", "b"),
                "originalLanguage",
                "originalName",
                "overview",
                4.5,
                "posterPath",
                4.5,
                100
            )
        )
        return MovieResult(1, resultList, 10, 200)
    }
}
