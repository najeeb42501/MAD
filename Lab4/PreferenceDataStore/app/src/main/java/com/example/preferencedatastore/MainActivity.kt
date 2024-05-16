package com.example.preferencedatastore

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.preferencedatastore.ui.theme.PreferenceDataStoreTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreferenceDataStoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val dataMgr = MyDataStoreManager(this)

                    MyApp(dataMgr = dataMgr)
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, dataMgr : MyDataStoreManager){
    var user = remember { mutableStateOf("") }
    var lastValue = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit){
        lastValue.value = dataMgr.GetName()
    }
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {

        TextField(value = user.value, onValueChange = {
            user.value = it
        })

        Button(onClick = {
            scope.launch {
                dataMgr.SaveName(user.value)
            }
//Save value in preferences

        }) {
            Text("Save")
        }
        Text(lastValue.value)
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PreferenceDataStoreTheme {
        Greeting("Android")
    }
}



