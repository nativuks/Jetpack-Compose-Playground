package com.nativuks.jetpackcomposeplayground


import android.content.Context
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DemoButtons() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        NormalButton()

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButtonExp()

        Spacer(modifier = Modifier.height(16.dp))

        TextButtonExp()

        Spacer(modifier = Modifier.height(16.dp))

        IconButtonExp()

        Spacer(modifier = Modifier.height(16.dp))

        IconToggleButtonExp()
    }
}

@Composable
fun SwitchDemo() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}
@Composable
fun NormalButton() {
    var count by remember {
        mutableStateOf(0)
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            count++
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = "Clicked $count time(s)",
            style = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun OutlinedButtonExp() {
    val checkedState = remember { mutableStateOf(true) }
    var enabled by remember {
        mutableStateOf(true)
    }
    Column {
        OutlinedButton(
            enabled = enabled,
            onClick = {

                enabled = !enabled

            }
        ) {
            Text(
                text = if (enabled) "Disable Me" else "I'm Disabled",
                style = TextStyle(
                    color = if (enabled) Color.Cyan else Color.LightGray,
                    fontSize = 20.sp
                )
            )
        }
        Switch(
            checked = enabled,
            onCheckedChange = { checkedState.value = it }
        )
    }

}

@Composable
fun TextButtonExp(context: Context = LocalContext.current.applicationContext) {

    TextButton(

        onClick = {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
        }) {
        Text(text = "Text Button")
    }

}

@Composable
fun IconButtonExp(context: Context = LocalContext.current.applicationContext) {

    IconButton(
        onClick = {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
        }
    ) {
        Icon(
            imageVector = Icons.Outlined.Share,
            contentDescription = "Click to share",
            tint = Color.Red
        )
    }

}

@Composable
fun IconToggleButtonExp() {

    var checked by remember {
        mutableStateOf(false)
    }

    // This is used to disable the ripple effect
    val interactionSource = remember {
        MutableInteractionSource()
    }

    IconToggleButton(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    ) {

        val tint by animateColorAsState(
            targetValue = if (checked) Color.Magenta else Color.LightGray
        )

        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite Item",
            modifier = Modifier
                .clickable(
                    indication = null, // Assign null to disable the ripple effect
                    interactionSource = interactionSource
                ) {
                    checked = !checked
                }
                .size(48.dp),
            tint = tint
        )
    }
}