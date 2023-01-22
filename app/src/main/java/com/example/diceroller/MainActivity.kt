package com.example.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageBitmapConfig
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

    var result by remember {
        mutableStateOf(1)
    }

    var select_roll by remember {
        mutableStateOf(0)
    }

    val dice_images = when(result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    var temp by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Guess a Roll: $select_roll",
        )
        Spacer(modifier = Modifier.height(11.dp))
        Text(text = "$temp")
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                select_roll = 1
                temp = ""
            }) {
                Text(text = "1")
            }

            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                select_roll = 2
                temp = ""
            }) {
                Text(text = "2")
            }

            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                select_roll = 3
                temp = ""
            }) {
                Text(text = "3")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                select_roll = 4
                temp = ""
            }) {
                Text(text = "4")
            }

            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                select_roll = 5
                temp = ""
            }) {
                Text(text = "5")
            }

            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                select_roll = 6
                temp = ""
            }) {
                Text(text = "6")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = dice_images),
            contentDescription = "$result"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result = (1..6).random()
            if (result == select_roll) {
                temp = "Hoooray! YOU WON!"
            } else {
                temp = "Boooo! YOU FAILED!"
            }
        }) {
            Text(text = stringResource(R.string.roll))
        }
    }
}