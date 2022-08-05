package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun loginButtonClicked(view: View) {
        val name = findViewById<EditText>(R.id.TextPersonName)
        val password = findViewById<EditText>(R.id.TextPassword)

        if (name.text.toString() == "" || password.text.toString() == "") {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userName_key", name.text.toString())
            intent.putExtra("myMessage", password.text.toString())
            startActivity(intent)
            Toast.makeText(this, "Hey Geek", Toast.LENGTH_SHORT).show()
        }

    }


}