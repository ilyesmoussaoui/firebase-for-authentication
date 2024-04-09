package com.ilyes.firebaseauth.auth.home

import android.util.Patterns
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilyes.firebaseauth.auth.sign_in.components.CustomDefaultBtnForSignIn
import com.ilyes.firebaseauth.util.comon.components.CustomDefaultBtn
import com.ilyes.firebaseauth.util.comon.components.CustomDefaultBtnForSignOut

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    Text(text = "Hi mother fucker")
    CustomDefaultBtnForSignOut(
        shapeSize = 50f,
        btnText = "Sign Out",
        onClick = {
            viewModel.signOut() // Call signOut function from the viewModel
        }
    )


}

