package com.amir.tmdbclient.presentation

import android.app.Application
import com.amir.tmdbclient.BuildConfig
import com.amir.tmdbclient.presentation.di.Injector
import com.amir.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.amir.tmdbclient.presentation.di.core.*
import com.amir.tmdbclient.presentation.di.movie.MovieSubComponent
import com.amir.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.android.DaggerActivity
import dagger.android.DaggerApplication
import dagger.android.support.DaggerAppCompatActivity
import java.util.stream.DoubleStream.builder
import java.util.stream.IntStream.builder
import java.util.stream.Stream.builder
import javax.inject.Inject


//15
/*This class should extend the Application class and implement the Injector interface. Generate the three functions of Injector interface.
Then, declare a private reference variable for the AppComponent interface.*/
class App: Application(),Injector {


    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
appComponent=DaggerAppComponent.builder()
    .appModule(AppModule(applicationContext))
    .netModule(NetModule(BuildConfig.BASE_URL))
    .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
    .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
    return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowsubComponent().create()
    }

    override fun artistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

}