package com.amir.tmdbclient.data.repository.movie

import com.amir.tmdbclient.data.model.movie.Movie
import com.amir.tmdbclient.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1, "overview1", "posterPath1", "data1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "data2", "title2"))
        movies.add(Movie(3, "overview3", "posterPath3", "data3", "title3"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(4, "overview4", "posterPath4", "data4", "title4"))
        movies.add(Movie(5, "overview5", "posterPath5", "data5", "title5"))
        return movies
    }
}