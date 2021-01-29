package com.example.movie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie.*

class movieActivity : AppCompatActivity() {
    var initial = "https://image.tmdb.org/t/p/w500"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        var getTitle = intent.getStringExtra("title")
        var getImage = intent.getStringExtra("image")
        var getVotecount = intent.getIntExtra("voteCount",40)
        var getVoteRating = intent.getDoubleExtra("voteAverage",5.5)
        var getReleaseDate = intent.getStringExtra("releaseDate")
        var getOverView = intent.getStringExtra("overview")
        movieTitle.text = getTitle
        voteCount.text = getVotecount.toString()
        rating.text = getVoteRating.toString()
        releaseDate.text = getReleaseDate
        overview.text = getOverView
        Glide.with(this).load(initial + getImage).into(movieImage)
    }
}