package com.example.viewmodelexample

import androidx.lifecycle.ViewModel

class MyViewModelClass: ViewModel() {
    var counter = 0

    fun increment(){
        counter++
    }
}