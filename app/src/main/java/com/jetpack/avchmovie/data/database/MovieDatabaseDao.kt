package com.jetpack.avchmovie.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jetpack.avchmovie.data.model.MovieResult

@Dao
interface MovieDatabaseDao {
    @Query("SELECT * FROM MOVIES")
    suspend fun getMovies(): MovieResult

    @Insert
    suspend fun save(movieResult: MovieResult)
}
