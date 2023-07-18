package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.Jetpack1.*
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class ChartPage : ComponentActivity() {
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
fun ChartDescription(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(id = R.drawable.chart),
            contentDescription = "chart",
            modifier = Modifier
                .size(400.dp)
                .padding(0.dp, 5.dp, 0.dp, 0.dp)
        )
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(
                space = 20.dp,
            ),
            modifier = Modifier.padding(30.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 5.dp,
                ),
            ) {
                Text(
                    text = "Ascendant",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Jupiter",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Sun",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Mercury",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Mars",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 5.dp,
                )
            ) {
                Text(
                    text = "Sagittarius",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "Cancer",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,)
                Text(
                    text = "Capricorn",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,)
                Text(text = "")
                Text(
                    text = "Pisces",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 5.dp,
                )
            ) {
                Text(
                    text = "Moon",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,)
                Text(
                    text = "Saturn",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,)
                Text(
                    text = "Neptune",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,)
                Text(
                    text = "Uranus",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,)
                Text(
                    text = "Pluto",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,)
                Text(
                    text = "Venus",
                    color = PrimaryColor,
                    fontWeight = FontWeight.Bold,)
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 5.dp,
                )
            ) {
                Text(
                    text = "Aries",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "Gemini",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,)
                Text(
                    text = "Aquarius",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,)
                Text(text = "")
                Text(
                    text = "Sagittarius",
                    color = SecondaryColor,
                    fontWeight = FontWeight.Medium,)
            }
        }
    }
}

@Composable
fun ChartScreen(navController: NavController){
    Column() {
        Row(modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxSize()
            .padding(20.dp, 20.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top) {
            UserAvatar()
            Column {
                TitleUser()
                Big3()
            }
        }
    }
    Column(modifier = Modifier.padding(0.dp, 130.dp, 0.dp, 0.dp),) {
        Row(
            modifier = Modifier.padding(40.dp, 10.dp,0.dp,0.dp),
            horizontalArrangement = Arrangement.spacedBy(
                space = 50.dp,
                alignment = Alignment.CenterHorizontally,
            )
        ) {
            var Updatestate = remember {
                mutableStateOf(false);
            }
            var Chartstate = remember {
                mutableStateOf(true);
            }
            var Savedstate = remember {
                mutableStateOf(false);
            }
            var Settingstate = remember {
                mutableStateOf(false);
            }
            ClickableText(
                text = AnnotatedString("Updates"),
                style = TextStyle(
                    color =  if (Updatestate.value) PrimaryColor else SecondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                ),
                onClick = {
                    Updatestate.value = !Chartstate.value
                    Chartstate.value = false
                    Savedstate.value = false
                    Settingstate.value = false
                    navController.navigate(route = Screen.Update.route)
                })
            ClickableText(
                text = AnnotatedString("Chart"),
                style = TextStyle(
                    color =  if (Chartstate.value) PrimaryColor else SecondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                ),
                onClick = {
                    Chartstate.value = !Chartstate.value
                    Updatestate.value = false
                    Savedstate.value = false
                    Settingstate.value = false
                    navController.navigate(route = Screen.Chart.route)
                })
            ClickableText(
                text = AnnotatedString("Saved"),
                style = TextStyle(
                    color =  if (Savedstate.value) PrimaryColor else SecondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                ),
                onClick = {
                    Savedstate.value = !Savedstate.value
                    Chartstate.value = false
                    Updatestate.value = false
                    Settingstate.value = false
                    navController.navigate(route = Screen.Saved.route)
                })

            ClickableText(
                text = AnnotatedString("Setting"),
                style = TextStyle(
                    color =   if (Settingstate.value) PrimaryColor else SecondaryColor,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                ),
                onClick = {
                    Settingstate.value = !Savedstate.value
                    Savedstate.value = false
                    Chartstate.value = false
                    Updatestate.value = false
                    navController.navigate(route = Screen.Setting.route)
                })
        }
        Divider(
            color = PrimaryColor,
            thickness = 1.dp,
            modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)
        )
        Days()
        ChartDescription()
    }
}

@Preview
@Composable
fun ChartPagePreview(){
    JetpackComposeTheme() {
        ChartScreen(navController = rememberNavController())
    }
}