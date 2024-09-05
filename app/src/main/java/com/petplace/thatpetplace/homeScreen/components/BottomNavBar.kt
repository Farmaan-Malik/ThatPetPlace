package com.petplace.thatpetplace.homeScreen.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.offset
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.petplace.thatpetplace.homeScreen.navigation.BottomNavigationObjects

@Composable
fun BottomNavBar(navController: NavHostController) {

    val screens = listOf(
        BottomNavigationObjects.searchScreen,
        BottomNavigationObjects.appointmentScreen,
        BottomNavigationObjects.exploreScreen,
        BottomNavigationObjects.profileScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(backgroundColor = Color.White) {
        screens.forEach { screen ->
            AddItems(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )

        }
    }

}

@Composable
fun RowScope.AddItems(
    screen: BottomNavigationObjects,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any() {
        it.route == screen.route
    } == true
    BottomNavigationItem(
        modifier = Modifier.offset(x = 0.dp, y = if(selected) (-10).dp else 0.dp),
        selected = selected,
        onClick = { navController.navigate(screen.route) },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = screen.title,
                tint = if (selected) Color(0xFFFDA8A5) else Color(0xFFBBC3CE)
            )
        },
        selectedContentColor = Color(0xFFFDA8A5),
        label = {
            Text(
                text = screen.title,
                color = if (selected) Color(0xFFFDA8A5) else Color(0xFFBBC3CE),
                fontSize = 10.sp
            )
        })
}