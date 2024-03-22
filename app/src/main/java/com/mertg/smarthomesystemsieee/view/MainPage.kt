package com.mertg.smarthomesystemsieee.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mertg.smarthomesystemsieee.presentation.common.BoldText
import com.mertg.smarthomesystemsieee.presentation.common.RegularText
import com.mertg.smarthomesystemsieee.ui.theme.SmartHomeSystemsIEEETheme

@Composable
fun MainPage(navController: NavController) {

    val mainDummyItems = listOf("1","2","3","4","5","6","7","8","9","10")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(mainDummyItems){item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                        .padding(16.dp)
                        .clickable {
                            navController.navigate("route_detail_page/${item}")
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = Color.White
                    )
                ){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RegularText(text = item, fontSize = 31f, color = Color.White)
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    SmartHomeSystemsIEEETheme {
        MainPage(navController = rememberNavController())
    }
}