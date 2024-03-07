package com.example.navigation

sealed class Screens(val route: String) {
    object Login: Screens(route = "login_screen")
    object Signup: Screens(route = "Signup_screen")
    object Friends: Screens(route = "Friends_screen")
    object Character: Screens(route = "Character_screen")
}