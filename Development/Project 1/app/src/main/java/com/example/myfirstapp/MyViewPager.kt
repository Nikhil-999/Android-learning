package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2

class MyViewPager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_pager)

        val myView_pager = findViewById<ViewPager2>(R.id.demoViewPager)
        val myStrings = myfun()
        val customAdapter = ViewPagerAdapter(myStrings)
        myView_pager.adapter = customAdapter

    }

    private fun myfun() : ArrayList<String>{
        val demoList = ArrayList<String>()
        for(i in 1 until 6){
            demoList.add("My Item number $i")
        }
        return demoList
    }
}