package com.example.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavHostController) {

    Box (modifier = Modifier.fillMaxSize().background(Color.Blue)){
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement =  Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextField(value ="" , onValueChange = {}, label = { Text(text = "Full Name") })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value ="" , onValueChange = {}, label = { Text(text = "Email") })
            Spacer(modifier = Modifier.height(10.dp))
            TextField(value ="" , onValueChange = {}, label = { Text(text = "Password") })
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { }) {
                Text(text = "Register")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(text = "Already registered? ")
                TextButton(onClick = {  navController.navigate(route = Screens.Login.route) }) {
                    Text(text = "Login!")
                }

            }


        }

    }


}