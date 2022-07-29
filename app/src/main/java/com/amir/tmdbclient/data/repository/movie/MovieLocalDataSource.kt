package com.amir.tmdbclient.data.repository.movie

import com.amir.tmdbclient.data.model.movie.Movie
//3
interface MovieLocalDataSource {

    // We need to get a list of movie instances from the database.
    suspend fun getMoviesFromDB(): List<Movie>

    //We need to save a list of movie instances to the data base
    suspend fun saveMoviesToDB(movies: List<Movie>)
// we need to clear the data in the database table.
    suspend fun clearAll()

}