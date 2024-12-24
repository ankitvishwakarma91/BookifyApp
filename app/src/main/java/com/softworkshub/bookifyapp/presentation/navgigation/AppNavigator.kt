package com.softworkshub.bookifyapp.presentation.navgigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.softworkshub.bookifyapp.R
import com.softworkshub.bookifyapp.presentation.authpage.common.AppBar
import com.softworkshub.bookifyapp.presentation.booking.BookingScreen
import com.softworkshub.bookifyapp.presentation.explore.ExploreScreen
import com.softworkshub.bookifyapp.presentation.home.HomeScreen
import com.softworkshub.bookifyapp.presentation.profile.ProfileScreen

@Composable
fun AppNavigator() {

    val bottomNavigation = remember {
         listOf(
            BottomNav(
                icon = R.drawable.baseline_home_24,
                text = R.string.home,
            ),

            BottomNav(
                icon = R.drawable.baseline_explore_24,
                text = R.string.explore,
            ),
            BottomNav(
                icon = R.drawable.baseline_apps_24,
                text = R.string.bookings,
            ),
            BottomNav(
                icon = R.drawable.baseline_person_24,
                text = R.string.profile,
            ),
        )
    }

    val navController = rememberNavController()

    val backStackState = navController.currentBackStackEntryAsState().value

    var selectedItem by remember {
        mutableStateOf(0)
    }

    selectedItem = when (backStackState?.destination?.route) {
        Screen.HomeScreen.route -> 0
        Screen.ExploreScreen.route -> 1
        Screen.BookingScreen.route -> 2
        Screen.ProfileScreen.route -> 3
        else -> 0
    }

    val isTopAppBarVisible = remember(key1 = backStackState) {
        backStackState?.destination?.route == Screen.HomeScreen.route ||
                backStackState?.destination?.route == Screen.ExploreScreen.route ||
                backStackState?.destination?.route == Screen.BookingScreen.route
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (isTopAppBarVisible) {
                AppBar()
            }
        },
        bottomBar = {
            BottomNavigationView(
                items = bottomNavigation,
                selected = selectedItem,
                onSelectedItem = {idx ->
                    when(idx) {
                        0 -> navigateToTab(
                            route = Screen.HomeScreen.route,
                            navController = navController,
                        )
                        1 -> navigateToTab(
                            route = Screen.ExploreScreen.route,
                            navController = navController
                        )
                        2 -> navigateToTab(
                            route = Screen.BookingScreen.route,
                            navController = navController
                        )
                        3 -> navigateToTab(
                            route = Screen.ProfileScreen.route,
                            navController = navController
                        )
                    }
                }
            )
        }
    ) {
        val padding = it.calculateBottomPadding()
        
        NavHost(
            navController = navController,
            startDestination = Screen.HomeScreen.route,
            modifier = Modifier.padding(bottom = padding),
        ){
            composable(route = Screen.HomeScreen.route){
                HomeScreen()
            }
            composable(route = Screen.ExploreScreen.route){
                ExploreScreen()
            }
            composable(route = Screen.BookingScreen.route){
                BookingScreen()
            }
            composable(route = Screen.ProfileScreen.route){
                ProfileScreen()
            }
        }
    }
}

fun navigateToTab(route: String, navController: NavHostController) {
    navController.navigate(route = route){
        navController.graph.startDestinationRoute?.let { homeScreen ->
            popUpTo(homeScreen){
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}
