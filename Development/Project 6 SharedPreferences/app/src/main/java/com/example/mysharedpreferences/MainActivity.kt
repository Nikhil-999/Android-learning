package com.example.mysharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnSaveData = findViewById<Button>(R.id.btnSaveData)
        btnSaveData.setOnClickListener {
            saveData()
        }

        val btn = findViewById<Button>(R.id.btnShowData)
        btn.setOnClickListener {
            showData()
        }
    }

    private val demo = HashSet<String>()

    private fun saveData(){
        val userInput = findViewById<TextView>(R.id.userInput)
        val mySharedPreferences: SharedPreferences = getSharedPreferences("myKey", Context.MODE_PRIVATE)
        val mySharedEditor: SharedPreferences.Editor = mySharedPreferences.edit()
//        if(userInput.text.toString() == ""){
//            Snackbar.make(findViewById(R.id.btnShowData), "Please Enter some Text" , Snackbar.LENGTH_LONG).show()
//            return
//        }
//        mySharedEditor.apply {
//            putString("myStringKey" , userInput.text.toString())
//        }.apply()


//        mySharedPreferences.getStringSet("myHashSet",null)?.let { demo.addAll(it) }           --> Error in this statement.

        demo.add(userInput.text.toString().trim())
        //demo.add("Nikhil")
        //demo.add("Arpit")

        mySharedEditor.apply {
            mySharedEditor.putStringSet("myHashSet" , demo)
        }.apply()

        Toast.makeText(findViewById<Button>(R.id.btnSaveData).context,"Your data have saved Succesfully", Toast.LENGTH_LONG ).show()
        userInput.text = ""
    }

    private fun showData() {
        val savedDataText: TextView = findViewById(R.id.savedDataText)
        val mySharedPreferences: SharedPreferences = getSharedPreferences("myKey", Context.MODE_PRIVATE)
//        val savedString: String? = mySharedPreferences.getString("myStringKey" , "")
//        if(savedString == ""){
//            Snackbar.make(findViewById(R.id.btnShowData), "No data saved Previously" , Snackbar.LENGTH_LONG).show()
//            return
//        }

        val ans: MutableSet<String>? = mySharedPreferences.getStringSet("myHashSet" , null)
        savedDataText.text = ans.toString()
    }

}