package com.amir.tmdbclient.data.repository.tvshow.datasourceImpl

import com.amir.tmdbclient.data.api.TMDBService
import com.amir.tmdbclient.data.model.tvshow.TvShowList
import com.amir.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

//5
class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String):
    TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {

        return tmdbService.getPopularTvShows(apiKey)
    }
}