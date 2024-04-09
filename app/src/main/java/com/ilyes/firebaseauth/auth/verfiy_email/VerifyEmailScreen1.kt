package com.ilyes.firebaseauth.auth.verfiy_email

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilyes.firebaseauth.auth.home.HomeViewModel
import com.ilyes.firebaseauth.util.Constants
import com.ilyes.firebaseauth.util.Constants.VERIFY_EMAIL_SCREEN
import com.ilyes.firebaseauth.R
import com.ilyes.firebaseauth.auth.verfiy_email.componemts.ReloadUser
import com.ilyes.firebaseauth.util.Constants.EMAIL_NOT_VERIFIED_MESSAGE
import com.ilyes.firebaseauth.util.Utils.Companion.showMessage
import com.ilyes.firebaseauth.util.comon.components.CustomDefaultBtn


@Composable
fun VerifyEmailScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToProfileScreen: () -> Unit



) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = VERIFY_EMAIL_SCREEN,
                color = MaterialTheme.colorScheme.scrim,
                fontWeight = FontWeight(700),
                fontSize = 15.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.success),
            contentDescription = "Login Success Image"
        )
        Text(
            modifier = Modifier.clickable {
                viewModel.reloadUser()
            },
            text = Constants.ALREADY_VERIFIED,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(textDecoration = TextDecoration.Underline),

            )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = Constants.SPAM_EMAIL,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(50.dp))


    }
    ReloadUser(
        navigateToProfileScreen = {
            if (viewModel.isEmailVerified) {
                navigateToProfileScreen()
            } else {
                showMessage(context, EMAIL_NOT_VERIFIED_MESSAGE)
            }
        }
    )


}
