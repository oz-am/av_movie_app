package com.jetpack.avchmovie.utils

import com.jetpack.avchmovie.data.database.entities.MovieResultEntity
import com.jetpack.avchmovie.data.database.entities.ResultEntity
import com.jetpack.avchmovie.data.model.MovieResult
import com.jetpack.avchmovie.data.model.Result

object ObjectMapper {

    fun toResultEntities(result: List<Result>, page: Int): List<ResultEntity> {
        val resultEntities = mutableListOf<ResultEntity>()
        result.forEach { resultItem -> resultEntities.add(toResultEntity(resultItem, page)) }
        return resultEntities
    }

    fun fromResultEntities(entities: List<ResultEntity>): List<Result> {
        val result = mutableListOf<Result>()
        entities.forEach { resultItem -> result.add(fromResultEntity(resultItem)) }
        return result
    }

    fun toResultEntity(result: Result, page: Int): ResultEntity {
        return ResultEntity(
            backdropPath = result.backdropPath,
            firstAirDate = result.firstAirDate,
            genreIds = result.genreIds,
            id = result.id,
            name = result.name,
            originCountry = result.originCountry,
            originalLanguage = result.originalLanguage,
            originalName = result.originalName,
            overview = result.overview,
            popularity = result.popularity,
            posterPath = result.posterPath,
            voteAverage = result.voteAverage,
            voteCount = result.voteCount,
            page = page
        )
    }

    fun fromResultEntity(entity: ResultEntity): Result {
        return Result(
            backdropPath = entity.backdropPath,
            firstAirDate = entity.firstAirDate,
            genreIds = entity.genreIds,
            id = entity.id,
            name = entity.name,
            originCountry = entity.originCountry,
            originalLanguage = entity.originalLanguage,
            originalName = entity.originalName,
            overview = entity.overview,
            popularity = entity.popularity,
            posterPath = entity.posterPath,
            voteAverage = entity.voteAverage,
            voteCount = entity.voteCount
        )
    }

    fun toMoviesResultEntity(result: MovieResult): MovieResultEntity {
        return MovieResultEntity(
            page = result.page,
            totalPages = result.totalPages,
            totalResults = result.totalResults,
        )
    }

    fun fromMoviesResultEntity(entity: MovieResultEntity): MovieResult {
        return MovieResult(
            page = entity.page,
            results = emptyList(),
            totalPages = entity.totalPages,
            totalResults = entity.totalResults,
        )
    }
}
