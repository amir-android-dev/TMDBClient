package com.amir.tmdbclient.data.repository.artist

import com.amir.tmdbclient.data.db.ArtistDao
import com.amir.tmdbclient.data.model.artist.Artist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//6
class ArtistLocalDataSourceImpl(private val artistDao:ArtistDao):ArtistLocalDataSource {

    override suspend fun getArtistsFromDB(): List<Artist> {
    return  artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
    CoroutineScope(Dispatchers.IO).launch {
        artistDao.saveArtists(artists)
    }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}