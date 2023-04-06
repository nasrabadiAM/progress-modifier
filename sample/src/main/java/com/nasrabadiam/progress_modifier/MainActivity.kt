package com.nasrabadiam.progress_modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
private fun HomeScreen() {
    var percent by remember { mutableStateOf(0f) }
    LaunchedEffect(Unit) {
        while (percent < 100) {
            delay(500)
            percent += 1
        }
    }

    Column(Modifier.fillMaxSize()) {
        //animation with duration sample
        ShapeWithRoundedCorner()
        RectangleShape()
        CircleShape()
        PolygonShape()
        // progress sample
        PolygonShapeWithProgress(percent)
    }
}

@Composable
private fun ShapeWithRoundedCorner() {
    var logText by remember { mutableStateOf("Rounded corner animation started!") }
    Box(
        Modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Red)
            .progressAnimation(10000) {
                logText = "Rounded corner Shape animation finished!"
            }
    )
    FinishedText(logText)
}

@Composable
private fun RectangleShape() {
    var logText by remember { mutableStateOf("Rectangle animation started!") }
    Box(
        Modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(16.dp)
            .background(Color.Blue)
            .progressAnimation(durationMillis = 7000) {
                logText = "Rectangle shape animation finished!"
            }
    )
    FinishedText(logText)
}

@Composable
private fun CircleShape() {
    var logText by remember { mutableStateOf("Circle animation Started!") }
    Box(
        Modifier
            .width(196.dp)
            .height(196.dp)
            .padding(16.dp)
            .clip(CircleShape)
            .background(Color.Green)
            .progressAnimation(durationMillis = 8000, finishedListener = {
                logText = "Circle Shape animation finished!"
            })
    )
    FinishedText(logText)
}

@Composable
private fun PolygonShape() {
    var logText by remember { mutableStateOf("Polygon Animation Started!") }
    Box(
        Modifier
            .fillMaxWidth()
            .height(68.dp)
            .padding(16.dp)
            .clip(CutCornerShape(96.dp))
            .progressAnimation(durationMillis = 4000, finishedListener = {
                logText = "Polygon Shape animation finished!"
            })
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        FinishedText(text = logText, textColor = Color.Black)
    }
}

@Composable
private fun PolygonShapeWithProgress(percent: Float) {
    val logText by remember { mutableStateOf("Polygon Animation With progress Started!") }
    Box(
        Modifier
            .fillMaxWidth()
            .height(68.dp)
            .padding(16.dp)
            .clip(CutCornerShape(96.dp))
            .progressAnimation(percent = percent)
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        FinishedText(text = logText, textColor = Color.Black)
    }
}

@Composable
private fun FinishedText(text: String, textColor: Color? = null) {
    val textColorBasedOnTheme = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }
    val color = textColor ?: textColorBasedOnTheme
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = text,
        color = color
    )
}