package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun DemoRadioButons() {
    var selected by rememberSaveable { mutableStateOf("Luis") }
/*    Column() {
        BasicRadioButton()
    }*/
    ListRadioButton(selected) { selected = it }
}

@Composable
fun BasicRadioButton() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

    RadioButton(selected = false, enabled = true, onClick = { /*TODO*/ }, colors =  RadioButtonDefaults.colors(
        selectedColor = Color.Red,
        unselectedColor = Color.Yellow,
        disabledSelectedColor = Color.Green,
        disabledUnselectedColor = Color.Blue
    ))
        Text("RadioBtn 1")
    }

}

@Composable
fun ListRadioButton(name: String, onItemSelected:(String) ->Unit) {


    Column(modifier = Modifier.fillMaxWidth()){
        Row( verticalAlignment = Alignment.CenterVertically) {

            RadioButton(selected = name == "Luis", enabled = true, onClick = {onItemSelected("Luis")})
            Text("Luis")
        }

        Row( verticalAlignment = Alignment.CenterVertically) {

            RadioButton(selected = name == "Fernando", enabled = true, onClick = { onItemSelected("Fernando")})
            Text("Fernando")
        }

        Row( verticalAlignment = Alignment.CenterVertically) {

            RadioButton(selected = name == "Pepe", enabled = true, onClick = {onItemSelected("Pepe") })
            Text("Pepe")
        }

        Row( verticalAlignment = Alignment.CenterVertically) {

            RadioButton(selected = name == "Juan", enabled = true, onClick = { onItemSelected("Juan") })
            Text("Juan")
        }
    }
}