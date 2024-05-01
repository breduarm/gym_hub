package com.beam.gymhubandroid.welcome.presentation.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.beam.gymhubandroid.R
import com.beam.gymhubandroid.welcome.domain.model.NavDestination.Authentication
import com.beam.gymhubandroid.welcome.domain.model.NavDestination.Onboarding
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeScreenContent(navController = navController)
}

@Composable
fun WelcomeScreenContent(navController: NavController) {
    Scaffold(
        topBar = {
            WelcomeTopAppBar {
                navController.navigate(Authentication.route)
            }
        },
        bottomBar = {
            WelcomeBottomAppBar(navController)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            WelcomeLogo(modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            WelcomeIllustration(modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(32.dp))
            WelcomeMessage(modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
fun WelcomeLogo(modifier: Modifier) {
    Icon(
        imageVector = Icons.Default.Face,
        contentDescription = "App logo",
        modifier = modifier.size(50.dp)
    )
}

@Composable
fun WelcomeIllustration(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Welcome illustration",
        modifier = modifier
            .padding(horizontal = 24.dp)
            .size(350.dp)
    )
}

@Composable
fun WelcomeMessage(modifier: Modifier) {
    Text(
        text = "Welcome to your personalized training center!",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
        modifier = modifier.padding(horizontal = 24.dp),
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Your new ally o take your workouts to the next level",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        modifier = modifier.padding(horizontal = 24.dp)
    )
}

@Composable
fun GymHubButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(text = text)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeTopAppBar(onClickLogin: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = "Welcome")
        },
        actions = {
            TextButton(onClick = onClickLogin) {
                Text(text = "Login")
            }
        }
    )
}

@Composable
fun WelcomeBottomAppBar(navController: NavController) {
    BottomAppBar(containerColor = Color.White) {
        GymHubButton(text = "Start") {
            navController.navigate(Onboarding.route)
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun WelcomeScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        WelcomeScreen(NavController(context))
    }
}