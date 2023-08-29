package com.kelson.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kelson.laboratorio5.ui.theme.Laboratorio5Theme
import coil.compose.rememberAsyncImagePainter

class Activity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Text(
            text = "Campus Central",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        val imagePainter = rememberAsyncImagePainter(model = "https://aprende.guatemala.com/wp-content/uploads/2021/06/C%C3%B3mo-solicitar-una-beca-en-la-Universidad-del-Valle-de-Guatemala..jpg")
        Image(
            painter= imagePainter,
            contentDescription="Laboratorio",
            modifier= Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(bottom = 8.dp),
            contentScale= ContentScale.Crop
        )
        val link1 = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fyt3.ggpht.com%2F-tLYWuAbFxDc%2FAAAAAAAAAAI%2FAAAAAAAAAAA%2FK1xhMlFhAcM%2Fs900-c-k-no-mo-rj-c0xffffff%2Fphoto.jpg&f=1&nofb=1&ipt=54da23d458124fabe6716c09709ccd6dd59d8a6fc94f603ef38f2d74ed5900d9&ipo=images"
        val link2 = "https://noticias.uvg.edu.gt/wp-content/uploads/App-UVG-Plus-RRSS.jpg"
        val link3 = "https://res.cloudinary.com/webuvg/image/upload/f_auto,q_auto,w_329,c_scale,fl_lossy,dpr_2.63/v1537292325/WEB/Servicios/Servicios%20cient%C3%ADficos%20y%20tecnol%C3%B3gicos/estudiantes-uvg-en-laboratorio-cientifico.jpg"
        val link4 = "https://bibliotecas.uvg.edu.gt/wp-content/uploads/2022/07/Isla-de-mineria-de-datos-1.jpg"
        val op1 = Opciones("Service Now",link1, Color.Green)
        val op2 = Opciones("Actualidad UVG",link2, Color.Gray)
        val op3 = Opciones("Directorio de Servicios Estudiantiles", link3, Color.Green)
        val op4 = Opciones("Portal Web Bibliotecas UVG",link4, Color.Gray)
        Text(text = "Destacados",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Row{

            OptionCard(opciones = op1)
            OptionCard(opciones = op2)
        }
        Text(text = "Servicios y Recursos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Row{
            OptionCard(opciones = op3)
            OptionCard(opciones = op4)
        }

    }

}

data class Opciones(val title: String, val imageUrl: String, val colorFondo: Color)
@Composable
fun OptionCard(opciones : Opciones) {
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
fun MainScreenPreview() {
    Laboratorio5Theme {
        MainScreen()
    }
}