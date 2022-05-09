package com.jetpack.avchmovie.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jetpack.avchmovie.data.database.entities.MovieResultEntity
import com.jetpack.avchmovie.data.database.entities.ResultEntity

@Database(
    entities = [MovieResultEntity::class, ResultEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDatabaseDao
}
