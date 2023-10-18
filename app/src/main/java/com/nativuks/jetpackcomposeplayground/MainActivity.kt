package com.nativuks.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nativuks.jetpackcomposeplayground.components.CheckWithTetxCompleted
import com.nativuks.jetpackcomposeplayground.components.CustomTextField
import com.nativuks.jetpackcomposeplayground.components.DemoBudges
import com.nativuks.jetpackcomposeplayground.components.DemoButtons
import com.nativuks.jetpackcomposeplayground.components.DemoCards
import com.nativuks.jetpackcomposeplayground.components.DemoCheck
import com.nativuks.jetpackcomposeplayground.components.DemoDropDown
import com.nativuks.jetpackcomposeplayground.components.DemoImages
import com.nativuks.jetpackcomposeplayground.components.DemoProgressBar
import com.nativuks.jetpackcomposeplayground.components.DemoRadioButons
import com.nativuks.jetpackcomposeplayground.components.DemoSliders
import com.nativuks.jetpackcomposeplayground.components.DemoSwicth
import com.nativuks.jetpackcomposeplayground.components.DemoTextFields
import com.nativuks.jetpackcomposeplayground.components.Demodialogs
import com.nativuks.jetpackcomposeplayground.models.CheckInfo
import com.nativuks.jetpackcomposeplayground.screens.InstagramLogin

import com.nativuks.jetpackcomposeplayground.screens.Login
import com.nativuks.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   // Greeting("Android")
                    //DemoButtons()
                    //Login()
                    //ConstraitExampleLayout()
                    //DemoTextFields()
                    //DemoImages()
                    //DemoProgressBar()
                    //DemoSwicth()
                    //DemoCheck()
                    //DemoRadioButons()
                    //DemoCards()
                    //DemoBudges()
                    //DemoDropDown()
                    //DemoSliders()
                    //Demodialogs()
                    InstagramLogin()

                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePlaygroundTheme {
        Greeting("Android")
    }
}