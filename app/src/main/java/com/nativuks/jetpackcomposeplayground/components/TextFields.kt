package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DemoTextFields() {
    Column(modifier = Modifier.fillMaxSize()) {
        MyBasicTextField()
        MyBasicTextFieldBoxDecoration()
        MyOutLineTextField()
        TextFieldWithInputType()
        CustomTextField()
    }

}


@Composable
fun MyBasicTextField() {
    var value by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.border(1.dp, Color.Red)) {
        Column {
            Text("Basic Text Field")
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp),
                value = value,
                onValueChange = { newText ->
                    value = newText
                }
            )
        }

    }

}

@Composable
fun MyBasicTextFieldBoxDecoration() {
    var value by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 64.dp) // margin left and right
                    .fillMaxWidth()
                    .background(color = Color(0xFFD2F3F2), shape = RoundedCornerShape(size = 16.dp))
                    .border(
                        width = 2.dp,
                        color = Color(0xFFAAE9E6),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .padding(all = 16.dp), // inner padding
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Favorite icon",
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(width = 8.dp))
                innerTextField()
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOutLineTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Number Input Type") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
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
        label = { Text("Label") },
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