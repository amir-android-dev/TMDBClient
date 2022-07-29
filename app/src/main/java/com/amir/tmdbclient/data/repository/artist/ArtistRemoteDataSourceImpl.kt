package com.amir.tmdbclient.data.repository.artist

import com.amir.tmdbclient.data.api.TMDBService
import com.amir.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response
//5
class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}