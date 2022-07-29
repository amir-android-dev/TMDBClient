package com.amir.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amir.tmdbclient.data.model.tvshow.TvShow


@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShows: List<TvShow>)

    @Query("delete from popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("select * from popular_tvShows")
    suspend fun getTvShows(): List<TvShow>

}