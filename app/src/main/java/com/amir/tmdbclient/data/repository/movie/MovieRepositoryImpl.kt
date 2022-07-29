package com.amir.tmdbclient.data.repository.movie

import android.util.Log
import com.amir.tmdbclient.data.model.movie.Movie
import com.amir.tmdbclient.domain.repository.MovieRepository

//1-8

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    //returns a list of movie instances
    //if the data are in cash will be displayed if not will look at database, if not will be get data again from api
    override suspend fun getMovies(): List<Movie>? {
        return getMovieFromCache()
    }

    //updates the database with latest popular movies
    //1 In order to update movies, we need to get movie data from the web api first.
    //2 then we need to clear the database
    //3 after that to save the new list in database
    //4 save the list also in cache
    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesFromCache(newListOfMovies)
        return newListOfMovies
    }

    /*Before complete this getMovies function,I am going to create functions for getting movies from api,database and cache using those datasources. suspend fun getMoviesFromAPI.*/
    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        /*
        For now, I am just adding a log message for the exceptions.Later, we can use LiveData to handle exceptions after we completed the presentation layer.
         */
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            //If the response body is available, we can write codes to get the list of movies using the movies property of it.
            if (body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMovieFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMovieFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMovieFromDB()
            movieCacheDataSource.saveMoviesFromCache(movieList)
        }
        return movieList


    }
}
