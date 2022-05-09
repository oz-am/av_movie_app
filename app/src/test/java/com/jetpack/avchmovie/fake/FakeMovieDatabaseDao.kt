package com.jetpack.avchmovie.fake

import com.jetpack.avchmovie.data.database.MovieDatabaseDao
import com.jetpack.avchmovie.data.database.entities.MovieResultEntity
import com.jetpack.avchmovie.data.database.entities.ResultEntity

class FakeMovieDatabaseDao : MovieDatabaseDao {

    override suspend fun getMovies(): MovieResultEntity {
        return MovieResultEntity(1, 10, 10)
    }

    override suspend fun saveMovieResult(movieResult: MovieResultEntity) {
        return
    }

    override suspend fun getResultsByPage(page: Int): List<ResultEntity> {
        return listOf(
            ResultEntity(
                1,
                "backdropPath",
                "firstAirDate",
                listOf(1, 2),
                "name",
                listOf("a", "b"),
                "originalLanguage",
                "originalName",
                "overview",
                4.5,
                "posterPath",
                4.5,
                100,
                1
            )
        )
    }

    override suspend fun saveResults(results: List<ResultEntity>) {
        return
    }
}
