package com.amir.tmdbclient.presentation.di.core

import com.amir.tmdbclient.data.db.ArtistDao
import com.amir.tmdbclient.data.db.MovieDao
import com.amir.tmdbclient.data.db.TvShowDao
import com.amir.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.amir.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.amir.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.amir.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.amir.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.amir.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//4
//we will create a module to provide LocalDataSource Implementations.
@Module
class LocalDataModule() {

    /*in this module we are going to construct and return this MovieLocalDataSourceImpl,TvShowLocalDataSourceImpl and ArtistLocalDataSourceImpl instances.
    You can see, they all have their dao interface as a constructor parameter.
    So when we create provider function, we need to add those dao interfaces as function parameters.
    We have already created this database module to provide those dao dependencies.*/
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}