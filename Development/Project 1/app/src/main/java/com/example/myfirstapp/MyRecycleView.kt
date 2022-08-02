package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyRecycleView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_recycle_view)

        val myDropDown : Spinner = findViewById(R.id.mySpinner)
        val adapter = ArrayAdapter.createFromResource(this , R.array.courses , android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        myDropDown.adapter = adapter



        val myRecycleView = findViewById<RecyclerView>(R.id.myrec)
        myRecycleView.layoutManager = LinearLayoutManager(this)
        val myArrayList = myfun()
        val customAdapter = MyAdapter(myArrayList)
        myRecycleView.adapter = customAdapter

    }

    private fun myfun() : ArrayList<String>{
        val demoList = ArrayList<String>()
        for(i in 1 until 100){
            demoList.add("My Item number $i")
        }
        return demoList
    }

    fun NextActivityCalled(view: View) {
        val myIntent = Intent(this , MyViewPager::class.java)
        startActivity(myIntent)
    }

}