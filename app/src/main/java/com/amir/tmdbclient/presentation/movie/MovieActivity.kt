package com.amir.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amir.tmdbclient.R
import com.amir.tmdbclient.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    lateinit var binding:ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
    }
}