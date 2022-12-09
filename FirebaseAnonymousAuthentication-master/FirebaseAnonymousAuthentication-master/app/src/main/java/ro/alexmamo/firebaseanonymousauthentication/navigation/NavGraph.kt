package ro.alexmamo.firebaseanonymousauthentication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ro.alexmamo.firebaseanonymousauthentication.navigation.Screen.AuthScreen
import ro.alexmamo.firebaseanonymousauthentication.navigation.Screen.ProfileScreen
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.AuthScreen
import ro.alexmamo.firebaseanonymousauthentication.presentation.profile.ProfileScreen

@Composable
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthScreen.route
    ) {
        composable(
            route = AuthScreen.route
        ) {
            AuthScreen(
                navigateToProfileScreen = {
                    navController.navigate(ProfileScreen.route)
                }
            )
        }
        composable(
            route = ProfileScreen.route
        ) {
            ProfileScreen(
                navigateToAuthScreen = {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.route)
                }
            )
        }
    }
}