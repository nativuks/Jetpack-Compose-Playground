package com.nativuks.jetpackcomposeplayground.components

import com.nativuks.jetpackcomposeplayground.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyOff
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun DemoImages() {
    Column(modifier= Modifier.verticalScroll(rememberScrollState())) {
        MyImage()
        MyImageWithAlpha()
        CircularImages()
        MyIcon()
        MyIconFromDrawable()
    }
}


@Composable
fun MyImage() {
    Image(painter = painterResource(id = R.drawable.alley), contentDescription = "escription")
}

@Composable
fun MyImageWithAlpha() {
    Image(
        painter = painterResource(id = R.drawable.alley),
        contentDescription = "escription",
        modifier = Modifier.alpha(0.5F)
    )
}


@Composable
fun CircularImages() {
    Image(
        painter = painterResource(id = R.drawable.alley),
        contentDescription = "escription",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.KeyOff, contentDescription = "Description", tint = Color.Red)
}

@Composable
fun MyIconFromDrawable() {
    Icon(painter = painterResource(id = R.drawable.credit_card_check), contentDescription = "Description", tint = Color.Green)

}