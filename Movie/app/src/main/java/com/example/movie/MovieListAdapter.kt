package com.example.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieListAdapter(private val listener: MoviesClickListener): RecyclerView.Adapter<MoviesViewHOlder>() {
    var initial = "https://image.tmdb.org/t/p/w500"
    private val items: ArrayList<Movies> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHOlder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        val viewHOlder = MoviesViewHOlder(view)
        view.setOnClickListener {
          listener.onItemClicked(items[viewHOlder.adapterPosition])

        }
        return viewHOlder
    }



    override fun onBindViewHolder(holder: MoviesViewHOlder, position: Int) {
        val currentPosition = items[position]
        Glide.with(holder.imageView.context).load(initial + currentPosition.poster_path).into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateMovies(moviesArray: ArrayList<Movies>) {
       items.clear()
        items.addAll(moviesArray)
        notifyDataSetChanged()
    }
}

class MoviesViewHOlder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView = itemView.findViewById(R.id.moviePoster)
}

interface MoviesClickListener {
    fun onItemClicked(Item: Movies)
}
