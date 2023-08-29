package com.kelson.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
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
    ){
        Row{
            Column(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Text(text = "My Profile")
                }
                Row{
                    //Image(imageVector = , contentDescription = )
                }
            } 
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.portadaduck1),
                contentDescription = "Portada de Pato",
                Modifier.height(250.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Row{
            Image(painter = painterResource(id = R.drawable.pato1), contentDescription = "ProfilePic Pato",
                Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, shape = CircleShape)
                )
        }
    }

}

@Composable
fun Cuerpo(){



}

data class Selection(val title: String, val logoName: String, val colorLogo: Color)
@Composable
fun SelectionRow(opciones : Opciones) {
    Card(
        modifier = Modifier
            .width(190.dp)
            .padding(bottom = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column (
            modifier = Modifier
                .background(opciones.colorFondo)
                .fillMaxWidth()
                .padding(8.dp)
        ){
            val imagePainter = rememberAsyncImagePainter(model = opciones.imageUrl)
            Image(
                painter= imagePainter,
                contentDescription="Recipe Image",
                modifier= Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(bottom = 8.dp),
                contentScale= ContentScale.Crop
            )

            Text(
                text = opciones.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(opciones.colorFondo),
                style = TextStyle(
                    color = Color.White,
                    background = opciones.colorFondo,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            )
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