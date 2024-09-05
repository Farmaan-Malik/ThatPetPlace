package com.petplace.thatpetplace.di



import com.google.firebase.auth.FirebaseAuth
import com.petplace.thatpetplace.auth.data.AuthRepositoryImpl

import com.petplace.thatpetplace.auth.presentation.login.LoginViewModel
import com.petplace.thatpetplace.homeScreen.navigation.NaviagationViewModel
import com.petplace.thatpetplace.homeScreen.presentation.HomeScreenViewModel
import com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail.PetDetailViewModel

import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val appModule = module{
    single {
        FirebaseAuth.getInstance()
    }
    viewModel<NaviagationViewModel>{
        NaviagationViewModel(firebaseAuth = get())
    }
    factory <AuthRepositoryImpl>{
        AuthRepositoryImpl(firebaseAuth = get())
    }
    viewModel<LoginViewModel>{
        LoginViewModel(authRepository = get())
    }
    viewModel<HomeScreenViewModel>{
        HomeScreenViewModel(authRepository = get())
    }
    viewModel<PetDetailViewModel>{
        PetDetailViewModel()
    }

}