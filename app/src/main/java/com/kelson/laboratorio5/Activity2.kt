package com.kelson.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelson.laboratorio5.ui.theme.Laboratorio5Theme

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Encabezado()
                }
            }
        }
    }
}

@Composable
fun Encabezado() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Text(text = "My Profile")
                }
                Row {
                    //Image(imageVector = , contentDescription = )
                }
            }
        }
        Row {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(1.dp)
                        .height(250.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.portadaduck1),
                        contentDescription = "Portada de Pato",
                        Modifier.fillMaxSize()
                    )
                    Image(
                        painter = painterResource(id = R.drawable.pato1),
                        contentDescription = "ProfilePic Pato",
                        Modifier
                            .align(Alignment.BottomCenter)
                            .padding(0.9.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .clip(CircleShape)
                    )
                }
            }

        }
        Row {
            //Listado de opciones
            val sels = arrayListOf<Selection>(
                Selection("My Campus",R.drawable.baseline_class_24, Color.Gray),
                Selection("My Friends",R.drawable.baseline_group_24, Color.Gray),
                Selection("My Calendar",R.drawable.baseline_calendar_today_24, Color.Gray),
                Selection("My Courses",R.drawable.outline_library_books_24, Color.Gray),
                Selection("My Grades",R.drawable.baseline_grade_24, Color.Gray),
                Selection("My Groups",R.drawable.baseline_hub_24, Color.Gray),
                Selection("My Upcoming Events",R.drawable.baseline_event_24, Color.Gray)
            )
            Column {
                Text(text = "Derek Fabian Arreaga Kelson",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold))

                for (n in sels ){
                    SelectionRow(n)
                }
            }



        }
    }
}


data class Selection(val title: String, val logoName: Int, val colorLogo: Color)
@Composable
fun SelectionRow(selection : Selection) {
    Card(
        modifier = Modifier
            .height(53.dp)
            .padding(bottom = 8.dp)
    ) {
        Column (
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row{
                val logoPainter = painterResource(id = selection.logoName)
                Image(
                    painter = logoPainter,
                    contentDescription = "Recipe Image",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(bottom = 8.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = selection.title,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Light
                    )
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun EncabezadoPreview() {
    Laboratorio5Theme {
        Encabezado()
    }
}