package com.beam.gymhubandroid.onboarding.domain.model

sealed class NavDestination(val route: String) {
    data object Tour : NavDestination("tour")
}