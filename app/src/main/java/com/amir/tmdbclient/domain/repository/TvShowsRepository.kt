package com.amir.tmdbclient.domain.repository

import com.amir.tmdbclient.data.model.tvshow.TvShow

interface TvShowsRepository {


    suspend fun getTvShows():List<TvShow>?

    suspend fun updateTvShows():List<TvShow>?
}