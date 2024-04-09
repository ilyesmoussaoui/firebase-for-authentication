package com.ilyes.firebaseauth.auth.forgot_password

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilyes.firebaseauth.auth.forgot_password.components.ForgotPassword
import com.ilyes.firebaseauth.auth.forgot_password.components.ForgotPasswordContent
import com.ilyes.firebaseauth.util.Constants.RESET_PASSWORD_MESSAGE
import com.ilyes.firebaseauth.util.Utils.Companion.showMessage


@SuppressLint("SuspiciousIndentation")
@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val context = LocalContext.current




            ForgotPasswordContent(

                sendPasswordResetEmail = { email ->
                    viewModel.sendPasswordResetEmail(email)
                }
            )



    ForgotPassword(
        navigateBack = navigateBack,
        showResetPasswordMessage = {
            showMessage(context, RESET_PASSWORD_MESSAGE)
        },
        showErrorMessage = { errorMessage ->
            showMessage(context, errorMessage)
        }
    )
}