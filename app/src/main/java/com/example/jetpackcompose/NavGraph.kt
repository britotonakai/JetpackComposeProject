package com.example.Jetpack1

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ChartScreen
import com.example.jetpackcompose.HomeScreen
import com.example.jetpackcompose.SaveScreen
import com.example.jetpackcompose.SettingScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route)
    {
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Login.route
        ){
            Page1Screen(navController = navController)
        }
        composable(
            route = Screen.Update.route
        ){
            UpdateScreen(navController = navController)
        }
        composable(
            route = Screen.Chart.route
        ){
            ChartScreen(navController = navController)
        }
        composable(
            route = Screen.Saved.route
        ){
            SaveScreen(navController = navController)
        }
        composable(
            route = Screen.Setting.route)
        {
            SettingScreen(navController = navController)
        }
    }
}