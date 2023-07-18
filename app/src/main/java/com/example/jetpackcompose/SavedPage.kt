package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.Jetpack1.*
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class SavedPage : ComponentActivity() {
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
fun SaveDescription(){
    val chartList = listOf(
        "York's Chart",
        "Zeruiah's Chart",
        "Stanisław's Chart",
        "Micha's Chart",
        "Hypatia's Chart",
        "Mórríghan's Chart",
        "Janja's Chart",
        "Wat's Chart",
        "Penka's Chart",
        "Wulfrun's Chart",
        "Hugleikr's Chart",
        "Evpraksiya's Chart",
        "Alois's Chart",
        "Eskender's Chart",
        "Ivan's Chart",
        "Judith's Chart",
        "Wilfried's Chart",
        "Helga's Chart",
        "Arturo's Chart",
        "Silas's Chart",
        "Robert's Chart",
        "Halima's Chart",
        "Lieber's Chart",
        "Gyöngyvér's Chart"
    )
    Scaffold(backgroundColor = BackgroundColor,
        modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 0.dp)) {it
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        ){
            items(chartList){item ->
                MyChart(chartName = item, chartImage = R.drawable.chart)
            }
        }
    }
}

@Composable
fun MyChart(chartName:String, chartImage:Int){
    Card(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .height(150.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        backgroundColor = TextColor
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = chartName,
                color = PrimaryColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = chartImage),
                contentDescription = "chart",
            )
        }
    }
}

@Composable
fun SaveScreen(navController: NavController){
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
                mutableStateOf(true);
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
        SaveDescription()
    }
}

@Preview
@Composable
fun SavedPagePreview(){
    JetpackComposeTheme() {
        SaveScreen(navController = rememberNavController())
    }
}