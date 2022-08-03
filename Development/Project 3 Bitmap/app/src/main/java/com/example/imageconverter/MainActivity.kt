package com.example.imageconverter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun myfun(view: View) {

        val image = findViewById<ImageView>(R.id.myImage)
        val myDrawable = image.drawable as BitmapDrawable
        val mybitmap = myDrawable
        val image2 = findViewById<ImageView>(R.id.myImage2)
        image2.setImageBitmap(mybitmap)
    }
}