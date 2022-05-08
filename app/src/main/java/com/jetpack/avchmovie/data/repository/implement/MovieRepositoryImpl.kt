package com.jetpack.avchmovie.data.repository.implement

import com.jetpack.avchmovie.common.ConnectionDetector
import com.jetpack.avchmovie.common.Resource
import com.jetpack.avchmovie.data.database.MovieDatabaseDao
import com.jetpack.avchmovie.data.model.MovieResult
import com.jetpack.avchmovie.data.remote.MovieDbApi
import com.jetpack.avchmovie.data.repository.protocole.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieDbApi: MovieDbApi, private val movieDatabaseDao: MovieDatabaseDao, private val connectivity: ConnectionDetector) : MovieRepository {
    override fun getMovies(page: Int): Flow<Resource<MovieResult>> = flow {
        try {
            emit(Resource.Loading<MovieResult>())
            val data: MovieResult?
            if (connectivity.isConnected()) {
                data = movieDbApi.getMovies("", "", 1, "", false)
                movieDatabaseDao.save(data)
            } else {
                data = movieDatabaseDao.getMovies()
            }
            emit(Resource.Success<MovieResult>(data))
        } catch (e: HttpException) {
            emit(Resource.Error<MovieResult>(e.localizedMessage ?: "An unexpecte error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<MovieResult>("Couldn't reach the server"))
        }
    }
}
