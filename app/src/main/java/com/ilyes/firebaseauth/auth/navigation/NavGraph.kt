package ro.alexmamo.firebasesigninwithemailandpassword.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ilyes.firebaseauth.auth.forgot_password.ForgotPasswordScreen
import com.ilyes.firebaseauth.auth.home.HomeScreen
import com.ilyes.firebaseauth.auth.sign_in.SignInScreen
import com.ilyes.firebaseauth.auth.sign_up.SignUpScreen
import com.ilyes.firebaseauth.auth.verfiy_email.VerifyEmailScreen

import ro.alexmamo.firebasesigninwithemailandpassword.navigation.Screen.ForgotPasswordScreen
import ro.alexmamo.firebasesigninwithemailandpassword.navigation.Screen.SignInScreen
import ro.alexmamo.firebasesigninwithemailandpassword.navigation.Screen.SignUpScreen
import ro.alexmamo.firebasesigninwithemailandpassword.navigation.Screen.VerifyEmailScreen


@Composable
@ExperimentalComposeUiApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SignInScreen.route
    ) {
        composable(
            route = SignInScreen.route
        ) {
            SignInScreen(
                navigateToForgotPasswordScreen = {
                    navController.navigate(ForgotPasswordScreen.route)
                },
                navigateToSignUpScreen = {
                    navController.navigate(SignUpScreen.route)
                }
            )
        }
        composable(
            route = ForgotPasswordScreen.route
        ) {
            ForgotPasswordScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = SignUpScreen.route
        ) {
            SignUpScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = VerifyEmailScreen.route
        ) {
            VerifyEmailScreen(
                navigateToProfileScreen = {
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen()
        }
    }
}