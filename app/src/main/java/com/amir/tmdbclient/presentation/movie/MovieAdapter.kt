package com.amir.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amir.tmdbclient.R
import com.amir.tmdbclient.data.model.movie.Movie
import com.amir.tmdbclient.data.model.movie.MovieList
import com.amir.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val movieList = ArrayList<Movie>()

    //a setter function To set values to that Array list of movies from the activity
    fun setList(movies: List<Movie>) {
        //we delete all the old list at first
        //then add a new list
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}


class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {

        binding.titleTextView.text = movie.title
        binding.descriptionTextView.text = movie.overview
        //We will not store the moive poster in our local room database.
        // Instead we will get it form the web api using the url.
        val posterURL = "https://image.tmdb.org/t/p/w500" + movie.posterPath
        //codes to display movie poster using glide library
        Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
    }
}