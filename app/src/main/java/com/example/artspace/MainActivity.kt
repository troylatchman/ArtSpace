package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var artIndex by remember { mutableStateOf(0) }
    val artWorks = ArtworkData.getAllArtwork()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Artwork(
                artWorks[artIndex].image,
                artWorks[artIndex].title,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            ArtworkInfo(
                artWorks[artIndex].title,
                artWorks[artIndex].artist,
                artWorks[artIndex].year,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.height(46.dp))
            ActionButtons(
                onPreviousClick = {
                    when (artIndex) {
                        0 -> artIndex = artWorks.size - 1
                        else -> artIndex--
                    }
                },
                onNextClick = {
                    when (artIndex) {
                        artWorks.size - 1 -> artIndex = 0
                        else -> artIndex++
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun Artwork(
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        elevation = 10.dp,
        border = BorderStroke(2.dp, Color.Gray),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier
                .padding(30.dp)
        )
    }
}

@Composable
fun ArtworkInfo(
    titleResourceId: Int,
    artistResourceId: Int,
    yearResourceId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        elevation = 10.dp,
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row {
                Text(
                    text = stringResource(titleResourceId),
                    fontSize = 32.sp
                )
            }
            Row {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(stringResource(artistResourceId))
                        }
                        append(" (${stringResource(yearResourceId)})")
                    }
                )
            }
        }
    }
}

@Composable
fun ActionButtons(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(onClick = onPreviousClick) {
            Text(text = stringResource(R.string.previous))
        }
        Button(onClick = onNextClick) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}