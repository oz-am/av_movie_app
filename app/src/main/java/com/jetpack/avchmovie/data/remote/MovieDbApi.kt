package com.jetpack.avchmovie.data.remote

import com.jetpack.avchmovie.common.Constants
import com.jetpack.avchmovie.data.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbApi {

    @GET(Constants.GET_MOVIES)
    suspend fun getMovies(
        @Query(Constants.API_KEY) apiKey: String,
        @Query(Constants.LANGUAGE) language: String,
        @Query(Constants.PAGE) page: Int,
        @Query(Constants.QUERY) query: String,
        @Query(Constants.INCLUDE_ADULT) includeAdult: Boolean
    ): MovieResult
}
