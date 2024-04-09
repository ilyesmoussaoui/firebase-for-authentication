package com.ilyes.firebaseauth.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.ilyes.firebaseauth.data.repository.AuthRepositoryImpl
import com.ilyes.firebaseauth.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class AppModule {
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl(
        auth = Firebase.auth
    )
}