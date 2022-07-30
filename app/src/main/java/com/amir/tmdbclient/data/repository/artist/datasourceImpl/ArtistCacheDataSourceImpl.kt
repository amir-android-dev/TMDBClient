package com.amir.tmdbclient.data.repository.artist.datasourceImpl

import com.amir.tmdbclient.data.model.artist.Artist
import com.amir.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

//7
class ArtistCacheDataSourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsFromCache(artists: List<Artist>) {
        artistList.clear()
        artistList=ArrayList(artists)
    }
}