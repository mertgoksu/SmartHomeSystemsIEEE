package com.mertg.smarthomesystemsieee.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mertg.smarthomesystemsieee.ui.theme.SmartHomeSystemsIEEETheme

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
) {


    FilledTonalButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(3.dp, 3.dp),
        shape = RoundedCornerShape(size = 15.dp),
        contentPadding = PaddingValues(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            ) // Empty box to push text to the right
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(6.dp)
            )
            Box(
                modifier = Modifier
                    .padding(horizontal = 5.dp)
            ) // Empty box to push text to the left
        }
    }
}

@Preview
@Composable
fun CustomButtonPreview(){
    SmartHomeSystemsIEEETheme{
        Column {
            CustomButton(text = "Giriş Yap") {

            }
            CustomButton(text = "Ana Sayfa") {
                
            }
            CustomButton(text = "Uzun bir deneme") {
                
            }
        }

    }
}