package com.nasrabadiam.progress_modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(96.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Red)
                .progressAnimation(10000)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(96.dp)
                .padding(16.dp)
                .clip(CircleShape)
                .background(Color.Blue)
                .progressAnimation(7000)
        )
        Box(
            Modifier
                .width(196.dp)
                .height(196.dp)
                .padding(16.dp)
                .clip(CircleShape)
                .background(Color.Green)
                .progressAnimation(8000)
        )
        Box(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .clip(CutCornerShape(96.dp))
                .progressAnimation(4000)
                .background(Color.Yellow)
        )
    }
}