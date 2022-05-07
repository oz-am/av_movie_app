package com.jetpack.avchmovie.di

import android.content.Context
import androidx.room.Room
import com.jetpack.avchmovie.common.ConnectionDetector
import com.jetpack.avchmovie.common.Constants
import com.jetpack.avchmovie.data.database.MovieDatabase
import com.jetpack.avchmovie.data.database.MovieDatabaseDao
import com.jetpack.avchmovie.data.remote.MovieDbApi
import com.jetpack.avchmovie.data.repository.implement.MovieRepositoryImpl
import com.jetpack.avchmovie.data.repository.protocole.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // provide retrofit clinet
    @Singleton
    @Provides
    fun provideMovieDbApi(): MovieDbApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDbApi::class.java)
    }

    // provide connectivity manager
    @Singleton
    @Provides
    fun providesConnectivityManager(@ApplicationContext context: Context) = ConnectionDetector(context)

    // provide room database instance clinet
    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase = Room.databaseBuilder(
        context,
        MovieDatabase::class.java,
        "movie_db"
    ).fallbackToDestructiveMigration()
        .build()

    // provide dao
    @Singleton
    @Provides
    fun providesMoviesDao(movieDatabase: MovieDatabase): MovieDatabaseDao = movieDatabase.movieDao()

    // provide movie repository
    @Singleton
    @Provides
    fun providesMovieRepository(movieDatabaseDao: MovieDatabaseDao, movieDbApi: MovieDbApi): MovieRepository = MovieRepositoryImpl(movieDbApi, movieDatabaseDao)

}
