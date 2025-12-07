package com.example.cursocompose

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursocompose.ui.theme.CursoComposeTheme
import androidx.compose.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }
}

@Preview
@Composable
fun app(){
    var counter by rememberSaveable{ mutableStateOf(0) }

    LazyColumn (modifier = Modifier.fillMaxSize()) {
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
    CursoComposeTheme {
        Greeting("Android")
    }
}