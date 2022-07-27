package com.amir.tmdbclient.domain.usecase

import com.amir.tmdbclient.data.model.movie.Movie
import com.amir.tmdbclient.domain.repository.MovieRepository

/*we need write the function which returns the a list of movies instances
  but we cannot do it without getting support from  a repository
 */
//through instance of movieRepository we will have access to Repository functions
class GetMoviesUseCases(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>?= movieRepository.getMovies()
}