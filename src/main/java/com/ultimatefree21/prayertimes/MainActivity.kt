package com.ultimatefree21.prayertimes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrayerTimesApp()
        }
    }
}

@Composable
fun PrayerTimesApp() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Display Prayer Times Here")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PrayerTimesApp()
}