package com.amir.tmdbclient.data.api

import com.amir.tmdbclient.data.model.artist.ArtistList
import com.amir.tmdbclient.data.model.movie.MovieList
import com.amir.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    //we are going to use coroutines for background processing we need defined suspending function
    //As we discovered earlier, TMDB api send these movie data as an object of MovieList class
    //We should add the api name of the property with the query annotation. Name of the property is api_key
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey: String): Response<ArtistList>

}