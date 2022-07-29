package com.amir.tmdbclient.data.repository.tvshow

import com.amir.tmdbclient.data.db.TvShowDao
import com.amir.tmdbclient.data.model.tvshow.TvShow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//6
class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao):TvShowLocalDataSource{

    override suspend fun getTvShowsFromDB(): List<TvShow> {
      return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShow: List<TvShow>) {
   CoroutineScope(Dispatchers.IO).launch {
       tvShowDao.saveTvShow(tvShow)
   }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}