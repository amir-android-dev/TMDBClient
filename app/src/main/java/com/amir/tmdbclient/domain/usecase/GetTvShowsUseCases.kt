package com.amir.tmdbclient.domain.usecase

import com.amir.tmdbclient.data.model.tvshow.TvShow
import com.amir.tmdbclient.domain.repository.TvShowsRepository

class GetTvShowsUseCases(private val tvShowsRepository: TvShowsRepository) {

    suspend fun execute():List<TvShow>?= tvShowsRepository.getTvShows()
}