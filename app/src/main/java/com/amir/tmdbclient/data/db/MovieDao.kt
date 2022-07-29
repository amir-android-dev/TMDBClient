package com.amir.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amir.tmdbclient.data.model.movie.Movie

@Dao
interface MovieDao {
    /*
    In our project we have 3 database operations.
    We need to save a list of movie instances taken from the TMDBapi to the database. When the user clicks on update icon,
    we need to delete all the data from the data base table first and then save new movie instances to the database.
     */
    //setting OnConflictStrategy as REPLACE. So, room will replace the old data and continue the transaction.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("delete from popular_movies")
    suspend fun deleteAllMovies()

    @Query("select * from popular_movies")
    suspend fun getMovies() :List<Movie>
}