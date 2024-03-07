<<<<<<< HEAD
package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PreviewGrid() {
    GridView()
}

@Composable
fun GridView() {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(getList()) { item ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.Blue),
                ) {
                    Column (
                        modifier = Modifier
                            .background(Color.Blue)
                    ){
                        Image(painter = painterResource(id = item.img), contentDescription = "desc", Modifier.fillMaxSize().height(150.dp))
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)

                        )
                    }
                }
            }
        }
    )
}

data class Categories(val img: Int, val title: String)

fun getList(): MutableList<Categories> {
    var list = mutableListOf<Categories>();
    list.add(Categories(R.drawable.turkey, "Turkey"))
    list.add(Categories(R.drawable.girl, "Travel"))
    list.add(Categories(R.drawable.mount, "Mountain"))
    list.add(Categories(R.drawable.turkey, "Turkey"))
    list.add(Categories(R.drawable.girl, "Travel"))
    list.add(Categories(R.drawable.mount, "Mountain"))

    return list
=======
package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PreviewGrid() {
    GridView()
}

@Composable
fun GridView() {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(getList()) { item ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .background(Color.Blue),
                ) {
                    Column (
                        modifier = Modifier
                            .background(Color.Blue)
                    ){
                        Image(painter = painterResource(id = item.img), contentDescription = "desc", Modifier.fillMaxSize().height(150.dp))
                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)

                        )
                    }
                }
            }
        }
    )
}

data class Categories(val img: Int, val title: String)

fun getList(): MutableList<Categories> {
    var list = mutableListOf<Categories>();
    list.add(Categories(R.drawable.turkey, "Turkey"))
    list.add(Categories(R.drawable.girl, "Travel"))
    list.add(Categories(R.drawable.mount, "Mountain"))
    list.add(Categories(R.drawable.turkey, "Turkey"))
    list.add(Categories(R.drawable.girl, "Travel"))
    list.add(Categories(R.drawable.mount, "Mountain"))

    return list
>>>>>>> 02cbae08860a40ea229a28b585a57578be79ef91
}