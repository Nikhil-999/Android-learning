package com.example.volleyandsharingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var myImage: ImageView
    private val url = "https://meme-api.herokuapp.com/gimme"
    private var responseURL = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myImage = findViewById(R.id.myImage)
        loadmeme()
        setImage()
    }

    private fun setImage() {
        Glide.with(this)
            .load(responseURL)
            .into(myImage)
    }

    private fun loadmeme(){

        val myQueue = Volley.newRequestQueue(applicationContext)
        // Request a string response from the provided URL.
        val jsonRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                Log.e("suc" , "this is it:-> ${response.getString("url") }")
                responseURL = response.getString("url")
            },
            { error ->
                Log.e("err" , "this is error: ${error.localizedMessage}")
            }
        )
        myQueue.add(jsonRequest)
    }

    fun myNextFun(view: View) {
        loadmeme()
    }

    fun myShareFun(view: View) {

    }

}