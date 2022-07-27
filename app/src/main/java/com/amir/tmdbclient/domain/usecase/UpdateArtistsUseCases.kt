package com.amir.tmdbclient.domain.usecase

import com.amir.tmdbclient.data.model.artist.Artist
import com.amir.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistsUseCases(private val artistRepository: ArtistRepository) {


    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}