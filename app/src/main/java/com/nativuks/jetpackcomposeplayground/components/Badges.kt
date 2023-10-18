package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Satellite
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nativuks.jetpackcomposeplayground.R

@Composable
fun DemoBudges() {
    Column {
        BasicBudge()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicBudge() {
    var isBudge = rememberSaveable() { mutableStateOf(true) }
 BadgedBox(modifier = Modifier.padding(10.dp),badge =  { Badge { Text("10") } }) {
     Icon(painter = painterResource(id = R.drawable.credit_card_check) , contentDescription = "" )
 }
}