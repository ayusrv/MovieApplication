package com.example.movieapplication.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.models.Data
import com.example.movieapplication.models.Details
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState()) // Mutable state variable to store the screen state
    var id by mutableIntStateOf(0) // Mutable state variable to store the movie ID

    init {
        viewModelScope.launch { // Launch a coroutine in the view model scope to get the movies list from the repository
            val response =
                repository.getMovieList(state.page) // Get the movies list from the repository using the page state variable and store the response in a variable
            state =
                state.copy(movies = response.body()!!.data) // Update the state with the movies list from the response body and store it in the state variable
        }
    }

    // Function to get the details of a movie by its ID
    fun getDetailById() {
        viewModelScope.launch {
            try {
                val response = repository.getDetailsById(id = id) // Get the details of the movie by its ID from the repository and store the response in a variable
                if (response.isSuccessful) {
                    state = state.copy(
                        detailsData = response.body()!! // Update the state with the details of the movie from the response body and store it in the state variable
                    )
                }
            } catch (e: Exception) {

            }
        }
    }

}

data class ScreenState(
    val movies: List<Data> = emptyList(), // List of movies to be displayed on the screen
    val page: Int = 1, // Current page number
    val detailsData: Details = Details()
)