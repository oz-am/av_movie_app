package com.jetpack.avchmovie.data.repository.protocole

import com.jetpack.avchmovie.common.Resource
import com.jetpack.avchmovie.data.model.MovieResult
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(page: Int): Flow<Resource<MovieResult>>
}
