package com.amir.tmdbclient.data.repository.tvshow.datasource

import com.amir.tmdbclient.data.model.tvshow.TvShow
//4
interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsFromCache(tvShows:List<TvShow>)

}