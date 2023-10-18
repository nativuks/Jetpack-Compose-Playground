package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.nativuks.jetpackcomposeplayground.models.CheckInfo


@Composable
fun DemoCheck() {
    val myOptions = getOptions(
        listOf(
            "Helado",
            "Refresco",
            "Gaseosa",
            "Cerveza",
            "Otros"
        )
    )
    Column(
        modifier = Modifier.fillMaxSize(),

    ) {
        BasicCheck()
        Divider(thickness = 1.dp, color = Color.Black)
        CheckWithTetx()
        Divider(thickness = 1.dp, color = Color.Black)
        myOptions.forEach{
            CheckWithTetxCompleted(it)
        }
        Divider(thickness = 1.dp, color = Color.Black)
        MyTriStatusCheckBox()
    }
}

@Composable
fun BasicCheck() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state, onCheckedChange = { state = it }, colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue


        )
    )
}

@Composable
fun CheckWithTetx() {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        var state by rememberSaveable { mutableStateOf(false) }
        Checkbox(
            checked = state, onCheckedChange = { state = it }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("My CheckBox")
    }
}


@Composable
fun CheckWithTetxCompleted(checkInfo: CheckInfo) {

        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {

            Checkbox(
                checked = checkInfo.selected,
                onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text( checkInfo.title)
        }
    }

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

  TriStateCheckbox(state = status, onClick = {
     status = when(status){
          ToggleableState.On -> ToggleableState.Off
          ToggleableState.Off -> ToggleableState.Indeterminate
          ToggleableState.Indeterminate -> ToggleableState.On
      }
  })
}

@Composable
fun getOptions(titles:List<String>):List<CheckInfo>{

    return titles.map{
        var status by rememberSaveable{ mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = {status = it}
        )
    }

}

