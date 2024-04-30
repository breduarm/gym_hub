package com.beam.gymhubandroid.welcome.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beam.gymhubandroid.authentication.presentation.navigation.AuthenticationNavGraph
import com.beam.gymhubandroid.welcome.domain.model.NavDestination.Authentication
import com.beam.gymhubandroid.welcome.domain.model.NavDestination.Onboarding
import com.beam.gymhubandroid.welcome.domain.model.NavDestination.Splash
import com.beam.gymhubandroid.welcome.domain.model.NavDestination.Welcome
import com.beam.gymhubandroid.onboarding.presentation.navigation.OnboardingNavGraph
import com.beam.gymhubandroid.welcome.presentation.splash.SplashScreen
import com.beam.gymhubandroid.welcome.presentation.welcome.WelcomeScreen

@Composable
fun WelcomeNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Welcome.route) {
        composable(route = Splash.route) {SplashScreen() }
        composable(route = Welcome.route) { WelcomeScreen(navController = navController) }
        composable(route = Authentication.route) { AuthenticationNavGraph() }
        composable(route = Onboarding.route) { OnboardingNavGraph() }
    }
}