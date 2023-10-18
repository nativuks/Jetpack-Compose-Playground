package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DemoProgressBar() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    var progressCounter by rememberSaveable { mutableStateOf(0f) }
    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
       if(showLoading){
           MyCircularProgressBar()
           MyLinearProgressBar()
       }else{
           CustomProgressBar(progressCounter)
           Row(Modifier.fillMaxWidth()) {
               Button(onClick = { progressCounter += 0.25f}) {
                   Text("Increase")
               }

               Button(onClick = { progressCounter -= 0.25f}) {
                   Text("Decrease")
               }
           }

       }
       Button(onClick = { showLoading = !showLoading}) {
           Text("Enable/Disable")
       }
    }
}
@Composable
fun MyCircularProgressBar() {
    CircularProgressIndicator(color = Color.Red, strokeWidth = 10.dp)

}

@Composable
fun MyLinearProgressBar() {
    LinearProgressIndicator(modifier = Modifier.padding(top = 20.dp), color = Color.Red, trackColor = Color.Green)
}

@Composable
fun CustomProgressBar(progress: Float) {
    CircularProgressIndicator(progress = progress)
}