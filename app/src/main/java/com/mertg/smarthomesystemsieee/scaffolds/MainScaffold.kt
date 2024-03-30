package com.mertg.smarthomesystemsieee.scaffolds

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mertg.smarthomesystemsieee.util.AllAppNavigation
import com.mertg.smarthomesystemsieee.util.Screen

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
                        navController.navigate(Screen.MainPage.route)
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
                        navController.navigate(Screen.PairPage.route)
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
                        navController.navigate(Screen.SettingsPage.route)
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
            AllAppNavigation(navController = navController)
        }
    }
}