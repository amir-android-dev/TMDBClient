package com.amir.tmdbclient.data.repository.tvshow

import com.amir.tmdbclient.data.model.tvshow.TvShow

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList

    }

    override suspend fun saveTvShowsFromCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}