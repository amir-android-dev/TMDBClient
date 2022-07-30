package com.amir.tmdbclient.presentation.artist
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amir.tmdbclient.domain.usecase.GetArtistsUseCases
import com.amir.tmdbclient.domain.usecase.UpdateArtistsUseCases

class ArtistViewModelFactory(
    private val getArtistsUseCases: GetArtistsUseCases,
    private val updateArtistsUseCases: UpdateArtistsUseCases
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCases, updateArtistsUseCases) as T
    }
}