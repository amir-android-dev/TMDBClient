package com.amir.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amir.tmdbclient.domain.usecase.GetMoviesUseCases
import com.amir.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(private val getMoviesUseCases: GetMoviesUseCases,private val updateMoviesUseCase: UpdateMoviesUseCase):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCases,updateMoviesUseCase) as T
    }
}