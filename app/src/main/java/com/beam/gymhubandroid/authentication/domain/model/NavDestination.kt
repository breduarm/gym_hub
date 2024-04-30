package com.beam.gymhubandroid.authentication.domain.model

sealed class NavDestination(val route: String) {
    data object Login : NavDestination("login")
}