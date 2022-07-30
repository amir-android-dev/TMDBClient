package com.amir.tmdbclient.data.repository.artist.datasource

import com.amir.tmdbclient.data.model.artist.Artist
//4
interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsFromCache(artists:List<Artist>)

}