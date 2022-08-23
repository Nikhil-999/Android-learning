package com.example.preferences_datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.asLiveData
import com.example.preferences_datastore.data.SettingsDataStore
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var SettingsDataStore: SettingsDataStore
    private lateinit var et_name: EditText
    private lateinit var et_age: EditText
    private lateinit var tv_name: TextView
    private lateinit var tv_age: TextView
    private lateinit var btn_save: Button
    private lateinit var btn_load: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_save = findViewById(R.id.btn_save)
        btn_load = findViewById(R.id.btn_load)

        SettingsDataStore = SettingsDataStore(this@MainActivity)

        btn_save.setOnClickListener {
            et_name = findViewById(R.id.et_name)
            et_age = findViewById(R.id.et_age)
            runBlocking {
                launch {
                    SettingsDataStore.saveLayoutToPreferencesStore(et_name.text.toString() , et_age.text.toString() , this@MainActivity )
                }
            }
            Toast.makeText(this , "Data Saved Successfully" , Toast.LENGTH_SHORT).show()
        }


        btn_load.setOnClickListener {
            tv_name = findViewById(R.id.tv_name)
            tv_age = findViewById(R.id.tv_age)

//             tv_name.text = SettingsDataStore.preferenceFlow.toString()       doing this was a mistake
//            tv_age.text = SettingsDataStore.preferenceFlow2.toString()        doing this was a mistake

            val readFromDataStore = SettingsDataStore.preferenceFlow.asLiveData()
            readFromDataStore.observe(this@MainActivity) { name ->
                tv_name.text = name
            }

            val readFromDataStore2 = SettingsDataStore.preferenceFlow2.asLiveData()
            readFromDataStore2.observe(this@MainActivity) { age ->
                tv_age.text = age
            }
        }

    }
}