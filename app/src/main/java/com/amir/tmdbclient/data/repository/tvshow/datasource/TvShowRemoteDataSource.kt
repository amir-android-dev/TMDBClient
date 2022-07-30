package com.amir.tmdbclient.data.repository.tvshow.datasource

import com.amir.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

//2
interface TvShowRemoteDataSource {
    suspend fun getTvShows():Response<TvShowList>
}