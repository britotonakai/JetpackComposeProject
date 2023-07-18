package com.example.Jetpack1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
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
import com.example.jetpackcompose.BackgroundColor
import com.example.jetpackcompose.PrimaryColor
import com.example.jetpackcompose.R
import com.example.jetpackcompose.SecondaryColor
import com.example.jetpackcompose.TextColor
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme


class UpdatePage : ComponentActivity() {
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
fun TitleUser(){
    Text(
        text = "You",
        color = PrimaryColor,
        fontSize = 23.sp,
        modifier = Modifier.padding(15.dp, 20.dp, 0.dp, 0.dp),
    )
}

@Composable
fun Big3(){
    Row(modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp)) {
        Image(
            painterResource(id = R.drawable.sun),
            contentDescription = "Sun",
            modifier = Modifier
                .size(25.dp)
                .padding(0.dp, 4.dp, 0.dp, 0.dp))
        Text(
            text = "Capricorn",
            color = PrimaryColor,
            fontSize = 15.sp,
            modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.moon),
            contentDescription = "Moon",
            modifier = Modifier
                .size(25.dp)
                .padding(0.dp, 4.dp, 0.dp, 0.dp)
        )
        Text(
            text = "Aries",
            color = PrimaryColor,
            fontSize = 15.sp,
            modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ascendant),
            contentDescription = "Ascendant",
            modifier = Modifier
                .size(25.dp)
                .padding(0.dp, 4.dp, 0.dp, 0.dp)
        )
        Text(
            text = "Sagittarius",
            color = PrimaryColor,
            fontSize = 15.sp,
            modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
fun UserAvatar(){
    Image(
        painter = painterResource(id = R.drawable.avt),
        contentDescription = "User avatar",
        modifier = Modifier
            .clip(CircleShape)
            .size(100.dp)
        )
}

@Composable
fun Days(){
    Column() {
        Row(modifier = Modifier.padding(40.dp, 20.dp, 0.dp, 0.dp),
        horizontalArrangement = Arrangement.spacedBy(
            space = 40.dp,
            alignment = Alignment.CenterHorizontally,
        )) {
            Text(
                text = "WED",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
                )
            Text(
                text = "THU",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                )
            Text(
                text = "TODAY",
                color = PrimaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,)
            Text(
                text = "SAT",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,)
            Text(text = "SUN",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,)
        }
        Row(modifier = Modifier.padding(45.dp, 12.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.spacedBy(
                space = 55.dp,
                alignment = Alignment.CenterHorizontally,
            )) {
            Text(
                text = "22",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "23",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "24",
                color = PrimaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    .drawBehind {
                        drawCircle(color = TextColor, radius = this.size.maxDimension)
                    }
            )
            Text(
                text = "25",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(5.dp,0.dp,0.dp,0.dp)
            )
            Text(text = "26",
                color = SecondaryColor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun Description(){
    Column(
        modifier = Modifier
            .padding(40.dp, 40.dp, 0.dp, 0.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Create things.",
            color = PrimaryColor,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
        )
        Row(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)) {
            Image(
                painter = painterResource(id = R.drawable.power),
                contentDescription = "Must do",)
            Text(
                text = "Power in routine, thinking & creativity, sex & love, and self",
                color = SecondaryColor,
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 15.sp
            )
        }
        Row(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)) {
            Image(
                painter = painterResource(id = R.drawable.trouble),
                contentDescription = "Dont do",)
            Text(
                text = "Trouble with spirituality and social life",
                color = SecondaryColor,
                modifier = Modifier
                    .padding(10.dp, 0.dp, 10.dp, 0.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.update_page_image),
            contentDescription = "image",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.End)
                .padding(0.dp, 0.dp, 10.dp, 0.dp))
        Text(
            text = "Today you feel torn between the pressure to slow down and your fear of boredom. It's good to seek out company if that's what you need. Just make sure you're not doing that thing where you play with fire, and then start to believe that fear is a sign of weakness.\n" +
                "Expand the definition of who you are.\n" +
                "This month, you are ready to break the rules. This is a commendable move for someone who can come across as rigid and judgmental. Decide between practicality and pleasure.\n" +
                "The general theme of your life during this period is to take on more power and to act more effectively than any other time in your life. Self-esteem emerges when you ignore unwanted opinions. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ",
            fontSize = 15.sp,
            color = SecondaryColor,
            modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp))
    }
}

@Composable
fun UpdateScreen(navController: NavController){
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
                mutableStateOf(true);
            }
            var Chartstate = remember {
                mutableStateOf(false);
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
        Description()
    }
}

@Preview
@Composable
fun UpdatePagePreview(){
    JetpackComposeTheme() {
        UpdateScreen(navController = rememberNavController())
    }
}