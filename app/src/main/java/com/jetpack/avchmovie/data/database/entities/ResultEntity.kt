package com.jetpack.avchmovie.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jetpack.avchmovie.common.Constants

@Entity(tableName = "movies_list")
data class ResultEntity(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String?,
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "origin_country")
    val originCountry: List<String>?,
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?,
    @ColumnInfo(name = "original_name")
    val originalName: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "popularity")
    val popularity: Double?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,
    @ColumnInfo(name = "vote_count")
    val voteCount: Int?,
    @ColumnInfo(name = Constants.PAGE)
    val page: Int?,
)
