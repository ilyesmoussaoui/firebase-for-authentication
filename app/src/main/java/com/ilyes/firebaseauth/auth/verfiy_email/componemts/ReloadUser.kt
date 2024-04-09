package com.ilyes.firebaseauth.auth.verfiy_email.componemts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilyes.firebaseauth.auth.home.HomeViewModel
import com.ilyes.firebaseauth.domain.model.Response
import com.ilyes.firebaseauth.util.comon.components.ProgressBar


@Composable
fun ReloadUser(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToProfileScreen: () -> Unit
) {
    when(val reloadUserResponse = viewModel.reloadUserResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> {
            val isUserReloaded = reloadUserResponse.data
            LaunchedEffect(isUserReloaded) {
                if (isUserReloaded) {
                    navigateToProfileScreen()
                }
            }
        }
        is Response.Failure -> reloadUserResponse.apply {
            LaunchedEffect(e) {
                print(e)
            }
        }
    }
}