package com.example.quotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var authorName:String? = null;
    var content:String? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    fun nextButton(view: View) {
        loadData()
    }
    fun shareButton(view: View) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Check out this Quotes !!  $textviewContent by $textviewAuthor")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Get Motivated Here")
        startActivity(shareIntent)
    }

    fun loadData() {
        val url = "https://api.quotable.io/random"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    authorName = response.getString("author")
                    content = response.getString("content")
                    Log.d("hello", "loadData: $authorName")
                    Log.d("hello","loadData:$content")
                    textviewContent.text = content
                    textviewAuthor.text = authorName
                },
                Response.ErrorListener { error ->
                    // TODO: Handle error
                    Log.d("error","it didn't work")
                }
        )


// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

}