package com.mertg.smarthomesystemsieee

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mertg.smarthomesystemsieee.ui.theme.SmartHomeSystemsIEEETheme
import com.mertg.smarthomesystemsieee.view.DetailPage
import com.mertg.smarthomesystemsieee.view.LoginPage
import com.mertg.smarthomesystemsieee.view.MainPage
import com.mertg.smarthomesystemsieee.view.PairPage
import com.mertg.smarthomesystemsieee.view.SettingsPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartHomeSystemsIEEETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController, startDestination = "login_route") {
                        composable("login_route") {
                            LoginPage(navController)
                        }
                        composable("main_scaffold_route"){
                            MainScaffold()
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun WhiteBackground(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){

    }
}

@Composable
fun MainScaffold(){
    var selectedTab by remember { mutableStateOf(0) }

    val navController = rememberNavController()

    Scaffold(
        /*topBar = { //Suanlik topappbar yok
            TopAppBar(
                title = { },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                navigationIcon = {
                    IconButton(onClick = { //Gerekirse ekleyeceğiz, geri butonu
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = "Back")
                    }
                }
            )
        },*/

        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 1.dp)
                    .background(MaterialTheme.colorScheme.primary),
                containerColor = MaterialTheme.colorScheme.tertiary
            ) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = {
                        selectedTab = 0
                        navController.navigate("route_main_page")
                    },
                    icon = {
                        Icon(Icons.Filled.Home, "")
                    },
                    label = {
                        Text(text = "Anasayfa", color = Color.White)
                    }

                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = {
                        selectedTab = 1
                        navController.navigate("route_pair_page")
                    },
                    icon = {
                        Icon(Icons.Filled.Wifi, "")
                    },
                    label = {
                        Text(text = "Cihaz Arama", color = Color.White)
                    }
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = {
                        selectedTab = 2
                        navController.navigate("route_settings_page")
                    },
                    icon = {
                        Icon(Icons.Filled.Settings, "")
                    },
                    label = {
                        Text(text = "Ayarlar",color = Color.White)
                    }
                )
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            NavHost(navController, startDestination = "route_main_page") {
                composable("route_main_page") {
                    MainPage(navController = navController)
                }
                composable("route_pair_page") {
                    PairPage(navController = navController)
                }
                composable("route_settings_page") {
                    SettingsPage(navController = navController)
                }//Aşağıdakileri eklememin sebebi Main gidince bu navController'ı alıyor bunlara
                //gitmek için lazım, yoksa sadece üsttekilere gidebilir.
                composable("login_route") {
                    LoginPage(navController)
                }
                composable("main_scaffold_route"){
                    MainScaffold()
                }
                composable("route_detail_page/{item_name}",arguments = listOf(
                    navArgument("item_name"){
                        type = NavType.StringType
                    }
                )){
                    DetailPage(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartHomeSystemsIEEETheme {
        LoginPage(navController = rememberNavController())
    }
}