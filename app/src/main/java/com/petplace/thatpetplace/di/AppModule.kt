package com.petplace.thatpetplace.di


import com.google.firebase.auth.FirebaseAuth
import com.petplace.thatpetplace.auth.data.remote.AuthApi
import com.petplace.thatpetplace.auth.data.remote.AuthRepositoryImpl
import com.petplace.thatpetplace.auth.presentation.login.LoginViewModel
import com.petplace.thatpetplace.auth.presentation.signupDetails.SignUpDetailsViewModel
import com.petplace.thatpetplace.common.dataStore.GlobalStateDS
import com.petplace.thatpetplace.common.utils.Constants
import com.petplace.thatpetplace.homeScreen.appointments.AppointmentScreenViewModel
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreDetails.ExploreDetailScreenViewModel
import com.petplace.thatpetplace.homeScreen.explore.presentation.ExploreScreenViewModel
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.remote.ExploreApi
import com.petplace.thatpetplace.homeScreen.explore.presentation.Store.data.remote.ExploreRepositoryImpl
import com.petplace.thatpetplace.homeScreen.navigation.NavigationViewModel
import com.petplace.thatpetplace.homeScreen.presentation.HomeScreenViewModel
import com.petplace.thatpetplace.homeScreen.profile.data.remote.ProfileApi
import com.petplace.thatpetplace.homeScreen.profile.data.remote.ProfileRepositoryImpl
import com.petplace.thatpetplace.homeScreen.profile.presentation.ProfileViewViewModel
import com.petplace.thatpetplace.homeScreen.profile.presentation.petDetail.PetDetailViewModel
import com.petplace.thatpetplace.homeScreen.profile.presentation.profileDetail.ProfileScreenViewModel
import com.petplace.thatpetplace.homeScreen.search.SearchScreenViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val appModule = module {
    single {
        FirebaseAuth.getInstance()
    }
    factory {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .build()
        Retrofit
            .Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
    factory<AuthRepositoryImpl> {
        AuthRepositoryImpl(api = get())
    }
    viewModel<NavigationViewModel> {
        NavigationViewModel(get())
    }

    viewModel<LoginViewModel> {
        LoginViewModel(authRepository = get(), globalStateDS = get())
    }
    viewModel<SignUpDetailsViewModel> {
        SignUpDetailsViewModel(authRepository = get(), globalStateDS = get())
    }
    viewModel<HomeScreenViewModel> {
        HomeScreenViewModel(get())
    }
    factory {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .build()
        Retrofit
            .Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProfileApi::class.java)
    }
    factory {
        val client: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .build()
        Retrofit
            .Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExploreApi::class.java)
    }
    factory<ProfileRepositoryImpl> {
        ProfileRepositoryImpl(profileApi = get())
    }
    factory<ExploreRepositoryImpl> {
        ExploreRepositoryImpl(api = get())
    }
    viewModel<AppointmentScreenViewModel> {
        AppointmentScreenViewModel()
    }
    viewModel<ExploreScreenViewModel> {
        ExploreScreenViewModel(globalStateDS = get(), repository = get())
    }
    viewModel<ExploreDetailScreenViewModel> {
        ExploreDetailScreenViewModel()
    }
    viewModel<PetDetailViewModel> {
        PetDetailViewModel(profileRepository = get(), globalStateDS = get())
    }
    viewModel<ProfileViewViewModel> {
        ProfileViewViewModel(profileRepository = get(), globalStateDS = get())
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