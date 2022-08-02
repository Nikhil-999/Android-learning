package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// MyAdapter is getting data with constructor making        and         Adapter is getting our own made ViewHolder

class MyAdapter(private val items: ArrayList<String>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Below layoutInflater is used to bind the XML to a single view.
        val demo = LayoutInflater.from(parent.context).inflate(R.layout.item_for_recycleview , parent , false)
        return MyViewHolder(demo)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.myItem.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val myItem: TextView = itemView.findViewById<TextView>(R.id.myTitle)
}