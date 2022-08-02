package com.amir.tmdbclient.presentation.di.artist

import com.amir.tmdbclient.domain.usecase.GetArtistsUseCases
import com.amir.tmdbclient.domain.usecase.UpdateArtistsUseCases
import com.amir.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
//1
@Module
class ArtistModule {
    /*
    ArtistViewModelFactory has two constructor parameters.
GetArtistsUseCase and UpdateArtistsUseCase. So we need to add them as parameters for this provider function.
     */
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(getArtistsUseCase: GetArtistsUseCases, updateArtistsUseCase: UpdateArtistsUseCases): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}