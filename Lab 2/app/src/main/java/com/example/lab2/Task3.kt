<<<<<<< HEAD
package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(heightDp = 500)
@Composable
fun PreviewTask() {
    Task3()
}

@Composable
fun Task3() {
    Column {
        getListItems().map { item ->
            Layout(img = item.img, title = item.title, subtitle = item.subtitle)
        }
    }
}

@Composable
fun Layout(img: Int, title: String, subtitle: String) {
    Card(modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(8.dp)) {
        Row {
            Image(
                painter = painterResource(
                    id = img
                ),
                contentDescription = "Description",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.weight(.8f)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium )
                Text(text = subtitle, fontWeight = FontWeight.Thin,style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


data class Category(val img: Int, val title: String, val subtitle: String)

fun getListItems(): MutableList<Category> {
    var list = mutableListOf<Category>();
    list.add(Category(R.drawable.bot, "Ironman", "Age: 21"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Captain America", "Age: 22"))
    list.add(Category(R.drawable.ic_launcher_background, "Quick Silver", "Age: 23"))
    list.add(Category(R.drawable.bot, "Vision", "Age: 24"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Black Widow", "Age: 25"))
    list.add(Category(R.drawable.ic_launcher_background, "Thor", "Age: 26"))

    return list
=======
package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(heightDp = 500)
@Composable
fun PreviewTask() {
    Task3()
}

@Composable
fun Task3() {
    Column {
        getListItems().map { item ->
            Layout(img = item.img, title = item.title, subtitle = item.subtitle)
        }
    }
}

@Composable
fun Layout(img: Int, title: String, subtitle: String) {
    Card(modifier = Modifier.padding(8.dp), elevation = CardDefaults.cardElevation(8.dp)) {
        Row {
            Image(
                painter = painterResource(
                    id = img
                ),
                contentDescription = "Description",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.weight(.8f)
            ) {
                Text(text = title, style = MaterialTheme.typography.titleMedium )
                Text(text = subtitle, fontWeight = FontWeight.Thin,style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


data class Category(val img: Int, val title: String, val subtitle: String)

fun getListItems(): MutableList<Category> {
    var list = mutableListOf<Category>();
    list.add(Category(R.drawable.bot, "Ironman", "Age: 21"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Captain America", "Age: 22"))
    list.add(Category(R.drawable.ic_launcher_background, "Quick Silver", "Age: 23"))
    list.add(Category(R.drawable.bot, "Vision", "Age: 24"))
    list.add(Category(R.drawable.ic_launcher_foreground, "Black Widow", "Age: 25"))
    list.add(Category(R.drawable.ic_launcher_background, "Thor", "Age: 26"))

    return list
>>>>>>> 02cbae08860a40ea229a28b585a57578be79ef91
}