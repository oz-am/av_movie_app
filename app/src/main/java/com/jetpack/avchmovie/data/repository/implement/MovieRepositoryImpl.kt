package com.jetpack.avchmovie.data.repository.implement

import com.jetpack.avchmovie.common.ConnectionDetector
import com.jetpack.avchmovie.common.Resource
import com.jetpack.avchmovie.data.database.MovieDatabaseDao
import com.jetpack.avchmovie.data.model.MovieResult
import com.jetpack.avchmovie.data.remote.MovieDbApi
import com.jetpack.avchmovie.data.repository.protocole.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieDbApi: MovieDbApi, private val movieDatabaseDao: MovieDatabaseDao, private val connectivity: ConnectionDetector) : MovieRepository {
    override fun getMovies(page: Int): Flow<Resource<MovieResult>> {
//        if (connectivity.isConnected()) {
//            return movieDbApi.getMovies("", "", 1, "", false).flowOn(Dispatchers.IO)
//        } else {
//            return movieDatabaseDao.getMovies().flowOn(Dispatchers.IO).conflate()
//        }
    }
}
