package com.example.fragmentapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentapp.AdapterForRecycleView
import com.example.fragmentapp.R


class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myRecycleView = view.findViewById<RecyclerView>(R.id.myrec)
        myRecycleView.layoutManager = LinearLayoutManager(this)
        val myArrayList = myfun()
        val customAdapter = AdapterForRecycleView(myArrayList)
        myRecycleView.adapter = customAdapter

    }

    private fun myfun() : ArrayList<String>{
        val demoList = ArrayList<String>()
        for(i in 1 until 100){
            demoList.add("My Item number $i")
        }
        return demoList
    }
}