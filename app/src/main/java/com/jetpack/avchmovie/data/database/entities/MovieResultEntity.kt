package com.jetpack.avchmovie.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jetpack.avchmovie.common.Constants

@Entity(tableName = "movies")
data class MovieResultEntity(
    @PrimaryKey(autoGenerate = false)
    val page: Int,
    @ColumnInfo(name = Constants.TOTAL_PAGES)
    val totalPages: Int,
    @ColumnInfo(name = Constants.TOTAL_RESULTS)
    val totalResults: Int
)
