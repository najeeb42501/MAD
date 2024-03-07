package com.example.lab3

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navigation.Screens

@Composable
fun FriendsScreen(navController: NavController, resources: Resources){


    val actorNames: List<String> = resources.getStringArray(R.array.friend_names).toList()


    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Firendsr",
                color = Color.DarkGray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
            Text(text = "Click on an eligible user to learn more and see if you compatible for a date",
                color = Color.DarkGray,
                modifier =  Modifier.padding(10.dp))
            Spacer(modifier = Modifier.height(1.dp))

            LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(4.dp) ){
                items(actorNames.size) { index ->
                    val name = actorNames[index]
                    val imageId = getDrawableIdFromName(name)
                    ImageWithName(
                        imageId = imageId,
                        name = name ,
                        onClick = { navController.navigate(Screens.Character.route + "/$index") } )
                }
            }




        }
    }

}


@Composable
fun ImageWithName(imageId: Int, name: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "",
            Modifier
                .size(120.dp)
                .padding(2.dp)
                .border(4.dp, Color.DarkGray)
                .clickable(
                    onClick = onClick
                )
        )
        Text(
            text = name,
            color = Color.Black,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
        )
    }
}

fun getDrawableIdFromName(name: String): Int {
    return when (name) {
        "Chandler" -> R.drawable.chandlerpreview
        "Joey" -> R.drawable.joeypreview
        "Monica" -> R.drawable.monicapreview
        "Phoebe" -> R.drawable.phoebepreview
        "Rachel" -> R.drawable.rachelpreview
        "Ross" -> R.drawable.rosspreview
        else -> R.drawable.chandlerpreview
    }
}
