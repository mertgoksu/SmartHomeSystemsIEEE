package com.mertg.smarthomesystemsieee.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mertg.smarthomesystemsieee.presentation.common.CustomButton

@Composable
fun DetailPage(navController : NavHostController) {

    val item_name = navController.currentBackStackEntry?.arguments?.getString("item_name")

    val (selected, onSelected) = remember { mutableStateOf(false) }

    var sliderValue by remember {
        mutableStateOf(0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row( // ürün görseli
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .height(180.dp)
                    .padding(all = 10.dp)
                    .padding(top = 30.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = Color.White
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text(text = item_name!!, fontSize = 31.sp, color = Color.White)
                }
            }
        }
        Row( // ürünün adı
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Example Eşya",
                fontSize = 31.sp, color = MaterialTheme.colorScheme.secondary)
        }
        Row( // parlaklık için slider
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "${sliderValue.toInt()} %", fontSize = 22.sp)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Slider(
                        value = sliderValue,
                        onValueChange = {
                        sliderValue = it },
                        valueRange = 0f..100f,
                        colors = SliderDefaults.colors(
                            activeTrackColor = MaterialTheme.colorScheme.tertiary,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                            thumbColor = MaterialTheme.colorScheme.tertiary
                        ))

                }
            }
        }
        Row( // yazı ve radio button
            Modifier
                .weight(1f)
                .padding(30.dp)
        ) {
            Column( // Radionun solundaki yazı
                Modifier.weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Example \nEşya", fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.secondary,
                    textAlign = TextAlign.Start)
            }
            Column( // Radio button
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RadioButton(selected = selected, onClick = {
                    onSelected(!selected)},
                    modifier = Modifier.scale(1.24f),
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.tertiary,
                        unselectedColor = MaterialTheme.colorScheme.secondary
                    ))
            }
        }
        Row( // kapatma butonu
            Modifier
                .weight(1f)
                .padding(30.dp)
        ) {
            CustomButton(text = "Aç / Kapa") {
                
            }
        }

    }
}

@Preview
@Composable
fun DetailPagePreview() {
    DetailPage(rememberNavController())
}