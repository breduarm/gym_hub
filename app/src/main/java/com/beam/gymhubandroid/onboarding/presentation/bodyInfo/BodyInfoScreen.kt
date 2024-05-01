package com.beam.gymhubandroid.onboarding.presentation.bodyInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.Goal
import com.beam.gymhubandroid.onboarding.presentation.newuser.OnboardingBottomAppBar
import com.beam.gymhubandroid.onboarding.presentation.tour.OnboardingTopAppBar
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun BodyInfoScreen(navController: NavController) {
    BodyInfoScreenContent(navController)
}

@Composable
fun BodyInfoScreenContent(navController: NavController) {
    var canContinue by remember { mutableStateOf(false) }
    var height by remember { mutableFloatStateOf(0f) }
    var weight by remember { mutableFloatStateOf(0f) }
    Scaffold(
        topBar = {
            OnboardingTopAppBar(showSkip = false, onClickBackNav = {
                navController.popBackStack()
            })
        },
        bottomBar = {
            OnboardingBottomAppBar(canContinue = canContinue) {
                navController.navigate(Goal.route)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            TextField(
                value = height.toString(),
                label = {
                    Text(text = "Enter your height")
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                onValueChange = { newValue ->
                    height = newValue.toFloat()
                    canContinue = isFormValid(height, weight)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                value = weight.toString(),
                label = {
                    Text(text = "Enter your weight")
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                onValueChange = { newValue ->
                    weight = newValue.toFloat()
                    canContinue = isFormValid(height, weight)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

fun isFormValid(height: Float, weight: Float): Boolean {
    val isHeightValid = height > 0f
    val isWeightValid = weight > 0f
    return isHeightValid && isWeightValid
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun BodyInfoScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        BodyInfoScreen(NavController(context))
    }
}