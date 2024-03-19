package com.mertg.smarthomesystemsieee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mertg.smarthomesystemsieee.ui.theme.SmartHomeSystemsIEEETheme

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
                    WhiteBackground()
                }
            }
        }
    }
}

@Composable
fun WhiteBackground(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)){}
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartHomeSystemsIEEETheme {
        WhiteBackground()
    }
}