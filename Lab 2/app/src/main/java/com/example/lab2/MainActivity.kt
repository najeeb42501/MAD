package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Composable
fun Greeting() {

    val buttonColor = remember { mutableStateOf(Color.Red) }
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {

                buttonColor.value = if (buttonColor.value == Color.Red) {
                    Color.Green
                } else {
                    Color.Red
                }

            },

            colors = ButtonDefaults.buttonColors(buttonColor.value)
        ) {
            Text(text = "Click Me")
        }

    }
    //Task2
    Row {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Description",
            Modifier.size(40.dp)
        )
        Column {
            Text(text = "Text line 1")
            Text(text = "Text line 2")
        }
    }

}

@Preview(showBackground = true, widthDp = 300, heightDp = 600)
@Composable
fun PreviewGreeting() {

    Greeting()
}

