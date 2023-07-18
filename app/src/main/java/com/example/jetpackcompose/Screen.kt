package com.example.Jetpack1

sealed class Screen(
    val route: String,
){
    object Home:Screen(
        route = "home_screen",
    )
    object Login:Screen(route = "login_screen")
    object Update:Screen(route = "update_page")
    object Chart:Screen(route = "chart_screen")
    object Saved:Screen(route = "saved_screen")
    object Setting:Screen(route = "setting_screen")

}
