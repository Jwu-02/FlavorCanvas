package com.example.corecomposeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corecomposeapplication.ui.theme.CoreComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    Surface(color = Color.DarkGray,
        modifier = Modifier.fillMaxSize()){ //Surface occupies the whole screen
        Surface(color=Color.DarkGray, modifier = Modifier.wrapContentSize(align = Alignment.TopStart))
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                //horizontalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally){

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    ColoredSquares(Color.Magenta)
                    ColoredSquares(Color.Yellow)
                }
                Surface(color = Color.White, modifier = Modifier
                    .height(100.dp)
                    .width(100.dp))
                {}
                ColoredSquares(Color.Red)//Ability to reuse code
                ColoredSquares(Color.Blue)
                ColoredSquares(Color.Green)
            }

        }
    }
}

@Composable
fun ColoredSquares(color:Color){
    Surface(color = color, modifier = Modifier
        .height(100.dp)
        .width(100.dp))
    {}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoreComposeApplicationTheme {
        MainScreen()
    }
}