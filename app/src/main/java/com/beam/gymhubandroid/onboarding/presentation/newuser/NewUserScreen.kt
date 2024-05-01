package com.beam.gymhubandroid.onboarding.presentation.newuser

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
fun NewUserScreen(navController: NavController) {
    NewUserScreenContent()
}

@Composable
fun NewUserScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "NewUserScreen", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun NewUserScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        NewUserScreen(NavController(context))
    }
}