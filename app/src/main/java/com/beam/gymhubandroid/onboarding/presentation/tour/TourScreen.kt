package com.beam.gymhubandroid.onboarding.presentation.tour

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.beam.gymhubandroid.R
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.NewUser
import com.beam.gymhubandroid.ui.theme.GymHubTheme
import com.beam.gymhubandroid.welcome.presentation.welcome.GymHubButton

@Composable
fun TourScreen(navController: NavController) {
    TourScreenContent(navController)
}

@Composable
fun TourScreenContent(navController: NavController) {
    var canContinue by rememberSaveable { mutableStateOf(false) }
    var sliderImgIndex by rememberSaveable { mutableIntStateOf(0) }
    var progress by rememberSaveable { mutableFloatStateOf(1f / sliderImgResList.size) }

    Scaffold(
        topBar = {
            OnboardingTopAppBar(
                title = "Tour",
                showSkip = !canContinue,
                onClickBackNav = {
                    navController.popBackStack()
                },
                onClickSkip = {
                    goToNextScreen(navController)
                }
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.White) {
                if (canContinue) {
                    GymHubButton(text = "Continue") {
                        goToNextScreen(navController)
                    }
                } else {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (sliderImgIndex > 0) {
                            SliderTourControlButton(
                                text = "Previous",
                                modifier = Modifier.weight(1f)
                            ) {
                                sliderImgIndex =
                                    getPreviousSliderImgResIndex(currentIndex = sliderImgIndex)
                                progress = (sliderImgIndex + 1f) / sliderImgResList.size
                                canContinue = sliderImgIndex == sliderImgResList.size - 1
                            }
                        }
                        SliderTourControlButton(text = "Next", modifier = Modifier.weight(1f)) {
                            sliderImgIndex = getNextSliderImgResIndex(currentIndex = sliderImgIndex)
                            progress = (sliderImgIndex + 1f) / sliderImgResList.size
                            canContinue = sliderImgIndex == sliderImgResList.size - 1
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LinearProgressIndicator(progress = progress, modifier = Modifier.fillMaxWidth())
            Image(
                painter = painterResource(id = sliderImgResList[sliderImgIndex]),
                contentDescription = "Illustration",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 24.dp, vertical = 40.dp)
            )
        }
    }
}

@Composable
fun SliderTourControlButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier.padding(horizontal = 24.dp)
    ) {
        Text(text = text)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingTopAppBar(
    title: String = "",
    showSkip: Boolean,
    onClickBackNav: () -> Unit,
    onClickSkip: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = { onClickBackNav() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back")
            }
        },
        actions = {
            if (showSkip) {
                TextButton(onClick = { onClickSkip?.invoke() }) {
                    Text(text = "Skip")
                }
            }
        }
    )
}

val sliderImgResList = listOf(
    R.drawable.ic_launcher_background,
    R.drawable.ic_launcher_background,
    R.drawable.ic_launcher_background,
)

fun getNextSliderImgResIndex(currentIndex: Int): Int =
    if (currentIndex < sliderImgResList.size - 1) currentIndex + 1 else 0

fun getPreviousSliderImgResIndex(currentIndex: Int): Int =
    if (currentIndex > 0) currentIndex - 1 else sliderImgResList.size - 1

fun goToNextScreen(navController: NavController) {
    navController.navigate(NewUser.route)
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun TourScreenPreview() {
    val context = LocalContext.current
    GymHubTheme {
        TourScreen(NavHostController(context))
    }
}