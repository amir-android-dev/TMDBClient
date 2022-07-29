package com.amir.tmdbclient.data.repository.movie

import com.amir.tmdbclient.data.db.MovieDao
import com.amir.tmdbclient.data.model.movie.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
//6
//To work with local data base we need an instance of  MovieDao interface. as a constructor parameter
class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {


    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }
/*
When we are getting data from the room database, room execute that query in a back ground thread.
So we don’t need to explicitly write codes for background processing. But, we need to invoke other dao functions from a background thread
 */
    override suspend fun saveMoviesToDB(movies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch {
          movieDao.saveMovies(movies)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}