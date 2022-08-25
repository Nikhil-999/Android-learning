package com.example.fragmentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterForViewPager(private val mylist : ArrayList<String>) : RecyclerView.Adapter<ViewPagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val demoView = LayoutInflater.from(parent.context).inflate(R.layout.itemforviewpager , parent , false)
        return ViewPagerViewHolder(demoView)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentString = mylist[position]
        holder.item.text = currentString
    }

    override fun getItemCount(): Int {
        return mylist.size
    }
}

class ViewPagerViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
    val item: TextView = itemview.findViewById(R.id.textforviewpager)
}