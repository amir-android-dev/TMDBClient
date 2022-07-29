package com.amir.tmdbclient.data.repository.artist

import com.amir.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response
//2
interface ArtistRemoteDataSource {

    suspend fun getArtists():Response<ArtistList>
}