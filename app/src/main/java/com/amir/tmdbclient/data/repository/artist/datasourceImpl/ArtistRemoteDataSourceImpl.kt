package com.amir.tmdbclient.data.repository.artist.datasourceImpl

import com.amir.tmdbclient.data.api.TMDBService
import com.amir.tmdbclient.data.model.artist.ArtistList
import com.amir.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response
//5
class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}