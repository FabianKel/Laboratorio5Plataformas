package com.kelson.laboratorio5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.kelson.laboratorio5.ui.theme.Laboratorio5Theme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Menu()
                }
            }
        }
    }
}

@Composable
fun Menu(){
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Text("MENÚ PRINCIPAL", color = Color.Black)

        Row {
            val mContext = LocalContext.current
            Button(onClick = {

                mContext.startActivity(Intent(mContext, Activity1::class.java))
            }
            ) {
                Text("Campus Central", color = Color.White)
            }
        }
        Row {
            val mContext = LocalContext.current
            Button(onClick = {

                mContext.startActivity(Intent(mContext, Activity2::class.java))
            }
            ) {
                Text("Perfil", color = Color.White)
            }
        }
        Row {
            val mContext = LocalContext.current
            Button(onClick = {

                mContext.startActivity(Intent(mContext, Activity3::class.java))
            }
            ) {
                Text("Settings", color = Color.White)
            }
        }
        Row {
            val mContext = LocalContext.current
            Button(onClick = {

                mContext.startActivity(Intent(mContext, Activity1::class.java))
            }
            ) {
                Text("Emergencia", color = Color.White)
            }
        }
    }
}


@Preview
@Composable
fun ManuPreview() {
    Laboratorio5Theme {
        Menu()
    }
}