package com.amir.tmdbclient.data.repository.artist.datasource

import com.amir.tmdbclient.data.model.artist.Artist
//3
interface ArtistLocalDataSource {


    suspend fun getArtistsFromDB(): List<Artist>

    suspend fun saveArtistsToDB(artists: List<Artist>)

    suspend fun clearAll()

}