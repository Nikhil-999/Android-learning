package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var btnSaveData: Button
    private lateinit var userData: EditText
    private lateinit var taskNum: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userData = findViewById(R.id.userData)
        btnSaveData = findViewById(R.id.btnSaveData)
        taskNum = findViewById(R.id.taskNum)

        btnSaveData.setOnClickListener {
            val database = Firebase.database
            val myRef = database.getReference(taskNum.text.toString())

            myRef.setValue(userData.text.toString())
            userData.setText("")
            taskNum.setText("")
            Toast.makeText(this , "Successfully saved" , Toast.LENGTH_SHORT).show()

        }
    }
}