package com.amir.tmdbclient.domain.usecase

import com.amir.tmdbclient.data.model.movie.Movie
import com.amir.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {


    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}