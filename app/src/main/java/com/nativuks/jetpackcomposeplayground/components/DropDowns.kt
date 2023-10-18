package com.nativuks.jetpackcomposeplayground.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun DemoDropDown() {
    Column {
        BasicDropDownMenu()
        IndicatorDropDown()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    val desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natillas", "Chilaquiles")
    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            modifier = Modifier
                .clickable { isExpanded = true }
                .fillMaxWidth(),
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true
        )
        //OutlinedTextField(value = selectedText, onValueChange = { selectedText = it }, enable = false)
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = { Text(dessert) },
                    onClick = {
                        isExpanded = false
                        selectedText = dessert

                    })
            }
        }
    }
}


@Composable
fun IndicatorDropDown() {
    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")
    val disabledItem = 1
    val contextForToast = LocalContext.current.applicationContext

    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        // 3 vertical dots icon
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Open Options"
            )
        }

        // drop down menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            // adding items
            listItems.forEachIndexed { itemIndex, itemValue ->
                DropdownMenuItem(
                    text = { Text(itemValue) },
                    onClick = {
                        Toast.makeText(contextForToast, itemValue, Toast.LENGTH_SHORT)
                            .show()
                        expanded = false
                    },
                    enabled = (itemIndex != disabledItem)
                )
            }
        }
    }
}