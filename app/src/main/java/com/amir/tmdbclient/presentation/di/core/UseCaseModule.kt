package com.amir.tmdbclient.presentation.di.core

import com.amir.tmdbclient.domain.repository.ArtistRepository
import com.amir.tmdbclient.domain.repository.MovieRepository
import com.amir.tmdbclient.domain.repository.TvShowsRepository
import com.amir.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

//7
@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCase(movieRepository: MovieRepository): GetMoviesUseCases {
        return GetMoviesUseCases(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository): GetArtistsUseCases {
        return GetArtistsUseCases(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCases {
        return UpdateArtistsUseCases(artistRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository): GetTvShowsUseCases {
        return GetTvShowsUseCases(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowsUseCases {
        return UpdateTvShowsUseCases(tvShowsRepository)
    }
}