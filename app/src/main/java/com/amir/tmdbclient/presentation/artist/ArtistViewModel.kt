package com.amir.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.amir.tmdbclient.domain.usecase.GetArtistsUseCases
import com.amir.tmdbclient.domain.usecase.UpdateArtistsUseCases

class ArtistViewModel(private val getArtistsUseCases: GetArtistsUseCases,private val updateArtistsUseCases: UpdateArtistsUseCases):ViewModel() {


    fun getArtists()= liveData {
        val artistList=getArtistsUseCases.execute()
        emit(artistList)
    }

    fun updateArtists()= liveData {
        val artistsList=updateArtistsUseCases.execute()
        emit(artistsList)
    }

}