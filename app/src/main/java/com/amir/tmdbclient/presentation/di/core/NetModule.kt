package com.amir.tmdbclient.presentation.di.core

import com.amir.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
//1
//this is our network module. This module provides two dependencies . Retrofit instance and TMDBService instance.
//To create a retrofit instance we need to provide the base url. so we add the base url as construct parameter
@Module
class NetModule(private val baseUrl: String) {


    // Here we will construct a retrofit instance using its builder function call and retrun it. :Retrofit.Builder */
    // TMDB api send us data in JSON format. To convert JSON to Kotlin we need a converter factory. addConverterFactory GsonConverterFactory.create()
    //It very efficient keeping a single retrofit instance during the entire operational time of the app
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    //a function to provide an instance of TMDB service
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService{
return retrofit.create(TMDBService::class.java)

    }
}