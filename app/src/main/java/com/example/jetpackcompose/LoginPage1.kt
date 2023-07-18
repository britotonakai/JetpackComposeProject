package com.example.Jetpack1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.*
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme


class Page1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var navController: NavHostController
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme() {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}


@Composable
fun Page1Screen(navController: NavController){
    Column(
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo()
        Slogan()
        InputUser(navController = navController)
    }
}

@Composable
fun InputUser(navController:NavController) {
    var user by remember { mutableStateOf("") }
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    Column() {
        TextField(
            value = user,
            onValueChange = {user = it},
            label = { Text(text = "Username", color = PrimaryColor) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = TextColor, unfocusedLabelColor = PrimaryColor)
        )
        TextField(
            value = password,
            onValueChange = {
                password = it },
            label = { Text(text = "Password", color = PrimaryColor)},
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility })
                {
                    Icon(
                        painter = if (passwordVisibility) painterResource(id = R.drawable.baseline_visibility_off_24) else  painterResource(
                            id = R.drawable.baseline_visibility_24,
                        ),
                        contentDescription = if (passwordVisibility) "Show Password" else "Hide Password"
                    )
                }
            },
            modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = TextColor, unfocusedLabelColor = PrimaryColor),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )

    }
    Button(onClick = {
        if(user == "admin" && password == "123456"){
            navController.navigate(route=Screen.Update.route);
        } },
        colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
        shape = RectangleShape,
        modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp)
    ) { Text(text = "Login", color = Color.White, fontSize = 20.sp)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPage1() {
    JetpackComposeTheme() {
        Page1Screen(navController = rememberNavController())
    }
}