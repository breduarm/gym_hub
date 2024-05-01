package com.beam.gymhubandroid.onboarding.presentation.newuser

import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.Authentication
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.PersonalInfo
import com.beam.gymhubandroid.onboarding.presentation.tour.OnboardingTopAppBar
import com.beam.gymhubandroid.ui.theme.GymHubTheme
import com.beam.gymhubandroid.welcome.presentation.welcome.AppLogo
import com.beam.gymhubandroid.welcome.presentation.welcome.GymHubButton

@Composable
fun NewUserScreen(navController: NavController) {
    NewUserScreenContent(navController)
}

@Composable
fun NewUserScreenContent(navController: NavController) {
    var canContinue by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var termsChecked by rememberSaveable { mutableStateOf(false) }
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            OnboardingTopAppBar(
                title = "New User",
                showSkip = false,
                onClickBackNav = {
                    navController.popBackStack()
                }
            )
        },
        bottomBar = {
            OnboardingBottomAppBar(canContinue = canContinue) {
                navController.navigate(PersonalInfo.route)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            AppLogo(modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(48.dp))
            TextField(
                value = email,
                label = {
                    Text(text = "Enter your email")
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                onValueChange = { newValue ->
                    email = newValue
                    canContinue = isFormValid(email, password, termsChecked)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                value = password,
                label = {
                    Text(text = "Enter your password")
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { newValue ->
                    password = newValue
                    canContinue = isFormValid(email, password, termsChecked)
                },
                trailingIcon = {
                    val icon = if (passwordVisibility) {
                        Icons.Filled.VisibilityOff
                    } else {
                        Icons.Filled.Visibility
                    }
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(imageVector = icon, contentDescription = "password visibility")
                    }
                },
                visualTransformation = if (passwordVisibility) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Do you already have an account?",
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.End)
            )
            TextButton(
                onClick = {
                    navController.navigate(Authentication.route)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "Login",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = termsChecked,
                    onCheckedChange = {
                        termsChecked = !termsChecked
                        canContinue = isFormValid(email, password, termsChecked)
                    },
                )
                Text(text = "Accept the terms and conditions?")
            }
        }
    }
}

@Composable
fun OnboardingBottomAppBar(
    canContinue: Boolean,
    onClickContinue: () -> Unit
) {
    BottomAppBar(containerColor = Color.White) {
        GymHubButton(
            text = "Continue",
            enabled = canContinue,
            onClick = onClickContinue
        )
    }
}

fun isFormValid(email: String, password: String, termsAccepted: Boolean): Boolean {
    val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordValid = password.length >= 6
    return isEmailValid && isPasswordValid && termsAccepted
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun NewUserScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        NewUserScreen(NavController(context))
    }
}