package com.example.fragmentapp

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmentapp.Fragments.FirstFragment
import com.example.fragmentapp.Fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnFrameOne).setOnClickListener {
            myfun(FirstFragment(),  0 , 0)
        }

        findViewById<Button>(R.id.btnFrameTwo).setOnClickListener {
            myfun(SecondFragment() , 1 , 1)
        }

    }

    private fun myfun(fragment : Fragment , myflag : Int , a : Int ){
        val myManager = supportFragmentManager
        val mytransaction = myManager.beginTransaction()

//        if(myflag == 0)
//            mytransaction.add(R.id.fragmentContainer , fragment)
//        else
        if(myflag == 0){
            supportFragmentManager.findFragmentById(a+1)?.let { mytransaction.detach(it) }
        }
            mytransaction.replace(R.id.fragmentContainer , fragment , )

        mytransaction.addToBackStack(null)
        supportFragmentManager.popBackStack(0,1)
        mytransaction.commit()
    }


}