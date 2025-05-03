package com.example.androidapp1 // Replace with your package name


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import com.example.androidapp1.ui.theme.AndroidApp1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidApp1Theme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Welcome Android App!!") },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Blue,
                                titleContentColor = Color.White,
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            modifier = Modifier.fillMaxWidth(),
                            containerColor = Color.Blue
                        ) {
                            Text(
                                text = "Made by Ashton",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                textAlign = TextAlign.Center,
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }
                    },
                    modifier = Modifier.fillMaxSize(),
                    content = { padding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding),
                            contentAlignment = Alignment.Center
                        ) {
                            //Active logic for app
                            AppUI()
                        }

                    }
                )

            }
        }
    }
}

@Composable
fun AppUI() {
    var currentImage1 by remember { mutableStateOf(R.drawable.jdm) }
    var currentImage2 by remember { mutableStateOf(R.drawable.yamaha) }
    var currentImage3 by remember { mutableStateOf(R.drawable.biker) }
    var isVisible1 by remember { mutableStateOf(false) }
    var isVisible2 by remember { mutableStateOf(false) }
    var isVisible3 by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        //Number 1
        Button(
            onClick = {
                isVisible1 = !isVisible1
                isVisible2 = false
                isVisible3 = false
            },
            modifier = Modifier.padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(60.dp),
                painter = painterResource(R.drawable.baseline_directions_car_24),
                contentDescription = null
            )
            Text(text = "Nissan R-32", fontSize = 40.sp)
        }

        // Use AnimatedVisibility for a smooth transition
        AnimatedVisibility(
            visible = isVisible1,
            modifier = Modifier.wrapContentSize()
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp),
                painter = painterResource(id = currentImage1),
                contentDescription = "A Car logo"
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        //Number 2
        Button(
            onClick = {
                isVisible2 = !isVisible2
                isVisible1 = false
                isVisible3 = false
            },
            modifier = Modifier.padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(60.dp),
                painter = painterResource(R.drawable.baseline_directions_bike_24),
                contentDescription = null
            )
            Text(text = "Yamaha YZ250F", fontSize = 30.sp)
        }

        // Use AnimatedVisibility for a smooth transition
        AnimatedVisibility(
            visible = isVisible2,
            modifier = Modifier.wrapContentSize()
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp),
                painter = painterResource(id = currentImage2),
                contentDescription = "A Yamaha dirtbike 250F"
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // NUMBER 3
        Button(
            onClick = {
                isVisible3 = !isVisible3
                isVisible1 = false
                isVisible2 = false
            },
            modifier = Modifier.padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(60.dp),
                painter = painterResource(R.drawable.baseline_air_24),
                contentDescription = null
            )
            Text(text = "Mountain Bike", fontSize = 34.sp)
        }

        // Use AnimatedVisibility for a smooth transition
        AnimatedVisibility(
            visible = isVisible3,
            modifier = Modifier.wrapContentSize()
        ) {
            Image(
                modifier = Modifier
                    .size(200.dp),
                painter = painterResource(id = currentImage3),
                contentDescription = "Mountain bike whip"
            )
        }
    }
}