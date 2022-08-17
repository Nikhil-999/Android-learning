package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0
    var myTextView: TextView = findViewById(R.id.myTextView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
    private fun setText() {
        myTextView.text = counter.toString()
    }

    fun increaseTheValue(view: View) {
        counter++
        setText()
    }

}