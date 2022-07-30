package com.amir.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amir.tmdbclient.domain.usecase.GetMoviesUseCases
import com.amir.tmdbclient.domain.usecase.UpdateMoviesUseCase
//This view model class has constructor parameters.
// Therefore, we need to create a view model factory for this view model.
class MovieViewModel(
    private val getMoviesUseCases: GetMoviesUseCases,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    //This function will invoke execute function of the getMoviesUseCase and emit received list as live data.
    // since we are using coroutine we use liveData
    //we are not explicitly provide any dispatcher. So coroutine will use the main Thread
    //Since we have used IO thread in the data sources, calling them from the UI thread is the best practice.
    fun getMovies() = liveData {
        val movieList = getMoviesUseCases.execute()
        emit(movieList)
    }

    /* we will clear all the data in the movie table of the database,Download new data from the tmdb api and save them to database. We have already implemented those functions in the data layer.
    All we need to do is call to the execute function of the updateMoviesUseCase.
     */
    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }

}