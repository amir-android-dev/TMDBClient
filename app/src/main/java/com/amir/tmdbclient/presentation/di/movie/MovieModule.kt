package com.amir.tmdbclient.presentation.di.movie

import com.amir.tmdbclient.domain.usecase.GetMoviesUseCases
import com.amir.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.amir.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModleFactory(
        getMoviesUseCases: GetMoviesUseCases,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {

        return MovieViewModelFactory(getMoviesUseCases, updateMoviesUseCase)
    }
}