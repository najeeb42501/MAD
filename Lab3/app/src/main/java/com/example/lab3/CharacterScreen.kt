package com.example.lab3

import android.content.res.Resources
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun CharacterScreen(navController: NavController, index: String?, resources: Resources){

    val i: Int = index?.toIntOrNull() ?: -1 // Default value if index is null or conversion fails
    val actorNames: List<String> = resources.getStringArray(R.array.friend_full_names).toList()
    val details: List<String> = resources.getStringArray(R.array.friend_details).toList()

    val name = if (i in actorNames.indices) {
        actorNames[i]
    } else {
        ""
    }

    val desc = if (i in details.indices) {
        details[i]
    } else {
        ""
    }
    LazyColumn(
        modifier = Modifier.padding(10.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val fullNameImage = getDrawableIdFromFullName(name)
        item{
            androidx.compose.foundation.Image(
                painter = painterResource(id = fullNameImage),
                contentDescription = "",
                modifier = Modifier.size(300.dp))
        }
        item {
            Text(text = name, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
        }
        item {
            Text(text = desc)
        }

    }

}

fun getDrawableIdFromFullName(name: String): Int {
    return when (name) {
        "Chandler Bing" -> R.drawable.chandler
        "Joey Tribbiani" -> R.drawable.joey
        "Monica Geller" -> R.drawable.monica
        "Phoebe Buffay" -> R.drawable.phoebe
        "Rachel Green" -> R.drawable.rachel
        "Ross Geller" -> R.drawable.ross
        else -> R.drawable.chandler
    }
}