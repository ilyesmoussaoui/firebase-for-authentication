package com.ilyes.firebaseauth.auth.sign_in

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilyes.firebaseauth.auth.sign_in.components.SignIn
import com.ilyes.firebaseauth.auth.sign_in.components.SignInContent
import com.ilyes.firebaseauth.util.Utils.Companion.showMessage


@SuppressLint("SuspiciousIndentation")
@Composable
@ExperimentalComposeUiApi
fun SignInScreen(
    viewModel: SignInViewModel = hiltViewModel(),
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit,
) {
    val context = LocalContext.current




            SignInContent(
                signIn = { email, password ->
                    viewModel.signInWithEmailAndPassword(email, password)
                },
                navigateToForgotPasswordScreen = navigateToForgotPasswordScreen,
                navigateToSignUpScreen = navigateToSignUpScreen
            )



    SignIn(
        showErrorMessage = { errorMessage ->
            showMessage(context, errorMessage)
        }
    )
}

