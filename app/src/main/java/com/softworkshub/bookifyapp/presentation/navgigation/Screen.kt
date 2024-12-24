package com.softworkshub.bookifyapp.presentation.navgigation

sealed class Screen(
    val route : String,
) {

    data object LoginPage : Screen(route = "login_screen")
    data object SignUp : Screen(route = "signup_screen")
    data object HomeScreen : Screen(route = "home_screen")
    data object BookingScreen : Screen(route = "booking_screen")
    data object ExploreScreen : Screen(route = "explore_screen")
    data object ProfileScreen : Screen(route = "profile_screen")
    data object AppNavigator : Screen(route = "app_navigator")
    data object AppStartNavigation : Screen(route = "app_start_navigation")

}