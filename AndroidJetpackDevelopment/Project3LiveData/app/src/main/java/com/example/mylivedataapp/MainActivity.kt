package com.example.mylivedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var myViewModelClass: MyViewModelClass
    lateinit var myTextView: TextView
    lateinit var mybtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mybtn = findViewById<Button>(R.id.btnClickMe)
        myTextView = findViewById<Button>(R.id.myTextView)

        myViewModelClass = ViewModelProvider(this).get(MyViewModelClass::class.java)

        //below observer is constantly monitoring the MutableLiveData, as the string inside it updates by any action, then the observer it alerted and do the action.
        myViewModelClass.myLiveData.observe(this , Observer {
            myTextView.text = it
        })

        mybtn.setOnClickListener {
            myViewModelClass.updateLiveData()

            // myViewModelClass.myLiveData.value = "2 seconds have passed"
        }
    }
}