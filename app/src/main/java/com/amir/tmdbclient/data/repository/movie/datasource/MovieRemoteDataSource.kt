package com.amir.tmdbclient.data.repository.movie.datasource

import com.amir.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

//2
interface MovieRemoteDataSource {
//This interface need to have a function which returns a list of movies.
//This getPopularMovies function of the service interface returns a response instance of type MovieList.So, this new function should return the same.
    suspend fun getMovies():Response<MovieList>
}