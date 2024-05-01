package com.beam.gymhubandroid.onboarding.presentation.congratulations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.beam.gymhubandroid.R
import com.beam.gymhubandroid.onboarding.presentation.newuser.OnboardingBottomAppBar
import com.beam.gymhubandroid.onboarding.presentation.tour.OnboardingTopAppBar
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun CongratulationsScreen(navController: NavController) {
    CongratulationsScreenContent(navController)
}

@Composable
fun CongratulationsScreenContent(navController: NavController) {
    Scaffold(
        topBar = {
            OnboardingTopAppBar(showSkip = false, onClickBackNav = { navController.popBackStack() })
        },
        bottomBar = {
            OnboardingBottomAppBar(title = "Finish", canContinue = true) {
                // TODO go to Home screen
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Congratulations illustration",
                modifier = Modifier.size(250.dp)
            )
            Text(
                text = "Congratulations on taking the first step towards a healthier lifestyle with GymHub. \nLet's make every workout count!",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 32.dp)
            )
            Text(
                text = LoremIpsum(10).values.first(),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
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