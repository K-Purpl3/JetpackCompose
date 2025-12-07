@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cursocompose

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursocompose.ui.theme.CursoComposeTheme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewContainer()
        }
    }
}

@Composable
fun FAB(){
    val context = LocalContext.current
    FloatingActionButton(onClick = { Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show()
    }){
        Text("X")
    }
}


@Composable
fun ViewContainer() {
    val context = LocalContext.current

    Scaffold(
        topBar = { Toolbar() },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show()
            }) {
                Text("X")
            }
        }
    ) { padding ->
        Contenido(modifier = Modifier.padding(padding))
    }
}


@Composable
fun Toolbar(){
    TopAppBar(title = {Text(text = "Sriracha App")}, Modifier.background(Color.Cyan))
}




@Preview
@Composable
fun Contenido(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn (modifier = Modifier.fillMaxSize().background(Color.LightGray).padding(top = 100.dp)) {
        item{
        Image(painter = painterResource(id = R.drawable.unnamed),
                contentDescription = null,
                modifier = Modifier.clickable{ counter++
                }
            )
            LazyRow {
                item {
                    Row (modifier = Modifier.padding(top = 8.dp)){
                        Image(painter = painterResource(id = R.drawable.favorite),
                            contentDescription = null,
                            modifier = Modifier.clickable{ counter++
                            }
                        )

                        Text(text = counter.toString(), color = Color.Black, modifier = Modifier.padding(start = 4.dp, top = 2.dp))
                    }
                }
            }
        }

        item {
            Text(
                fontSize = 26.sp,
                color = Color.Red,
                textAlign = TextAlign.Center ,
                text = "test",
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                fontSize = 26.sp,
                color = Color.Blue,
                textAlign = TextAlign.Center ,
                text = "skibidi",
                modifier = Modifier.padding(top = 8.dp)

            )
            Text(
                fontSize = 26.sp,
                color = Color.Green,
                textAlign = TextAlign.Center ,
                text = "test",
                modifier = Modifier.padding(top = 8.dp)

            )
        }
    }
}