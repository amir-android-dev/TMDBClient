package com.amir.tmdbclient.presentation.tv
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amir.tmdbclient.domain.usecase.GetTvShowsUseCases
import com.amir.tmdbclient.domain.usecase.UpdateTvShowsUseCases

class TvShowViewModel(
    private val getTvShowsUseCases: GetTvShowsUseCases,
    private val updateTvShowsUseCases: UpdateTvShowsUseCases
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCases.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
       val tvShowList=updateTvShowsUseCases.execute()
        emit(tvShowList)
    }
}