package com.amir.tmdbclient.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val TvShows: List<TvShow>

)