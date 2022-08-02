package com.amir.tmdbclient.presentation.di.tvshow

import com.amir.tmdbclient.domain.usecase.GetTvShowsUseCases
import com.amir.tmdbclient.domain.usecase.UpdateTvShowsUseCases
import com.amir.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowsUseCases: GetTvShowsUseCases,updateTvShowsUseCases: UpdateTvShowsUseCases):TvShowViewModelFactory{

        return TvShowViewModelFactory(getTvShowsUseCases, updateTvShowsUseCases)
    }
}