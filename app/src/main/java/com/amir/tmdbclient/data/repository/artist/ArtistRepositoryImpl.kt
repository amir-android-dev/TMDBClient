package com.amir.tmdbclient.data.repository.artist

import android.util.Log
import com.amir.tmdbclient.data.model.artist.Artist
import com.amir.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.amir.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.amir.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.amir.tmdbclient.domain.repository.ArtistRepository

//1-8
class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {


    override suspend fun getArtists(): List<Artist>? {
     return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
      val newListOfArtists=getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsFromCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response =artistRemoteDataSource.getArtists()
            val body = response.body()
            //If the response body is available, we can write codes to get the list of movies using the movies property of it.
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsFromCache(artistList)
        }
        return artistList


    }
}

