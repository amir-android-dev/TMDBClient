package com.amir.tmdbclient.data.repository.movie.datasource

import com.amir.tmdbclient.data.model.movie.Movie
//4
interface MovieCacheDataSource {

    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesFromCache(movies:List<Movie>)


}
//// We create a Data source class to implement the created interfaces.