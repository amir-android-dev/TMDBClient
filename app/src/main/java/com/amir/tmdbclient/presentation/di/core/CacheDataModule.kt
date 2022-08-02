package com.amir.tmdbclient.presentation.di.core

import com.amir.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.amir.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.amir.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.amir.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.amir.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.amir.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


//5
@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}