package com.example.apicallswithvolley

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()
    }

    fun loadMeme(){
        val myQueue = Volley.newRequestQueue(this)
        val myUrl = "https://meme-api.herokuapp.com/gimme"

        val myString = JsonObjectRequest(Request.Method.GET , myUrl ,null , {
            response -> val demo = response.getString("url")
            val myImage = findViewById<ImageView>(R.id.myImage)
            Glide.with(this)
                .load(demo)
                .into(myImage);
        },
            { Log.d("Error occured is " , "There is an error") })
        myQueue.add(myString)
    }

    fun nextImage(view: View) {
        loadMeme()
    }

}