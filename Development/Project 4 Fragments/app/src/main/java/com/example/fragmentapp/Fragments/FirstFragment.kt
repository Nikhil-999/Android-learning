package com.example.fragmentapp.Fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmentapp.AdapterForViewPager
import com.example.fragmentapp.R



class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val myViewpager = view.findViewById<ViewPager2>(R.id.demoViewPager)
        val myStrings = myfun()
        val customAdapter = AdapterForViewPager(myStrings)
        myViewpager.adapter = customAdapter
        myViewpager.setBackgroundColor(Color.CYAN)
    }


    private fun myfun() : ArrayList<String>{
        val demoList = ArrayList<String>()
        for(i in 1 until 6){
            demoList.add("My Item number $i")
        }
        return demoList
    }
}