package com.beam.gymhubandroid.onboarding.presentation.goal

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.beam.gymhubandroid.R
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.Congratulations
import com.beam.gymhubandroid.onboarding.presentation.tour.OnboardingTopAppBar
import com.beam.gymhubandroid.ui.theme.GymHubTheme

@Composable
fun GoalScreen(navController: NavController) {
    GoalScreenContent(navController)
}

@Composable
fun GoalScreenContent(navController: NavController) {
    Scaffold(
        topBar = {
            OnboardingTopAppBar(
                showSkip = false,
                onClickBackNav = { navController.popBackStack() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            GoalCardItem(
                title = "Gain weight",
                description = LoremIpsum(8).values.first(),
                imgRes = R.drawable.ic_launcher_background,
                onClick = { navController.navigate(Congratulations.route) }
            )
            GoalCardItem(
                title = "Maintain",
                description = LoremIpsum(8).values.first(),
                imgRes = R.drawable.ic_launcher_background,
                onClick = { navController.navigate(Congratulations.route) }
            )
            GoalCardItem(
                title = "Lose weight",
                description = LoremIpsum(8).values.first(),
                imgRes = R.drawable.ic_launcher_background,
                onClick = { navController.navigate(Congratulations.route) }
            )
        }
    }
}

@Composable
fun GoalCardItem(
    title: String,
    description: String,
    @DrawableRes imgRes: Int,
    onClick: () -> Unit,
) {
    Card(modifier = Modifier.clickable { onClick() }) {
        Row(modifier = Modifier.padding(24.dp)) {
            Image(
                painter = painterResource(id = imgRes),
                contentDescription = "Goal image"
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = title, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
                Text(text = description, modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GoalScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        GoalScreen(NavController(context))
    }
}