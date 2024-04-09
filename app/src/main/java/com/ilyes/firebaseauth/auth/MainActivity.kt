package com.ilyes.firebaseauth.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ilyes.firebaseauth.ui.theme.FirebaseAuthTheme
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.firebasesigninwithemailandpassword.navigation.NavGraph
import ro.alexmamo.firebasesigninwithemailandpassword.navigation.Screen
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModel by viewModels<MainViewModel>()
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseAuthTheme {
                navController = rememberNavController()
                NavGraph(
                    navController = navController
                )
                AuthState()
            }
        }
    }

        @Composable
        private fun AuthState() {
            val isUserSignedOut = viewModel.getAuthState().collectAsState().value
            if (isUserSignedOut) {
                NavigateToSignInScreen()
            } else {
                if (viewModel.isEmailVerified) {
                    NavigateToProfileScreen()
                } else {
                    NavigateToVerifyEmailScreen()
                }
            }
        }

        @Composable
        private fun NavigateToSignInScreen() = navController.navigate(Screen.SignInScreen.route) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }

        @Composable
        private fun NavigateToProfileScreen() = navController.navigate(Screen.HomeScreen.route) {
            popUpTo(navController.graph.id) {
                inclusive = true
            }
        }

        @Composable
        private fun NavigateToVerifyEmailScreen() =
            navController.navigate(Screen.VerifyEmailScreen.route) {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
    }
