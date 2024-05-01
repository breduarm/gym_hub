package com.beam.gymhubandroid.onboarding.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.BodyInfo
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.Congratulation
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.Goal
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.NewUser
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.PersonalInfo
import com.beam.gymhubandroid.onboarding.domain.model.NavDestination.Tour
import com.beam.gymhubandroid.onboarding.presentation.newuser.NewUserScreen
import com.beam.gymhubandroid.onboarding.presentation.tour.TourScreen

@Composable
fun OnboardingNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Tour.route) {
        composable(route = Tour.route) { TourScreen(navController) }
        composable(route = NewUser.route) { NewUserScreen(navController) }
        composable(route = PersonalInfo.route) { TourScreen(navController) }
        composable(route = BodyInfo.route) { TourScreen(navController) }
        composable(route = Goal.route) { TourScreen(navController) }
        composable(route = Congratulation.route) { TourScreen(navController) }
    }
}