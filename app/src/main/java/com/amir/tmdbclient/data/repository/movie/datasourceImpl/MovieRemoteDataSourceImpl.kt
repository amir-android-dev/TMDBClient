package com.amir.tmdbclient.data.repository.movie.datasourceImpl

import com.amir.tmdbclient.data.api.TMDBService
import com.amir.tmdbclient.data.model.movie.MovieList
import com.amir.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

//5
class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}