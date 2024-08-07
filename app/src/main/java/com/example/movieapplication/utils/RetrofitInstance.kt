package com.example.movieapplication.utils

import com.example.movieapplication.domain.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: ApiInterface by lazy{
        Retrofit.Builder()  // Retrofit builder to build the retrofit object
            .baseUrl(Util.Base) // Base url of the API we are using
            .addConverterFactory(GsonConverterFactory.create()) // Converter factory to convert the JSON data to Kotlin objects
            .build() // Build the retrofit object
            .create(ApiInterface::class.java) // Create the API interface object
    }

}