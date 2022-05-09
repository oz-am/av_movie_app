package com.jetpack.avchmovie.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jetpack.avchmovie.data.database.entities.MovieResultEntity
import com.jetpack.avchmovie.data.database.entities.ResultEntity

@Dao
interface MovieDatabaseDao {
    @Query("SELECT * FROM MOVIES")
    suspend fun getMovies(): MovieResultEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieResult(movieResult: MovieResultEntity)

    @Query("SELECT * FROM MOVIES_LIST WHERE PAGE =:page ")
    suspend fun getResultsByPage(page: Int): List<ResultEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveResults(results: List<ResultEntity>)
}
