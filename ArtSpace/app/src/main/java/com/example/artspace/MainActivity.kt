package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGallery()
        }
    }
}
data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String
)

@Composable
fun ArtGallery() {

    val artworks = listOf(
        Artwork(R.drawable.img1, "Cielo Estrellado", "Van Gogh (1889)"),
        Artwork(R.drawable.img2, "Monalisa", "Leonardo da Vinci (siglo XVI)"),
        Artwork(R.drawable.img3, "El grito", "Edvard Munch (1983)")
    )

    var currentIndex by remember { mutableStateOf(0) }
    val currentArt = artworks[currentIndex]

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = currentArt.imageRes),
            contentDescription = currentArt.title,
            modifier = Modifier
                .padding(16.dp)
                .size(250.dp)
        )

        Text(text = currentArt.title)
        Text(text = currentArt.artist)

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(onClick = {
                currentIndex = if (currentIndex == 0) {
                    artworks.lastIndex
                } else {
                    currentIndex - 1
                }
            }) {
                Text("Previous")
            }

            Button(onClick = {
                currentIndex = if (currentIndex == artworks.lastIndex) {
                    0
                } else {
                    currentIndex + 1
                }
            }) {
                Text("Next")
            }
        }
    }
}