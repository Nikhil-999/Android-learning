package com.example.mylivedataapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModelClass: ViewModel() {
    val myLiveData = MutableLiveData<String>("This is live data")

    fun updateLiveData(){
        myLiveData.value = "U clicked the button"
    }
}