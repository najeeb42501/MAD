package com.example.lab3

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab3.ui.theme.Lab3Theme
import com.example.navigation.LoginScreen
import com.example.navigation.Screens
import com.example.navigation.SignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val data = resources.getStringArray(R.array.friend_names)
        setContent {
            Lab3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(resources)
                }
            }
        }
    }
}



@Composable
fun MyApp(resources: Resources){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.Login.route ){
        composable(Screens.Login.route){
            LoginScreen(navController)
        }
        composable(Screens.Signup.route){
            SignUp(navController)
        }
        composable(Screens.Friends.route){
            FriendsScreen(navController, resources)
        }
        composable("Character_screen/{index}"){ backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")
            CharacterScreen(navController,index, resources)
        }
    }
}



