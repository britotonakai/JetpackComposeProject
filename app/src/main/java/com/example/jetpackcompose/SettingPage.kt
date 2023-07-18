package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

class SettingPage : ComponentActivity() {
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
fun SettingDescription(){
    val settinglist = listOf(
        "Name",
        "Username",
        "Change profile photo",
        "Birth date",
        "Birth time",
        "Birth place",
        "Time zone",
        "Public profile",
        "Nofitication",
        "Saved Message",
        "Feedback",
        "FAQ",
        "Delete Account",
        "Terms",
        "Log out"
    )
    Column() {
        LazyColumn(
            contentPadding = PaddingValues(13.dp)
        ){
            items(settinglist){item ->
                MyCard(settingName = item)
            }
        }
    }
}

@Composable
fun MyCard(settingName:String){
    Card(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .height(60.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        backgroundColor = TextColor
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Column {
                Text(
                    text = settingName,
                    color = PrimaryColor,
                    fontSize = 20.sp,
                )
            }

        }
    }
}

@Composable
fun SettingScreen(navController: NavController){
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
                mutableStateOf(false);
            }
            var Savedstate = remember {
                mutableStateOf(false);
            }
            var Settingstate = remember {
                mutableStateOf(true);
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
        SettingDescription()
    }
}

@Preview
@Composable
fun SettingPagePreview(){
    JetpackComposeTheme() {
        SettingScreen(navController = rememberNavController())
    }
}
