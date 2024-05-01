package com.beam.gymhubandroid.onboarding.domain.model

sealed class NavDestination(val route: String) {
    data object Tour : NavDestination("tour")
    data object NewUser : NavDestination("new_user")
    data object PersonalInfo : NavDestination("personal_info")
    data object BodyInfo : NavDestination("body_info")
    data object Goal : NavDestination("goal")
    data object Congratulation : NavDestination("congratulation")
}