package com.example.retrofitandcoil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import coil.load

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        nextImage(findViewById(R.id.btnNext))
    }

    fun nextImage(view: View) {
//        below is the code for Coil implementation
        val myImage = findViewById<ImageView>(R.id.myImage)
        val myUrl = "https://images.unsplash.com/photo-1599508704512-2f19efd1e35f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8YW55fGVufDB8fDB8fA%3D%3D&w=1000&q=80"
        myImage.load(myUrl){
            placeholder(R.drawable.ic_launcher_background)
        }

    }
}