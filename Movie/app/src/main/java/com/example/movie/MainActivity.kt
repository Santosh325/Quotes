package com.example.movie

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MoviesClickListener {
   private lateinit var mAdapter: MovieListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager = GridLayoutManager(this,2)
        fetchData()
        mAdapter = MovieListAdapter(this)
        recyclerview.adapter = mAdapter
    }

    private fun fetchData() {
        var url = "https://api.themoviedb.org/3/movie/popular?api_key=90a8869cb160877f8ed32254dbbbdc0b"


        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener {
             val moviesJsonArray = it.getJSONArray("results")
                val moviesArray = ArrayList<Movies>()
                for(i in 0 until moviesJsonArray.length()) {
                    val moviesJsonObject = moviesJsonArray.getJSONObject(i)
                    val movies = Movies(
                        moviesJsonObject.getString("title"),
                        moviesJsonObject.getString("overview"),
                        moviesJsonObject.getString("poster_path"),
                        moviesJsonObject.getString("release_date"),
                        moviesJsonObject.getDouble("vote_average"),
                        moviesJsonObject.getInt("vote_count")
                        )
                    moviesArray.add(movies)
                }
                mAdapter.updateMovies(moviesArray)
            },
            Response.ErrorListener {

            }
        )

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

    override fun onItemClicked(item: Movies) {
       var intent = Intent(this,movieActivity::class.java)
        intent.putExtra("title",item.title)
        intent.putExtra("image",item.poster_path)
        intent.putExtra("overview",item.overview)
        intent.putExtra("releaseDate",item.release_date)
        intent.putExtra("voteAverage",item.vote_average)
        intent.putExtra("voteCount",item.vote_count)
        startActivity(intent)
    }


}