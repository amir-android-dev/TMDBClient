package com.amir.tmdbclient.presentation.di.core

import android.content.Context
import com.amir.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.amir.tmdbclient.presentation.di.movie.MovieSubComponent
import com.amir.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//8-12(the defined component inside of module are 12)
// will create the app module which provides the application context dependency
@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {

        return context.applicationContext
    }

}