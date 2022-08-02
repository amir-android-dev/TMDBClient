package com.amir.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.amir.tmdbclient.data.db.ArtistDao
import com.amir.tmdbclient.data.db.MovieDao
import com.amir.tmdbclient.data.db.TMDBDatabase
import com.amir.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
//2
//we will create a module for database and dao dependencies.
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbClient").build()
    }

    /*In this project we have three DAO interfaces. Local data souce classes need them as dependencies*/
    //we create 3 provider functions
    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }
    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvDao()

    }



}