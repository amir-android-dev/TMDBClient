package com.amir.tmdbclient.presentation.di.core

import com.amir.tmdbclient.data.api.TMDBService
import com.amir.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.amir.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.amir.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.amir.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.amir.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.amir.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
//3
/*In our project datasources are dependencies for repositories.
Therefore now, I am going to create modules to provide data sources.
We have 3 types of data sources. Remote, local and cache.
 */
@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieDataSource(tmdbService: TMDBService): MovieRemoteDataSource {

        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }
    @Singleton
    @Provides
    fun provideArtistDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {

        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }
    @Singleton
    @Provides
    fun provideTvShowDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {

        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }


}