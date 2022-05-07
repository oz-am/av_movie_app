package com.jetpack.avchmovie.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jetpack.avchmovie.data.model.MovieResult

@Database(
    entities = [MovieResult::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDatabaseDao
}