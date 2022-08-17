package com.example.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private lateinit var myTextView: TextView
    private lateinit var myViewModelClass: MyViewModelClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myViewModelClass = ViewModelProvider(this).get(MyViewModelClass::class.java)
        setText()
    }

    fun setText() {
        myTextView = findViewById(R.id.myTextView)
        myTextView.text = myViewModelClass.counter.toString()
    }

    fun increaseTheValue(view: View) {
        myViewModelClass.increment()
        setText()
    }

}