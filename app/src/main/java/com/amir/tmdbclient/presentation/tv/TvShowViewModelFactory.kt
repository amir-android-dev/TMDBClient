package com.amir.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amir.tmdbclient.domain.usecase.GetTvShowsUseCases
import com.amir.tmdbclient.domain.usecase.UpdateTvShowsUseCases

class TvShowViewModelFactory(
    private val getTvShowsUseCases: GetTvShowsUseCases,
    private val updateTvShowsUseCases: UpdateTvShowsUseCases
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUseCases, updateTvShowsUseCases) as T
    }
}