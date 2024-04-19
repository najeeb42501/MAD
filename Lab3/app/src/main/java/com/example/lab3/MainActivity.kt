package com.example.lab3

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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

    SplashScreen(navController = navController)

    
    NavHost(navController = navController, startDestination = "splash_screen" ){

        composable("splash_screen"){
            SplashScreen(navController)
        }
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




@Composable
fun SplashScreen(navController: NavController) {
    val delay = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        delay.animateTo(1f, animationSpec = tween(3000))
        navController.navigate("login_screen")
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Splash Screen")
    }
}



