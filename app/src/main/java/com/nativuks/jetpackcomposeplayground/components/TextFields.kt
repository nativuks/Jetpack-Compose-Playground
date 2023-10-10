package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField() {


    var textState by remember { mutableStateOf("") }

    val maxLength = 110
    val lightBlue = Color(0xffd8e6ff)
    val blue = Color(0xFF85ADF0)
    Text(
        text = "Custom TextField",
        modifier = Modifier
            //.fillMaxWidth()
            .padding(bottom = 4.dp),
        textAlign = TextAlign.Start,
        color = blue
    )
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
        value = textState,

        colors = TextFieldDefaults.textFieldColors(

            textColor = lightBlue,
            containerColor = blue,
            cursorColor = lightBlue,
            disabledLabelColor = lightBlue,
            focusedIndicatorColor = Color.Yellow,

            unfocusedIndicatorColor = Color.Transparent
        ),
        onValueChange = {
            if (it.length <= maxLength) textState = it
        },
        shape = RoundedCornerShape(8.dp),

        singleLine = true,
        trailingIcon = {
            if (textState.isNotEmpty()) {
                IconButton(
                    modifier = Modifier
                        //.graphicsLayer {shape = RoundedCornerShape(50.dp)  }
                        .width(48.dp)
                        .height(48.dp)
                        .padding(0.dp)
                        .clip(shape = RoundedCornerShape(100.dp)),
                    colors = IconButtonDefaults.iconButtonColors
                        (
                        containerColor = Color.White.copy(alpha = 0.1f),
                        contentColor = Color.Transparent
                    ),

                    onClick = { textState = "" }) {
                    //modifier = Modifier.background(lightBlue).clip(shape = RoundedCornerShape(50.dp)
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        tint = Color.Black,
                        contentDescription = null,

                        )
                }
            }
        },
        leadingIcon = {
            IconButton(
                colors = IconButtonDefaults.iconButtonColors
                    (
                    containerColor = Color.White.copy(alpha = 0.1f),
                    contentColor = Color.Transparent
                ),

                onClick = { textState = "" }) {
                //modifier = Modifier.background(lightBlue).clip(shape = RoundedCornerShape(50.dp)
                Icon(
                    imageVector = Icons.Outlined.Email,
                    tint = Color.Black,
                    contentDescription = null,

                    )
            }
        }
    )
    Text(
        text = "${textState.length} / $maxLength",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        textAlign = TextAlign.End,
        color = blue
    )


}