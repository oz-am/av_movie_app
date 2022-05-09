package com.jetpack.avchmovie.data.repository.implement

import com.google.common.truth.Truth
import com.jetpack.avchmovie.fake.FakeConnectionDetector
import com.jetpack.avchmovie.fake.FakeMovieDatabaseDao
import com.jetpack.avchmovie.fake.FakeMovieDbApi
import org.junit.Before
import org.junit.Test

class MovieRepositoryImplTest {

    private lateinit var movieRepository: MovieRepositoryImpl

    @Before
    fun setUp() {
        movieRepository = MovieRepositoryImpl(
            FakeMovieDbApi(), FakeMovieDatabaseDao(), FakeConnectionDetector()
        )
    }

    @Test
    fun getMovies() {
        val result = movieRepository.getMovies(1)
        Truth.assertThat(result).isNotNull()
    }
}
