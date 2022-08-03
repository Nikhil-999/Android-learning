package com.example.fragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmentapp.Fragments.FirstFragment
import com.example.fragmentapp.Fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myView_pager = findViewById<ViewPager2>(R.id.demoViewPager)
        val myStrings = myfun()
        val customAdapter = adapterForViewPager(myStrings)
        myView_pager.adapter = customAdapter

    }

    fun firstButtonClicked(view: View) {
        val demo = FirstFragment()
        val mytransaction = supportFragmentManager.beginTransaction()
        mytransaction.replace(R.id.fragmentContainer , demo)
        mytransaction.commit()
    }
    fun secondButtonCLicked(view: View) {
        val demo = SecondFragment()
        val mytransaction = supportFragmentManager.beginTransaction()
        mytransaction.replace(R.id.fragmentContainer , demo)
        mytransaction.commit()
    }

    private fun myfun() : ArrayList<String>{
        val demoList = ArrayList<String>()
        for(i in 1 until 6){
            demoList.add("My Item number $i")
        }
        return demoList
    }
}