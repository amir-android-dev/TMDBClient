package com.amir.tmdbclient.presentation.di.artist

import com.amir.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

/*
This sub component has only one module. ArtistModule Then annotate this with artist scope annotation.
We will use this subcomponent to inject dependencies to artist activity.
 Therefore we need to define an inject function here keeping an instance of artist activity as a parameter.
 */
//3
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {


    fun inject(artistActivity: ArtistActivity)
    /*We must define a subcomponent factory inside this ArtistComponent so that AppComponent knows
   how to create instances of this ArtistComponent sub component.
    */
    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}