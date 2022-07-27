package com.amir.tmdbclient.domain.repository

import com.amir.tmdbclient.data.model.artist.Artist
import com.amir.tmdbclient.data.model.movie.Movie

interface ArtistRepository {


    suspend fun getArtists(): List<Artist>?

    suspend fun updateArtists(): List<Artist>?
}