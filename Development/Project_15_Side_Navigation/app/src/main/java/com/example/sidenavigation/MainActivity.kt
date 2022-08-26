package com.example.sidenavigation

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var myDrawerLayout: DrawerLayout
    private lateinit var abc: MaterialToolbar
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDrawerLayout = findViewById(R.id.mainDrawer)
        navigationView = findViewById(R.id.navigationView)
        abc = findViewById(R.id.appbar)


        setUpView()


        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> Toast.makeText(applicationContext, "Item 1 selected", Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(applicationContext, "Item 2 selected", Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(applicationContext, "Item 3 selected", Toast.LENGTH_SHORT).show()
                R.id.number1 -> Toast.makeText(applicationContext, "Number 1 selected", Toast.LENGTH_SHORT).show()
                R.id.number2 -> Toast.makeText(applicationContext, "Number 2 selected", Toast.LENGTH_SHORT).show()
                R.id.number3 -> Toast.makeText(applicationContext, "Number 3 selected", Toast.LENGTH_SHORT).show()
                R.id.extras1 -> Toast.makeText(applicationContext, "Extras 1 selected", Toast.LENGTH_SHORT).show()
                R.id.extras2 -> Toast.makeText(applicationContext, "Extras 2 selected", Toast.LENGTH_SHORT).show()
            }

            true
        })

    }

    private fun setUpView() {
        setSupportActionBar(abc)            //necessary line
        actionBarDrawerToggle = ActionBarDrawerToggle(this , myDrawerLayout , R.string.app_name , R.string.app_name )
        actionBarDrawerToggle.syncState()           //this method is linking the toolbar to the side navigation bar (i.e side drawer)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {       //necessary fun to be override.
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}