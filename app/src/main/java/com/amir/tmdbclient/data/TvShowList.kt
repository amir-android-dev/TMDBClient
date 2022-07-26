package com.amir.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val TvShows: List<TvShow>

)