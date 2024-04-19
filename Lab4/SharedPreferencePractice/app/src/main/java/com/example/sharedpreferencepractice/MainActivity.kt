package com.example.sharedpreferencepractice

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.sharedpreferencepractice.ui.theme.SharedPreferencePracticeTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SharedPreferencePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context: Context = LocalContext.current) {


    val prefObj = PrefencencesManager(context)

    var username by remember {
        mutableStateOf("")
    }

    val name = prefObj.getData("user", "Guest")




    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = username, onValueChange = {
            username = it
        } )
        Button(onClick = {
            prefObj.saveData("user", username)

        }) {
            Text(text = "Save")

        }
        Text(text = name)
    }
}




class PrefencencesManager(context: Context){

    val pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    fun saveData(key: String, value:String){
        val editor = pref.edit()
        editor.putString(key,value)
        editor.commit()
    }

    fun getData(key: String, defaultValue: String): String{
        return pref.getString(key, defaultValue) ?: defaultValue
    }
}

@Composable
fun MultiStyleText(){
    Text(text = buildAnnotatedString {
        append("Hello World!")
        withStyle(
            SpanStyle(
                brush = Brush.linearGradient()
            )
        ){
            append("GGG")
        }
    })
}

@Preview
@Composable
fun TextPreiview(){
    MultiStyleText()
}