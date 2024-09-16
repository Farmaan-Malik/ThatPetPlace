package com.petplace.thatpetplace.homeScreen.explore.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ExploreScreenViewModel(): ViewModel() {
    val stores = mutableStateOf(listOf<String>("asd"))
    val clinics = mutableStateOf(listOf<String>("hsg"))

}