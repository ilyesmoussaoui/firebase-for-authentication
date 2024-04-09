package com.ilyes.firebaseauth.auth.forgot_password.components

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilyes.firebaseauth.R
import com.ilyes.firebaseauth.util.Constants.EMPTY_STRING
import com.ilyes.firebaseauth.util.comon.components.CustomDefaultBtn
import com.ilyes.firebaseauth.util.comon.components.CustomTextFieldForEmail
import com.ilyes.firebaseauth.util.comon.components.DefaultBackArrow


@Composable
fun ForgotPasswordContent(
    sendPasswordResetEmail: (email: String) -> Unit,

    ) {
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = EMPTY_STRING
                )
            )
        }
    )
    val emailErrorState = remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {

            Box(modifier = Modifier.weight(0.3f)) {
                DefaultBackArrow() {
                    //navController.popBackStack()
                }
            }
            Box(modifier = Modifier.weight(1.0f)) {
                Text(
                    text = "Forget Password",
                    color = MaterialTheme.colorScheme.scrim,
                    fontSize = 18.sp
                )
            }


        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Forget Password", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "Please enter your email and we will send\nyou a link to return your account",
            color = MaterialTheme.colorScheme.scrim,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(150.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            CustomTextFieldForEmail(
                placeholder = "example@email.com",
                trailingIcon = R.drawable.mail,
                label = "Email",
                errorState = emailErrorState,
                keyboardType = KeyboardType.Email,
                visualTransformation = VisualTransformation.None,
                email = email,
                onEmailValueChange = { newValue ->
                    email = newValue
                }
            )

            CustomDefaultBtn(shapeSize = 50f, btnText = "Continue",onClick = {
                sendPasswordResetEmail(email.text)
            }) {
                //email pattern
                val pattern = Patterns.EMAIL_ADDRESS
                val isEmailValid = pattern.matcher(email.text).matches()
                emailErrorState.value = !isEmailValid
                if (isEmailValid) {
                    //navController.popBackStack()
                    //navController.navigate(AuthScreen.SignInScreen.route)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp, bottom = 30.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Don't have an account? ", color = MaterialTheme.colorScheme.scrim)
                Text(
                    text = "Sign Up",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        //navController.navigate(AuthScreen.SignUpScreen.route)
                    })
            }
        }


    }
}