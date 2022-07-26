package com.amir.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.amir.tmdbclient.data.model.artist.Artist
import com.amir.tmdbclient.data.model.movie.Movie
import com.amir.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase :RoomDatabase(){
   // we need to define abstract functions to get dao interfaces.
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}