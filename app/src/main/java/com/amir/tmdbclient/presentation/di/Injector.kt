package com.amir.tmdbclient.presentation.di

import com.amir.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.amir.tmdbclient.presentation.di.movie.MovieSubComponent
import com.amir.tmdbclient.presentation.di.tvshow.TvShowSubComponent

//14
/*Since we have subcomponents, We need to create funcitons in side that application class to get subcomponent
instances. Following best coding practices let’s create an injector interface with abstract declarations
of those functions.*/
interface Injector {

fun createMovieSubComponent():MovieSubComponent
fun createTvShowSubComponent():TvShowSubComponent
fun artistSubComponent():ArtistSubComponent
}