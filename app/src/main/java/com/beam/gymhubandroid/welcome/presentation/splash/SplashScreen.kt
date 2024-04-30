package com.beam.gymhubandroid.welcome.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun SplashScreen() {
    SplashScreenContent()
}

@Composable
fun SplashScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "SplashScreen", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    GymHubTheme {
        SplashScreen()
    }
}