package com.example.myfilesystem

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import java.io.*

class MainActivity : AppCompatActivity() {

    private lateinit var userInput: TextView
    private lateinit var btnSave: Button
    private lateinit var btnLoad: Button
    private lateinit var textOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInput = findViewById(R.id.userInput)
        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)
        textOutput = findViewById(R.id.textOutput)

        btnSave.setOnClickListener {
//            saveMyFile()
            writeFileOnInternalStorage(applicationContext , "kotlinFILE" , userInput.text.toString())
        }

        btnLoad.setOnClickListener {
            loadMyFile()
        }
    }

    private fun saveMyFile() {
        if (userInput.text.toString() == "") {
            Snackbar.make(btnSave, "Please Enter some text", Snackbar.LENGTH_LONG).show()
            return
        }
        val fileData: String = userInput.text.toString()
        val myFile: FileOutputStream = openFileOutput("myFirstFile", MODE_PRIVATE)
        myFile.write(fileData.toByteArray())
        myFile.close()
        Toast.makeText(this, "Successfully File created", Toast.LENGTH_LONG).show()
        userInput.text = ""
    }

    private fun loadMyFile() {
        val demo: String
        try {
            val myFile: FileInputStream = openFileInput("kotlinFILE")
            val reader: InputStreamReader = InputStreamReader(myFile)
            val myBuffer: BufferedReader = BufferedReader(reader)
            val myStringBuilder: StringBuilder = StringBuilder()
            var text: String?
            while ((myBuffer.readLine().also { text = it }) != null) {

                myStringBuilder.append(text)
            }
//            demo = myFile.fd.toString()
            textOutput.text = myStringBuilder.toString()
//            Log.e("Successfully filed", "loadMyFile: $demo ")
        }catch (E: Exception){

            Log.e("File Opening ERROR", "loadMyFile: there is some error " )
            Snackbar.make(btnLoad , "File Doesn't Exist" , Snackbar.LENGTH_SHORT).show()
        }
    }


    fun writeFileOnInternalStorage(mcoContext: Context, sFileName: String?, sBody: String?) {
        val dir = File(mcoContext.getFilesDir(), "mydir")
        if (!dir.exists()) {
            dir.mkdir()

        }
        try {
            val gpxfile = File(dir, sFileName)
            val writer = FileWriter(gpxfile)
            writer.append(sBody)
            writer.flush()
            writer.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}