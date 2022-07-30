package com.amir.tmdbclient.presentation.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amir.tmdbclient.R
import com.amir.tmdbclient.databinding.ActivityHomeBinding
import com.amir.tmdbclient.databinding.ActivityMovieBinding

class TvShowActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
    }
}