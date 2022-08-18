package com.example.mylivedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModelClass: MyViewModelClass
    private lateinit var myTextView: TextView
    private lateinit var mybtn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mybtn1 = findViewById(R.id.btnClickMe)
        myTextView = findViewById<Button>(R.id.myTextView)

        myViewModelClass = ViewModelProvider(this).get(MyViewModelClass::class.java)

        //below observer is constantly monitoring the MutableLiveData, as the string inside it updates by any action, then the observer it alerted and do the action.
        myViewModelClass.myLiveData.observe(this) {
            myTextView.text = it
        }

        mybtn1.setOnClickListener {
            myViewModelClass.updateLiveData()

            // myViewModelClass.myLiveData.value = "2 seconds have passed"
        }
    }
}