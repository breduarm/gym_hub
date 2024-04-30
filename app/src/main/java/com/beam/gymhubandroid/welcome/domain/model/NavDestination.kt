package com.beam.gymhubandroid.welcome.domain.model

sealed class NavDestination(val route: String) {
    data object Splash : NavDestination("splash")
    data object Welcome : NavDestination("welcome")
    data object Authentication : NavDestination("authentication")
    data object Onboarding : NavDestination("onboarding")
}