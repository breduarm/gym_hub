package com.beam.gymhubandroid.onboarding.presentation.congratulations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun CongratulationsScreen(navController: NavController) {
    CongratulationsScreenContent()
}

@Composable
fun CongratulationsScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "CongratulationsScreen", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun CongratulationsScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        CongratulationsScreen(NavController(context))
    }
}