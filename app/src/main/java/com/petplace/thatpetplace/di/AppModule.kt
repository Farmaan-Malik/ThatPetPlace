package com.petplace.thatpetplace.di



import com.google.firebase.auth.FirebaseAuth
import com.petplace.thatpetplace.auth.data.remote.AuthApi
import com.petplace.thatpetplace.auth.data.remote.AuthRepositoryImpl
import com.petplace.thatpetplace.auth.presentation.login.LoginViewModel
import com.petplace.thatpetplace.auth.presentation.signup.SignUpViewModel
import com.petplace.thatpetplace.auth.presentation.signupDetails.SignUpDetailsViewModel
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Constants
import com.petplace.thatpetplace.homeScreen.appointments.AppointmentScreenViewModel
import com.petplace.thatpetplace.homeScreen.navigation.NavigationViewModel
import com.petplace.thatpetplace.homeScreen.presentation.HomeScreenViewModel
import com.petplace.thatpetplace.homeScreen.profile.data.remote.ProfileApi
import com.petplace.thatpetplace.homeScreen.profile.data.remote.ProfileRepositoryImpl
import com.petplace.thatpetplace.homeScreen.profile.presentation.ProfileScreenViewModel
import com.petplace.thatpetplace.homeScreen.profile.presentation.petDetail.PetDetailViewModel
import com.petplace.thatpetplace.homeScreen.search.SearchScreenViewModel
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
    factory{
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProfileApi::class.java)
    }
    factory <ProfileRepositoryImpl>{
        ProfileRepositoryImpl( profileApi = get())
    }
    viewModel<AppointmentScreenViewModel> {
        AppointmentScreenViewModel()
    }
    viewModel<PetDetailViewModel>{
        PetDetailViewModel(profileRepository = get(), globalStateDS = get())
    }
    viewModel<SignUpViewModel> {
        SignUpViewModel(get())
    }
    viewModel<SearchScreenViewModel> {
        SearchScreenViewModel(get())
    }
    viewModel<ProfileScreenViewModel> {
        ProfileScreenViewModel()
    }


    single {
       GlobalStateDS(androidApplication().applicationContext)
    }
}