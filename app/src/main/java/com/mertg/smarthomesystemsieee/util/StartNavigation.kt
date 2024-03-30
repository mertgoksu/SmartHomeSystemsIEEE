package com.mertg.smarthomesystemsieee.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mertg.smarthomesystemsieee.scaffolds.MainScaffold
import com.mertg.smarthomesystemsieee.view.LoginPage
import com.mertg.smarthomesystemsieee.view.RegisterPage

@Composable
fun StartNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.LoginPage.route) {
        composable(Screen.LoginPage.route) {
            LoginPage(navController)
        }
        composable(Screen.MainScaffold.route){
            MainScaffold()
        }
        composable(Screen.RegisterPage.route){
            RegisterPage(navController)
        }
    }
}