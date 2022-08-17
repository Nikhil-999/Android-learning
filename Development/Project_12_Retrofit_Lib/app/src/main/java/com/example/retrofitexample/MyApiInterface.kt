package com.example.retrofitexample

import retrofit2.Call
import retrofit2.http.GET

interface MyApiInterface {

    @GET("posts")
    fun getData(): Call<List<MyDataItem>>
}