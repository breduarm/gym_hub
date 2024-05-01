package com.beam.gymhubandroid.onboarding.presentation.newuser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beam.gymhubandroid.onboarding.presentation.tour.OnboardingTopAppBar
import com.beam.gymhubandroid.ui.theme.GymHubTheme
import com.beam.gymhubandroid.welcome.presentation.welcome.GymHubButton

@Composable
fun NewUserScreen(navController: NavController) {
    NewUserScreenContent(navController)
}

@Composable
fun NewUserScreenContent(navController: NavController) {
    Scaffold(
        topBar = {
            OnboardingTopAppBar(
                title = "New User",
                showSkip = false,
                onClickBackNav = { /*TODO*/ }
            )
        },
        bottomBar = {
            OnboardingBottomAppBar()
        }
    ) { innerPadding ->
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var termsChecked by rememberSaveable { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            TextField(
                value = email,
                label = {
                    Text(text = "Enter your email")
                },
                onValueChange = { newValue ->
                    email = newValue
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                value = password,
                label = {
                    Text(text = "Enter your password")
                },
                onValueChange = { newValue ->
                    password = newValue
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = termsChecked,
                    onCheckedChange = { termsChecked = !termsChecked },
                )
                Text(text = "Accept the terms and conditions?")
            }
        }
    }
}

@Composable
fun OnboardingBottomAppBar() {
    BottomAppBar(containerColor = Color.White) {
        GymHubButton(text = "Continue") {
            // TODO
        }
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