package com.petplace.thatpetplace.di



import com.google.firebase.auth.FirebaseAuth
import com.petplace.thatpetplace.auth.data.AuthRepositoryImpl

import com.petplace.thatpetplace.auth.presentation.login.LoginViewModel
import com.petplace.thatpetplace.auth.presentation.signup.SigUpViewModel
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.homeScreen.navigation.NavigationViewModel
import com.petplace.thatpetplace.homeScreen.presentation.HomeScreenViewModel
import com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail.PetDetailViewModel
import org.koin.android.ext.koin.androidApplication


import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val appModule = module{
    single {
        FirebaseAuth.getInstance()
    }
    viewModel<NavigationViewModel>{
        NavigationViewModel(get())
    }
    factory <AuthRepositoryImpl>{
        AuthRepositoryImpl(firebaseAuth = get())
    }
    viewModel<LoginViewModel>{
        LoginViewModel(authRepository = get())
    }
    viewModel<HomeScreenViewModel>{
        HomeScreenViewModel(get())
    }
    viewModel<PetDetailViewModel>{
        PetDetailViewModel()
    }
    viewModel<SigUpViewModel> {
        SigUpViewModel(get())
    }
    single {
       GlobalStateDS(androidApplication().applicationContext)
    }
}