package com.ilyes.firebaseauth.auth.sign_up

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilyes.firebaseauth.auth.sign_up.components.SendEmailVerification
import com.ilyes.firebaseauth.auth.sign_up.components.SignUp
import com.ilyes.firebaseauth.auth.sign_up.components.SignUpContent
import com.ilyes.firebaseauth.util.Constants.VERIFY_EMAIL_MESSAGE
import com.ilyes.firebaseauth.util.Utils.Companion.showMessage


@SuppressLint("SuspiciousIndentation")
@Composable
@ExperimentalComposeUiApi
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val context = LocalContext.current



            SignUpContent(

                signUp = { email, password ->
                    viewModel.signUpWithEmailAndPassword(email, password)
                },
                navigateBack = navigateBack
            )



    SignUp(
        sendEmailVerification = {
            viewModel.sendEmailVerification()
        },
        showVerifyEmailMessage = {
            showMessage(context, VERIFY_EMAIL_MESSAGE)
        }
    )

    SendEmailVerification()
}