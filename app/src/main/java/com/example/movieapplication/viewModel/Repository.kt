package com.example.movieapplication.viewModel

import com.example.movieapplication.models.Details
import com.example.movieapplication.models.MoviesList
import com.example.movieapplication.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page: Int): Response<MoviesList>{
        return RetrofitInstance.api.getMovies(page) // Get the movies list from the API using the API interface object and return the response object with the movies list

    }

    suspend fun getDetailsById(id: Int): Response<Details>{
        return  RetrofitInstance.api.getDetailById(id = id) // Get the details of a movie by its ID from the API using the API interface object and return the response object with the details
    }
}