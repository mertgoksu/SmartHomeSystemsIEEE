package com.mertg.smarthomesystemsieee.util

sealed class Screen(val route : String){
    data object MainPage : Screen(route = "route_main_page")
    data object PairPage : Screen(route = "route_pair_page")
    data object SettingsPage : Screen(route = "route_settings_page")
    data object LoginPage : Screen(route = "login_route")
    data object RegisterPage : Screen(route = "register_route")
    data object MainScaffold : Screen(route = "main_scaffold_route")
    data object DetailPage : Screen(route = "route_detail_page/{item_name}"){
        fun passItemName(item : String) : String{
            return "route_detail_page/${item}"
        }
    }


}