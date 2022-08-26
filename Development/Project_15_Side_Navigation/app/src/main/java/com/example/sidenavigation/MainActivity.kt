package com.example.sidenavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var myDrawerLayout: DrawerLayout
    private lateinit var abc: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDrawerLayout = findViewById(R.id.mainDrawer)
        abc = findViewById(R.id.appbar)
        setUpView()
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