package com.petplace.thatpetplace.homeScreen.navigation

import com.petplace.thatpetplace.R
import com.petplace.thatpetplace.common.Routes

sealed class BottomNavigationObjects (
    val title: String,
    val route : String,
    val icon : Int
){

    object searchScreen: BottomNavigationObjects(
        route = Routes.HomeScreenRoutes.SEARCH_SCREEN,
        title = "Search",
        icon = R.drawable.search
    )
    object appointmentScreen: BottomNavigationObjects(
        route = Routes.HomeScreenRoutes.APPOINTMENT_SCREEN,
        title = "Appointments",
        icon = R.drawable.clock_outlined
    )
    object exploreScreen: BottomNavigationObjects(
        route = Routes.HomeScreenRoutes.EXPLORE_SCREEN,
        title = "Explore",
        icon = R.drawable.explore_outlined
    )
    object profileScreen: BottomNavigationObjects(
        route = Routes.HomeScreenRoutes.PROFILE_VIEW_SCREEN,
        title = "Profile",
        icon = R.drawable.person_outlined
    )
}