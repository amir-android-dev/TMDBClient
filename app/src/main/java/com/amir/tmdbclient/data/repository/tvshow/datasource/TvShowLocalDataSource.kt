package com.amir.tmdbclient.data.repository.tvshow.datasource

import com.amir.tmdbclient.data.model.tvshow.TvShow

//3
interface TvShowLocalDataSource {


    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShow: List<TvShow>)
    suspend fun clearAll()

}