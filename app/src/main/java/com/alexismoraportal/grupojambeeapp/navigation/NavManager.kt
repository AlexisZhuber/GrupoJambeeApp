package com.alexismoraportal.grupojambeeapp.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alexismoraportal.grupojambeeapp.viewModel.PropertiesViewModel
import com.alexismoraportal.grupojambeeapp.views.AboutView
import com.alexismoraportal.grupojambeeapp.views.ContactView
import com.alexismoraportal.grupojambeeapp.views.DetailView
import com.alexismoraportal.grupojambeeapp.views.HomeView

@Composable
fun NavManager(
    navController: NavController,
    viewModel: PropertiesViewModel,
    drawerState: DrawerState
){
    NavHost(
        navController = navController as NavHostController,
        startDestination = "Home"
    ){
        composable("Home"){
            HomeView(viewModel, navController, drawerState)
        }
        composable("About"){
            AboutView(navController, drawerState)
        }
        composable("Contact"){
            ContactView(navController, drawerState)
        }
        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.StringType },
        )){
            val id = it.arguments?.getString("id") ?: ""
            DetailView(viewModel, navController, id, drawerState)
        }
    }
}