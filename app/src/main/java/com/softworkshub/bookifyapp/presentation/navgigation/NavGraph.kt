package com.softworkshub.bookifyapp.presentation.navgigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.softworkshub.bookifyapp.presentation.authpage.login.LoginScreen
import com.softworkshub.bookifyapp.presentation.authpage.sign.SignUpScreen

@Composable
fun NavGraph(
    startDestination : String,
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Screen.AppStartNavigation.route,
            startDestination = Screen.LoginPage.route
        ){
            composable(route = Screen.LoginPage.route){
                LoginScreen(
                    navController = navController,
                    onLoginSuccess ={
                        navController.navigate(Screen.AppNavigator.route) {
                            // Remove login screen from backstack after successful login
                            popUpTo(Screen.LoginPage.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(route = Screen.SignUp.route){
                SignUpScreen(
                    navController = navController,
                    onSignUpSuccess = {
                        navController.navigate(Screen.AppNavigator.route){
                            popUpTo(Screen.SignUp.route){inclusive = true}
                        }
                    }
                )
            }
        }

        navigation(
            route = Screen.AppNavigator.route,
            startDestination = Screen.AppNavigator.route
        ){
            composable(route = Screen.AppNavigator.route){
                AppNavigator()
            }
        }
    }
}