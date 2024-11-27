package com.example.littlelemoncapstone

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.room.Room

@Composable
fun NavigationComposable(navController: NavHostController, database: AppDatabase) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    val startDestination = if (sharedPreferences.getBoolean("userRegistered", false)) Home.route else Onboarding.route


    NavHost(navController = navController, startDestination = startDestination){
        composable(Onboarding.route){
            Onboarding(navController)
        }
        composable(Home.route){
            Home(navController, database)
        }
        composable(Profile.route){
            Profile(navController)
        }
    }


}