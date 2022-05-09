package com.jetpack.avchmovie.data.repository.implement

import com.jetpack.avchmovie.common.IConnectionDetector
import com.jetpack.avchmovie.common.Resource
import com.jetpack.avchmovie.data.database.MovieDatabaseDao
import com.jetpack.avchmovie.data.model.MovieResult
import com.jetpack.avchmovie.data.remote.MovieDbApi
import com.jetpack.avchmovie.data.repository.protocole.MovieRepository
import com.jetpack.avchmovie.utils.ObjectMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieDbApi: MovieDbApi, private val movieDatabaseDao: MovieDatabaseDao, private val connectivity: IConnectionDetector) : MovieRepository {
    override fun getMovies(page: Int): Flow<Resource<MovieResult>> = flow {
        try {
            emit(Resource.Loading<MovieResult>())
            val data: MovieResult?
            if (connectivity.isConnected()) {
                data = movieDbApi.getMovies("8d6a13d4ff986513574e73180f498ed9", "en-US", 1, "comedy", false)
                movieDatabaseDao.saveMovieResult(ObjectMapper.toMoviesResultEntity(data))
                movieDatabaseDao.saveResults(ObjectMapper.toResultEntities(data.results, data.page))
            } else {
                data = ObjectMapper.fromMoviesResultEntity(movieDatabaseDao.getMovies())
                data.results = ObjectMapper.fromResultEntities(movieDatabaseDao.getResultsByPage(data.page))
            }
            emit(Resource.Success<MovieResult>(data))
        } catch (e: HttpException) {
            emit(Resource.Error<MovieResult>(e.localizedMessage ?: "An unexpecte error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<MovieResult>("Couldn't reach the server"))
        }
    }
}
