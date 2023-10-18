package com.nativuks.jetpackcomposeplayground.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nativuks.jetpackcomposeplayground.R

@Composable

fun Demodialogs() {
    Column() {
        var isAlert by remember { mutableStateOf(false) }
        var isDialog by remember { mutableStateOf(false) }
        var isCustomDialog by remember { mutableStateOf(false) }
        var isAdvancedDialog by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier.padding(10.dp).horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { isAlert = true }) {
                Text("Mostrar Alert")
            }
            Button(onClick = { isDialog = true }) {
                Text("Mostrar Dialog")
            }
            Button(onClick = { isCustomDialog = true }) {
                Text("Custom Dialog")
            }

            Button(onClick = { isAdvancedDialog = true }) {
                Text("Advanced Dialog")
            }
        }

        if (isAlert) {
            BasicAlert(
                onDismiss = { isAlert = false },
                onConfirm = { isAlert = false })
        }

        if (isDialog) {
            BasicDialog(
                isDialog,
                onDismiss = { isDialog = false },
            )
        }

        if (isCustomDialog) {
            CustomDialog(
                isCustomDialog,
                onDismiss = { isCustomDialog = false },
            )
        }
        //AdvancedDialog

        if (isAdvancedDialog) {
            AdvancedDialog(
                isAdvancedDialog,
                onDismiss = { isAdvancedDialog = false },
            )
        }

    }


}

@Composable
fun BasicAlert(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("Confirm Button")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(" Dismiss Button")
            }
        },
        text = { Text("Texto") },
        title = { Text("Titulo") }
    )

}

@Composable
fun BasicDialog(isShow: Boolean, onDismiss: () -> Unit) {
    if (isShow) {

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                //dismissOnBackPress = false,
                // dismissOnClickOutside = false
            )
        ) {
            Column(
                modifier = Modifier.height(70.dp).width(300.dp).background(Color.LightGray)
                    .padding(24.dp)
            ) {
                Text("Estee es un dialog")
                Text("Estee es un dialog")
                Text("Estee es un dialog")
            }

        }


    }
}

@Composable
fun CustomDialog(isShow: Boolean, onDismiss: () -> Unit) {
    if (isShow) {
        Box(modifier = Modifier.background(Color.White).clip(RoundedCornerShape(50.dp))){
            Dialog(onDismissRequest = { onDismiss() }, properties = DialogProperties()) {
                Column(modifier = Modifier.background(Color.White).padding(15.dp)) {
                    TitleDialog("Set background account")
                    AccountItem("fher@gmail.com", R.drawable.alley)
                    AccountItem("guest@gmail.com", R.drawable.avatar)
                    AccountItem("add account", R.drawable.add)
                }

            }
        }

    }
}

@Composable
fun AdvancedDialog(isShow: Boolean, onDismiss: () -> Unit) {
    if(isShow) {

           Dialog(onDismissRequest = {onDismiss() }){
               var status by remember{ mutableStateOf("") }
               Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))) {
                   Column(modifier = Modifier.fillMaxWidth().background(Color.White), verticalArrangement = Arrangement.Center) {
                       TitleDialog("Phone ringtone", modifier = Modifier.padding(24.dp))
                       Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                       ListRadioButton(status) { status = it }
                       Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                       Row(modifier = Modifier.align(Alignment.End).padding(8.dp)){
                           TextButton(onClick = {}){
                               Text("CANCEL")
                           }

                           TextButton(onClick = {}){
                               Text("OK")
                           }
                       }

                   }
               }

           }



    }
}


@Composable
fun TitleDialog(title: String, modifier:Modifier = Modifier.padding(bottom = 12.dp) ){
    Text(
        title,
        modifier = modifier,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.padding(8.dp).size(40.dp).clip(CircleShape),
            painter = painterResource(drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop
        )

        Text(email, modifier = Modifier.padding(8.dp), fontSize = 14.sp, color = Color.Gray)
    }
}