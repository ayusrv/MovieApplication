package com.example.movieapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController() // Initialize the navigation controller using the rememberNavController function
    NavHost(navController = navController, startDestination = "Banner Screen") // Initialize the navigation host with the navigation controller and the start destination
    {
        composable("Banner screen") // Add a composable for the banner screen
        {
            BannerScreen(navController = navController) // Call the BannerScreen function to display the banner screen
        }
        composable("Home screen")
        {
            HomeScreen(navController = navController)
        }
        composable("Details screen/{id}",
            arguments = listOf(
                navArgument(
                    name = "id"
                ){
                    type = NavType.IntType
                }
            )
        )
        {id->
            id.arguments?.getInt("id")?.let {
                id1 -> DetailsScreen(id= id1)
            }

        }
    }

}
