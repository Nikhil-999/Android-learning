package com.example.databindingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var myDataClass: MyDataClass
    private lateinit var myBinder: ActivityMainBinding      //this class is automatically created when we set the XML layout into <layout> .... </layout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myBinder = DataBindingUtil.setContentView(this , R.layout.activity_main)   //this dataBindingUtil method is important to bind the Content views.

        myDataClass = MyDataClass("Binding done using a Variable" , "Binding done using a Variable")

//        myBinder.headerID.text = "this is Binding using ID calling Header"        //--> this is without using data class AND variable
//        myBinder.footerID.text = "This is Bindgin using ID calling Footer"        //--> this is without using data class AND variable

        myBinder.btnCLickMe.setOnClickListener {
            myBinder.myVar = myDataClass            //as myVar is the type of myDataClass hence it can hold the reference to this class.
        }

    }


}