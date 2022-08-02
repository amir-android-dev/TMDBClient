package com.amir.tmdbclient.presentation.di.core

import com.amir.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.amir.tmdbclient.presentation.di.movie.MovieSubComponent
import com.amir.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton
/*
We will add factory methods here once we have created subcomponents.
@Singleton is the only scope annotation that comes with the javax.inject package.
We can use it to annotate ApplicationComponent and the objects we want to reuse across the whole application
 */
//9-13 defining fuctions to get subcomponents
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
    fun tvShowsubComponent():TvShowSubComponent.Factory

}

/*
In our application we have three view models. MovieViewModel, TvShowViewModel and ArtistViewModel.
 As an example let’s say, If we use Singleton annotation for MovieViewModel instance, Or in other words movie view model dependency.
The instance of MovieViewModel would persist in memory even after the flow has finished.
If we don’t want that. If we want to limit the scope of the MovieViewModel to the lifecycle of the MovieActivity
we need to create a new sub component and a new scope for the movie data flow.
So, In this project we will create different subcomponents and scope for each of Movie,TvShow and Artist data flows.
Let’s create three packages for movie, tv show and artist.
 */