package com.beam.gymhubandroid.authentication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beam.gymhubandroid.authentication.domain.model.NavDestination.Login
import com.beam.gymhubandroid.authentication.presentation.login.LoginScreen

@Composable
fun AuthenticationNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login.route) {
        composable(route = Login.route) { LoginScreen() }
    }
}