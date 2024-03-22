package com.mertg.smarthomesystemsieee.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mertg.smarthomesystemsieee.MainActivity
import com.mertg.smarthomesystemsieee.R
import com.mertg.smarthomesystemsieee.presentation.common.CustomButton
import com.mertg.smarthomesystemsieee.presentation.common.RegularText
import com.mertg.smarthomesystemsieee.ui.theme.SmartHomeSystemsIEEETheme

@Composable
fun RegisterPage(navController: NavController) {
    Surface {
        var credentials by remember { mutableStateOf(CredentialsRegister()) }
        val context = LocalContext.current

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {

            Row {
                Image(
                    painter = painterResource(id = R.drawable.ieee),
                    contentDescription = "IEEE",
                    modifier = Modifier.size(width = 150.dp, height = 150.dp))

                Spacer(modifier = Modifier.width(15.dp))

                Image(
                    painter = painterResource(id = R.drawable.ieeeras),
                    contentDescription = "IEEE",
                    modifier = Modifier.size(width = 150.dp, height = 150.dp))
            }

            LoginFieldRegister(
                value = credentials.login,
                onChange = { data -> credentials = credentials.copy(login = data) },
                modifier = Modifier.fillMaxWidth(),
                label = "Kullanıcı Adı",
                placeholder = "Kullanıcı Adı Girin"
            )
            Spacer(modifier = Modifier.height(8.dp))
            LoginFieldRegister(
                value = credentials.email,
                onChange = { data -> credentials = credentials.copy(email = data) },
                modifier = Modifier.fillMaxWidth(),
                label = "E-Posta",
                placeholder = "E-posta Girin"
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordFieldRegister(
                value = credentials.pwd,
                onChange = { data -> credentials = credentials.copy(pwd = data) },
                submit = {
                    if (!checkCredentialsRegister(credentials, context)) credentials = CredentialsRegister()
                },
                modifier = Modifier.fillMaxWidth(),
                label = "Şifre",
                placeholder = "Şifre Girin"
            )
            Spacer(modifier = Modifier.height(8.dp))
            PasswordFieldRegister(
                value = credentials.confirmPwd,
                onChange = { data -> credentials = credentials.copy(confirmPwd = data) },
                submit = {
                    if (!checkCredentialsRegister(credentials, context)) credentials = CredentialsRegister()
                },
                modifier = Modifier.fillMaxWidth(),
                label = "Şifreyi Onayla",
                placeholder = "Şifreyi Tekrar Girin"
            )


            Spacer(modifier = Modifier.height(40.dp))
            Column {
                CustomButton(text = "Kayıt Ol") {
                    if (checkCredentialsRegister(credentials,context)){
                        Toast.makeText(context, "Başarıyla kaydoldunuz!", Toast.LENGTH_LONG).show()
                        navController.navigate("login_route")
                    }
                    else{
                        credentials = credentials.copy(login = "", email = "", pwd = "", confirmPwd = "")
                    }
                }

                TextButton(onClick = { navController.popBackStack()}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    RegularText(text = "Geri", fontSize = 15f, color = MaterialTheme.colorScheme.secondary)

                }
            }
        }
    }
}

fun checkCredentialsRegister(creds: CredentialsRegister, context: Context): Boolean {
    val passwordRegex = """^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$""".toRegex()

    if (creds.login.isEmpty() || creds.email.isEmpty() || creds.pwd.isEmpty() || creds.confirmPwd.isEmpty()) {
        context.startActivity(Intent(context, MainActivity::class.java))
        (context as Activity).finish()
        return false
    } else if (!Patterns.EMAIL_ADDRESS.matcher(creds.email).matches()) {
        Toast.makeText(context, "Yanlış e-posta formatı", Toast.LENGTH_LONG).show()
        return false
    } else if (!passwordRegex.matches(creds.pwd)) {
        Toast.makeText(context, "Şifre en az 8 hane olmalı ve en az bir rakam içermelidir", Toast.LENGTH_LONG).show()
        return false
    } else if (creds.pwd != creds.confirmPwd) {
        Toast.makeText(context, "Şifreler eşleşmiyor", Toast.LENGTH_LONG).show()
        return false
    } else {
        // Credentials are valid
        return true
    }
}

data class CredentialsRegister(
    var login: String = "",
    var email: String = "",
    var pwd: String = "",
    var confirmPwd: String = "",
) {
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty() && pwd.isNotEmpty()
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginFieldRegister(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String
) {

    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        if (label == "Kullanıcı Adı"){
            Icon(
                Icons.Default.Person,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        else if (label == "E-Posta"){
            Icon(
                Icons.Default.Mail,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }

    TextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier
            .clip(MaterialTheme.shapes.large),
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
}

@Composable
fun PasswordFieldRegister(
    value: String,
    onChange: (String) -> Unit,
    submit: () -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String = "Şifrenizi Girin"
) {

    var isPasswordVisible by remember { mutableStateOf(false) }

    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Key,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary
        )
    }
    val trailingIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }


    TextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier
            .clip(MaterialTheme.shapes.large),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { submit() }
        ),
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview() {
    SmartHomeSystemsIEEETheme {
        RegisterPage(navController = rememberNavController())
    }
}

@Preview(showBackground = true,  showSystemUi = true)
@Composable
fun RegisterPreviewDark() {
    SmartHomeSystemsIEEETheme(darkTheme = true) {
        RegisterPage(navController = rememberNavController())
    }
}