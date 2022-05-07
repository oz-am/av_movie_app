package com.jetpack.avchmovie.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.jetpack.avchmovie.common.Constants
import java.util.*

@Entity(tableName = "movies")
data class MovieResult(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = Constants.PAGE)
    val page: Int,
    @ColumnInfo(name = Constants.RESULTS)
    val results: List<Result>,
    @ColumnInfo(name = Constants.TOTAL_PAGES)
    @SerializedName("total_pages")
    val totalPages: Int,
    @ColumnInfo(name = Constants.TOTAL_RESULTS)
    @SerializedName("total_results")
    val totalResults: Int
)
