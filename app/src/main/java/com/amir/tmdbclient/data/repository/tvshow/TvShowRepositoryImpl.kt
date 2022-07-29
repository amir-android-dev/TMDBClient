package com.amir.tmdbclient.data.repository.tvshow

import android.util.Log
import com.amir.tmdbclient.data.model.tvshow.TvShow
import com.amir.tmdbclient.domain.repository.TvShowsRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepository {
    override suspend fun getTvShows(): List<TvShow>? {
     return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
       val newListOfTvShows=getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsFromCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response =tvShowRemoteDataSource.getTvShows()
            val body = response.body()

            if (body != null) {
                tvShowList = body.TvShows
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowsFromCache(tvShowList)
        }
        return tvShowList


    }
}