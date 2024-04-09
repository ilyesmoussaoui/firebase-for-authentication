package ro.alexmamo.firebasesigninwithemailandpassword.navigation

import com.ilyes.firebaseauth.util.Constants.FORGOT_PASSWORD_SCREEN
import com.ilyes.firebaseauth.util.Constants.Home_Screen
import com.ilyes.firebaseauth.util.Constants.SIGN_IN_SCREEN
import com.ilyes.firebaseauth.util.Constants.SIGN_UP_SCREEN
import com.ilyes.firebaseauth.util.Constants.VERIFY_EMAIL_SCREEN


sealed class Screen(val route: String) {
    object SignInScreen: Screen(SIGN_IN_SCREEN)
    object ForgotPasswordScreen: Screen(FORGOT_PASSWORD_SCREEN)
    object SignUpScreen: Screen(SIGN_UP_SCREEN)
    object VerifyEmailScreen: Screen(VERIFY_EMAIL_SCREEN)
    object HomeScreen: Screen(Home_Screen)
}