package com.norameyer.healtifyy.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.norameyer.healtifyy.NavigationItems

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { Navigation(navController) }

}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItems.Pressure,
        NavigationItems.Pills,
        NavigationItems.Sugar,
    )

    BottomNavigation(
        backgroundColor = Color.LightGray
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { items ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = items.icon), contentDescription = items.title, modifier = Modifier.size(15.dp)) },
                label = { Text(text = items.title, fontSize = 10.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == items.route,
                onClick = {
                    navController.navigate(items.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route = route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController, NavigationItems.Pressure.route) {

        composable(NavigationItems.Pressure.route) {
            PressureScreen()
        }

        composable(NavigationItems.Pills.route) {
            PillsScreen()
        }

        composable(NavigationItems.Sugar.route) {
            SugarScreen()
        }
    }
}