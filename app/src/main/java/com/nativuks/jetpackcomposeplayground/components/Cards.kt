package com.nativuks.jetpackcomposeplayground.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nativuks.jetpackcomposeplayground.R

@Composable
fun DemoCards() {
    Column(modifier = Modifier.fillMaxWidth()) {
        BasicCard()
        MyElevatedCard()
        MyOutlinedCard()
    }
}

@Composable
fun BasicCard() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        elevation = CardDefaults.cardElevation(
                defaultElevation = 25.dp),
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(2.dp,Color.Gray),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
        )) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Card1")
        Text("Card2")
        Text("Card2")
    }
    }
}

@Composable
fun MyElevatedCard() {
    ElevatedCard {
        Column {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(shape = RoundedCornerShape(12.dp)),
                painter = painterResource(id = R.drawable.alley),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 16.dp),
                text = "New Music",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun MyOutlinedCard() {
    OutlinedCard(
        border = BorderStroke(width = 1.dp, color = Color.Gray)
    ) {
        Column {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .clip(shape = RoundedCornerShape(12.dp)),
                painter = painterResource(id = R.drawable.alley),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 16.dp),
                text = "New Music",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}