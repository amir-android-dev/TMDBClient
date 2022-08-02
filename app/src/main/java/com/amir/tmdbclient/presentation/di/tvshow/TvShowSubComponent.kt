package com.amir.tmdbclient.presentation.di.tvshow

import com.amir.tmdbclient.presentation.artist.ArtistActivity
import com.amir.tmdbclient.presentation.di.artist.ArtistModule
import com.amir.tmdbclient.presentation.di.artist.ArtistScope
import com.amir.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.amir.tmdbclient.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }


}