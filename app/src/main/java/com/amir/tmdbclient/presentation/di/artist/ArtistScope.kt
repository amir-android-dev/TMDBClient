package com.amir.tmdbclient.presentation.di.artist

import javax.inject.Scope
//2
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ArtistScope {

    //this class don't need a class body.
    /*
    This class don’t need a class body. Now we can use this newly creted ArtistScope as the scope of ArtistViewModelFactory dependency.
     */
}