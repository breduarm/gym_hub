package com.beam.gymhubandroid.onboarding.presentation.personalInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.BodyInfo
import com.beam.gymhubandroid.onboarding.presentation.newuser.OnboardingBottomAppBar
import com.beam.gymhubandroid.onboarding.presentation.tour.OnboardingTopAppBar
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun PersonalInfoScreen(navController: NavController) {
    PersonalInfoScreenContent(navController)
}

@Composable
fun PersonalInfoScreenContent(navController: NavController) {
    var canContinue by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var birthday by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            OnboardingTopAppBar(
                title = "Personal Information",
                showSkip = false,
                onClickBackNav = {
                    navController.popBackStack()
                }
            )
        },
        bottomBar = {
            OnboardingBottomAppBar(canContinue = canContinue) {
                navController.navigate(BodyInfo.route)
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
                value = name,
                label = {
                    Text(text = "Enter your name")
                },
                maxLines = 1,
                singleLine = true,
                onValueChange = { newValue ->
                    name = newValue
                    canContinue = isFormValid(name, surname, birthday, genre)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                value = surname,
                label = {
                    Text(text = "Enter your surname")
                },
                maxLines = 1,
                singleLine = true,
                onValueChange = { newValue ->
                    surname = newValue
                    canContinue = isFormValid(name, surname, birthday, genre)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                value = birthday,
                label = {
                    Text(text = "Enter your birthday")
                },
                maxLines = 1,
                singleLine = true,
                onValueChange = { newValue ->
                    birthday = newValue
                    canContinue = isFormValid(name, surname, birthday, genre)
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            TextField(
                value = genre,
                label = {
                    Text(text = "Enter your Genre")
                },
                maxLines = 1,
                singleLine = true,
                onValueChange = { newValue ->
                    genre = newValue
                    canContinue = isFormValid(name, surname, birthday, genre)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

fun isFormValid(name: String, surname: String, birthday: String, genre: String): Boolean {
    val isNameValid = name.length >= 6
    val isSurnameValid = surname.length >= 6
    val isBirthdayValid = birthday.length >= 6
    val isGenreValid = genre.length >= 6
    return isNameValid && isSurnameValid && isBirthdayValid && isGenreValid
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun PersonalInfoScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        PersonalInfoScreen(NavController(context))
    }
}