package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text("Esto es un ejemplo")
        Text("Esto es un ejmplo1", color = Color.Blue)
        Text("Esto es un ejmplo1", fontWeight = FontWeight.ExtraBold)
        Text("Esto es un ejmplo1", fontWeight = FontWeight.Light)
        Text("Esto es un ejmplo1", fontWeight = FontWeight.ExtraLight)
        Text("Esto es un ejmplo1", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text("Esto es un ejmplo1", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text("Esto es un ejmplo1", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text("Esto es un ejmplo1", style = TextStyle(textDecoration = TextDecoration.None))
        Text(
            "Esto es un ejmplo1", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )

        Text("Esto es un ejmplo1", textDecoration = TextDecoration.Underline)
        Text("Esto es un ejmplo1", fontSize = 30.sp)


    }

}