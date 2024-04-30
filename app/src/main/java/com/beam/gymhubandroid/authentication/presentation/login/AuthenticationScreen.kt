package com.beam.gymhubandroid.authentication.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun LoginScreen() {
    LoginScreenContent()
}

@Composable
fun LoginScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is the Login flow", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun LoginScreenPreview() {
    GymHubTheme {
        LoginScreen()
    }
}