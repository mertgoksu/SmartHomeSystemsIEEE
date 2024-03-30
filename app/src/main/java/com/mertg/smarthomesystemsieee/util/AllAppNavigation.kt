package com.mertg.smarthomesystemsieee.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mertg.smarthomesystemsieee.scaffolds.MainScaffold
import com.mertg.smarthomesystemsieee.view.DetailPage
import com.mertg.smarthomesystemsieee.view.LoginPage
import com.mertg.smarthomesystemsieee.view.MainPage
import com.mertg.smarthomesystemsieee.view.PairPage
import com.mertg.smarthomesystemsieee.view.SettingsPage

@Composable
fun AllAppNavigation(navController : NavHostController) {
    NavHost(navController, startDestination = Screen.MainPage.route) {
        composable(Screen.MainPage.route) {
            MainPage(navController = navController)
        }
        composable(Screen.PairPage.route) {
            PairPage(navController = navController)
        }
        composable(Screen.SettingsPage.route) {
            SettingsPage(navController = navController)
        }//Aşağıdakileri eklememin sebebi Main gidince bu navController'ı alıyor bunlara
        //gitmek için lazım, yoksa sadece üsttekilere gidebilir.
        composable(Screen.LoginPage.route) {
            LoginPage(navController)
        }
        composable(Screen.MainScaffold.route) {
            MainScaffold()
        }
        composable(
            Screen.DetailPage.route, arguments = listOf(
                navArgument("item_name") {
                    type = NavType.StringType
                }
            )) {
            DetailPage(navController = navController)
        }
    }
}
