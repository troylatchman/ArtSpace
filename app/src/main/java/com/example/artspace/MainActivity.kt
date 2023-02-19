package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Picture()
            PictureInfo()
            MoveButtons()
        }
    }
}

/*
1. Mona Lisa | 1503-1506 | Leonardo da Vinci
2. The Creation of Adam | 1508-1512 | 	Michelangelo
3. Girl with a Pearl Earring | 1665 | 	Johannes Vermeer
4. The Starry Night | 1889 | 	Vincent van Gogh
5. American Gothic | 1930 | Grant Wood
 */

@Composable
fun Picture(modifier: Modifier = Modifier) {
    Text("Picture")
}

@Composable
fun PictureInfo(modifier: Modifier = Modifier) {
    Text("PictureInfo")
}

@Composable
fun MoveButtons(modifier: Modifier = Modifier) {
    Text("MoveButtons")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}