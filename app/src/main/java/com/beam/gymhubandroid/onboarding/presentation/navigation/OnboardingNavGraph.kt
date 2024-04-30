package com.beam.gymhubandroid.onboarding.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.Tour
import com.beam.gymhubandroid.onboarding.presentation.tour.TourScreen

@Composable
fun OnboardingNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Tour.route) {
        composable(route = Tour.route) { TourScreen() }
    }
}