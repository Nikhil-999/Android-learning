package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.fragments.Chat
import com.example.bottomnavigation.fragments.Favorite
import com.example.bottomnavigation.fragments.Home
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = Home()
        val chatFragment = Chat()
        val favoriteFragment = Favorite()

        makeCurrentfragment(homeFragment)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> makeCurrentfragment(homeFragment)
                R.id.chat -> makeCurrentfragment(chatFragment)
                R.id.favorite -> makeCurrentfragment(favoriteFragment)
            }
            true
        }
    }

    private fun makeCurrentfragment(currentFragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.myFrameLayout , currentFragment)
            commit()
        }
    }


}