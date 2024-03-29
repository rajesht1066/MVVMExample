package com.example.mvvmexample.network

import com.example.mvvmexample.network.data.Quotes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitHelper {
    val api:CustomApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://quotable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CustomApi::class.java)
    }
}