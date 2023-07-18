package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.Jetpack1.Screen
import com.example.Jetpack1.SetupNavGraph
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
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
fun Logo(){
    Image(
        painterResource(id = R.drawable.artboard_1),
        contentDescription = "Logo",
        modifier = Modifier.size(250.dp),
    )
}

@Composable
fun AppName(){
    Text(text = "Saturnius",
        color = PrimaryColor,
        fontSize = 48.sp)
}

@Composable
fun Slogan(){
    Text(text = "Astrology knows the untold stories",
        color = PrimaryColor,
        fontSize = 20.sp)
}

@Composable
fun LoginButton(navController: NavController){
    Button(onClick = {
        navController.navigate(route = Screen.Login.route);
    },
        colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryColor),
        shape = RectangleShape,
        modifier = Modifier.padding(0.dp, 50.dp, 0.dp, 0.dp)
    ) {
        Text(text = "Continue with your account", color = Color.White, fontSize = 20.sp)
    }
}

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo()
        AppName()
        Slogan()
        LoginButton(navController = navController)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        HomeScreen(navController = rememberNavController())
    }
}

// Hàm dùng để convert mã hex thành màu
val PrimaryColor //Màu xanh đậm
    get() = Color(android.graphics.Color.parseColor("#1C3879"))
val SecondaryColor //Màu xanh nhạt
    get() = Color(android.graphics.Color.parseColor("#607EAA"))
val BackgroundColor
    get() = Color(android.graphics.Color.parseColor("#EAE3D2"))
val TextColor
    get() = Color(android.graphics.Color.parseColor("#F9F5EB"))