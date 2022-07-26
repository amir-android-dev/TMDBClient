package com.amir.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amir.tmdbclient.data.model.artist.Artist


@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("delete from popular_artist")
    suspend fun deleteAllArtists()

    @Query("select * from popular_artist")
    suspend fun getArtists(artists: List<Artist>)
}