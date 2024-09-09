package com.petplace.thatpetplace.di



import com.google.firebase.auth.FirebaseAuth
import com.petplace.thatpetplace.auth.data.AuthApi
import com.petplace.thatpetplace.auth.data.AuthRepositoryImpl
import com.petplace.thatpetplace.auth.presentation.login.LoginViewModel
import com.petplace.thatpetplace.auth.presentation.signup.SignUpViewModel
import com.petplace.thatpetplace.auth.presentation.signupDetails.SignUpDetailsViewModel
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Constants
import com.petplace.thatpetplace.homeScreen.navigation.NavigationViewModel
import com.petplace.thatpetplace.homeScreen.presentation.HomeScreenViewModel
import com.petplace.thatpetplace.homeScreen.presentation.profile.petDetail.PetDetailViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module{
    single {
        FirebaseAuth.getInstance()
    }
    factory{
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)

            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
    factory <AuthRepositoryImpl>{
        AuthRepositoryImpl( api = get())
    }
    viewModel<NavigationViewModel>{
        NavigationViewModel(get())
    }

    viewModel<LoginViewModel>{
        LoginViewModel(authRepository = get(), globalStateDS = get())
    }
    viewModel<SignUpDetailsViewModel>{
        SignUpDetailsViewModel(authRepository = get(), globalStateDS = get())
    }
    viewModel<HomeScreenViewModel>{
        HomeScreenViewModel(get())
    }
    viewModel<PetDetailViewModel>{
        PetDetailViewModel()
    }
    viewModel<SignUpViewModel> {
        SignUpViewModel(get())
    }
    single {
       GlobalStateDS(androidApplication().applicationContext)
    }
}