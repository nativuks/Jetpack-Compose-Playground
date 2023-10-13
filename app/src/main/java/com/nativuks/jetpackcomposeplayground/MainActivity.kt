package com.nativuks.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nativuks.jetpackcomposeplayground.components.CustomTextField
import com.nativuks.jetpackcomposeplayground.components.DemoButtons
import com.nativuks.jetpackcomposeplayground.components.DemoImages
import com.nativuks.jetpackcomposeplayground.components.DemoTextFields

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
                    DemoImages()
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