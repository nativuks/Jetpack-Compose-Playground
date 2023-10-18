package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DemoSliders() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        BasicSlider()
        Divider(thickness = 1.dp, color = Color.Black)
        AdvanceSlider()
        Divider(thickness = 1.dp, color = Color.Black)
        BasicRangeSlider()
    }
}

@Composable
fun BasicSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
    Text(sliderPosition.toString())
}

@Composable
fun AdvanceSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    var competeValue by remember { mutableStateOf("") }
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        onValueChangeFinished = { competeValue = sliderPosition.toString() },
        valueRange = 0f..10f,
        steps = 9
    )
    Text(competeValue)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..10f) }
    RangeSlider(
        value = currentRange,
        onValueChange = { currentRange = it },
        valueRange = 0f..40f,
        steps = 9
    )
        Text("Valor inferior ${currentRange.start.toString()}")
        Text("Valor Superior ${currentRange.endInclusive.toString()}")



}