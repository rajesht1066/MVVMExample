package com.example.mvvmexample.network

import com.example.mvvmexample.network.data.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface CustomApi {
    @GET("/quotes")
    suspend fun getQuotes() : Response<Quotes>
}