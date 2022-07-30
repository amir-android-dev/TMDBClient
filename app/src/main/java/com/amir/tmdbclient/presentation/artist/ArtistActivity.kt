package com.amir.tmdbclient.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amir.tmdbclient.R
import com.amir.tmdbclient.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
  binding = DataBindingUtil.setContentView(this,R.layout.activity_artist)
    }
}