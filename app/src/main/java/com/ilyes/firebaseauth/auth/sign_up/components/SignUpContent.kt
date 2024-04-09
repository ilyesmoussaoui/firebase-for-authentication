package com.ilyes.firebaseauth.auth.sign_up.components

import android.util.Patterns
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ilyes.firebaseauth.R
import com.ilyes.firebaseauth.util.Constants
import com.ilyes.firebaseauth.util.Constants.EMPTY_STRING
import com.ilyes.firebaseauth.util.comon.components.CustomDefaultBtn
import com.ilyes.firebaseauth.util.comon.components.CustomTextField
import com.ilyes.firebaseauth.util.comon.components.CustomTextFieldForEmail
import com.ilyes.firebaseauth.util.comon.components.CustomTextFieldForPassword
import com.ilyes.firebaseauth.util.comon.components.DefaultBackArrow
import com.ilyes.firebaseauth.util.comon.components.ErrorSuggestion


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SignUpContent(
    signUp: (email: String, password: String) -> Unit,
    navigateBack: () -> Unit
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
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = EMPTY_STRING
                )
            )
        }
    )
    val keyboard = LocalSoftwareKeyboardController.current
    var confirmPass by remember { mutableStateOf(TextFieldValue("")) }
    var firstName by remember { mutableStateOf(TextFieldValue("")) }
    var lastName by remember { mutableStateOf(TextFieldValue("")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
    var address by remember { mutableStateOf(TextFieldValue("")) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val conPasswordErrorState = remember { mutableStateOf(false) }
    val firstNameErrorState = remember { mutableStateOf(false) }
    val lastNameErrorState = remember { mutableStateOf(false) }
    val phoneNumberErrorState = remember { mutableStateOf(false) }
    val addressErrorState = remember { mutableStateOf(false) }
    val animate = remember { mutableStateOf(true) }


    AnimatedContent(targetState = animate.value, transitionSpec = {
        slideInHorizontally(
            initialOffsetX = { value ->
                value
            }
        ) togetherWith slideOutHorizontally(
            targetOffsetX = { value ->
                -value
            }
        )
    }) {
        if (it) {
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
                    Box(modifier = Modifier.weight(0.7f)) {
                        DefaultBackArrow {
                             //navController.popBackStack()
                        }
                    }
                    Box(modifier = Modifier.weight(1.0f)) {
                        Text(
                            text = "Sign Up",
                            color = MaterialTheme.colorScheme.scrim,
                            fontSize = 18.sp
                        )
                    }


                }
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "Register Account", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Complete your details or continue\nwith social media.",
                    color = MaterialTheme.colorScheme.scrim,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(50.dp))
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

                Spacer(modifier = Modifier.height(20.dp))
                CustomTextFieldForPassword(
                    placeholder = "********",
                    label = "Password",
                    errorState = passwordErrorState,
                    password = password,
                    onPasswordValueChange = { newValue ->
                        password = newValue
                    }
                )


                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    placeholder = "********",
                    trailingIcon = R.drawable.lock,
                    label = "Confirm Password",
                    keyboardType = KeyboardType.Password,
                    errorState = conPasswordErrorState,
                    visualTransformation = PasswordVisualTransformation(),
                    onChanged = { newPass ->
                        confirmPass = newPass
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))
                if (emailErrorState.value) {
                    ErrorSuggestion("Please enter valid email address.")
                }
                if (passwordErrorState.value) {
                    Row() {
                        ErrorSuggestion("Please enter valid password.")
                    }
                }
                if (conPasswordErrorState.value) {
                    ErrorSuggestion("Confirm Password miss matched.")
                }
                CustomDefaultBtn(
                    shapeSize = 50f,
                    btnText = "Continue",
                    {
                        //email pattern
                        val pattern = Patterns.EMAIL_ADDRESS
                        val isEmailValid = pattern.matcher(email.text).matches()
                        val isPassValid = password.text.length >= 8
                        val conPassMatch = password == confirmPass
                        emailErrorState.value = !isEmailValid
                        passwordErrorState.value = !isPassValid
                        conPasswordErrorState.value = !conPassMatch
                        if (isEmailValid && isPassValid && conPassMatch) {
                            animate.value = !animate.value
                        }
                    },
                ) {
                    //email pattern
                    val pattern = Patterns.EMAIL_ADDRESS
                    val isEmailValid = pattern.matcher(email.text).matches()
                    emailErrorState.value = !isEmailValid
                    if (isEmailValid) {
                        //navController.popBackStack()
                        //navController.navigate(AuthScreen.SignInScreen.route)
                    }
                }
                Text(
                    modifier = Modifier.clickable {
                        navigateBack()
                    },
                    text = Constants.ALREADY_USER,
                    color = MaterialTheme.colorScheme.scrim,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 10.dp,
                            alignment = Alignment.CenterHorizontally
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    MaterialTheme.colorScheme.secondary,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.google_icon),
                                contentDescription = "Google Login Icon"
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    MaterialTheme.colorScheme.secondary,
                                    shape = CircleShape
                                )
                                .clickable {

                                },
                            contentAlignment = Alignment.Center,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.twitter),
                                contentDescription = "Twitter Login Icon"
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    MaterialTheme.colorScheme.secondary,
                                    shape = CircleShape
                                )
                                .clickable {

                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.facebook_2),
                                contentDescription = "Facebook Login Icon"
                            )
                        }

                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                            .clickable {

                            },
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "By continuing you confirm that you agree",
                            color = MaterialTheme.colorScheme.scrim
                        )
                        Row()
                        {
                            Text(
                                text = "with our ",
                                color = MaterialTheme.colorScheme.scrim,
                            )
                            Text(
                                text = "Terms & Condition",
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.clickable {

                                })
                        }

                    }
                }


            }
        } else {
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
                    Box(modifier = Modifier.weight(0.7f)) {
                        DefaultBackArrow {
                            animate.value = !animate.value
                        }
                    }
                    Box(modifier = Modifier.weight(1.0f)) {
                        Text(
                            text = "Sign Up",
                            color = MaterialTheme.colorScheme.scrim,
                            fontSize = 18.sp
                        )
                    }


                }
                Spacer(modifier = Modifier.height(50.dp))
                Text(text = "Complete Profile", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Complete your details or continue\nwith social media.",
                    color = MaterialTheme.colorScheme.scrim,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(50.dp))
                CustomTextField(
                    placeholder = "Enter your first name",
                    trailingIcon = R.drawable.user,
                    label = "First Name",
                    errorState = firstNameErrorState,
                    keyboardType = KeyboardType.Text,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newText ->
                        firstName = newText
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    placeholder = "Enter your last name",
                    trailingIcon = R.drawable.user,
                    label = "Last Name",
                    errorState = lastNameErrorState,
                    keyboardType = KeyboardType.Text,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newText ->
                        lastName = newText
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    placeholder = "Enter your phone number",
                    trailingIcon = R.drawable.phone,
                    label = "Phone Number",
                    keyboardType = KeyboardType.Phone,
                    errorState = phoneNumberErrorState,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newNumber ->
                        phoneNumber = newNumber
                    }
                )


                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    placeholder = "example: Dhaka, Bangladesh",
                    trailingIcon = R.drawable.location_point,
                    label = "Address",
                    keyboardType = KeyboardType.Password,
                    errorState = addressErrorState,
                    visualTransformation = VisualTransformation.None,
                    onChanged = { newText ->
                        address = newText
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (firstNameErrorState.value || lastNameErrorState.value) {
                    ErrorSuggestion("Please enter valid name.")
                }
                if (phoneNumberErrorState.value) {
                    ErrorSuggestion("Please enter valid phone number.")
                }
                if (addressErrorState.value) {
                    ErrorSuggestion("Please enter valid address.")
                }

                CustomDefaultBtnForSignUp(shapeSize = 50f, btnText = "Continue",onClick = {
                    keyboard?.hide()
                    signUp(email.text, password.text)
                }) {
                    val isPhoneValid = phoneNumber.text.isEmpty() || phoneNumber.text.length < 4
                    val isFNameValid = firstName.text.isEmpty() || firstName.text.length < 3
                    val isLNameValid = lastName.text.isEmpty() || lastName.text.length < 3
                    val isAddressValid = address.text.isEmpty() || address.text.length < 5
                    firstNameErrorState.value = !isFNameValid
                    lastNameErrorState.value = !isLNameValid
                    addressErrorState.value = !isAddressValid
                    phoneNumberErrorState.value = !isPhoneValid
                    if (!isFNameValid && !isLNameValid && !isAddressValid && !isPhoneValid) {

                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .clickable {

                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "By continuing you confirm that you agree",
                        color = MaterialTheme.colorScheme.scrim
                    )
                    Row()
                    {
                        Text(
                            text = "with our ",
                            color = MaterialTheme.colorScheme.scrim,
                        )
                        Text(
                            text = "Terms & Condition",
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable {

                            })
                    }

                }
            }


        }
    }
}
@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpContent(
        signUp = { email, password -> /* Implement sign in logic */ },
        navigateBack = {}

    )
}



