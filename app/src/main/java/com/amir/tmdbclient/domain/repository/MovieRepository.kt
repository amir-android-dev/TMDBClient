package com.amir.tmdbclient.domain.repository

import com.amir.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    //we need an abstraction function which returns a list of movies

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}