package com.amir.tmdbclient.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amir.tmdbclient.R
import com.amir.tmdbclient.data.model.tvshow.TvShow
import com.amir.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowAdapter():RecyclerView.Adapter<MyViewHolder>() {

    private val tvShowList = ArrayList<TvShow>()

    //a setter function To set values to that Array list of movies from the activity
    fun setList(tvShows: List<TvShow>) {
        //we delete all the old list at first
        //then add a new list
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}


class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow) {

        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        //We will not store the moive poster in our local room database.
        // Instead we will get it form the web api using the url.
        val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        //codes to display movie poster using glide library
        Glide.with(binding.imageView.context).load(posterURL).into(binding.imageView)
    }
}