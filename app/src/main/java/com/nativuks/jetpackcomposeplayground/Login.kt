package com.nativuks.jetpackcomposeplayground

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nativuks.jetpackcomposeplayground.ui.theme.loginFont

@Preview
@Composable
fun Login() {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red)) {
        val (logoContainer, signUpContainer,) = createRefs()
        val topGuide = createGuidelineFromTop(0f)
        Box(modifier = Modifier
            .padding(3.dp)
            .constrainAs(logoContainer) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(signUpContainer.top, margin = 70.dp)

            }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Path", color = Color.White, fontSize = 90.sp,  style = TextStyle(fontFamily = FontFamily.Cursive))
                Text("Beautiful, Private Sharing", fontSize = 18.sp, color = loginFont )
            }
        }


        Box(modifier = Modifier

            .constrainAs(signUpContainer) {
                top.linkTo(logoContainer.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 5.dp)

            }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.SpaceBetween) {
                var count by remember {
                    mutableStateOf(0)
                }

                SignUpBUtton()

                Text("Already have a Path account?", modifier = Modifier.padding(top = 25.dp, bottom = 25.dp), fontSize = 18.sp, color = Color.Yellow )
                LoginButton()
                TermAndConditions()
            }
        }
    }
}

@Composable
fun SignUpBUtton() {
    var count by remember {
        mutableStateOf(0)
    }

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            //count++
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = "Sign Up",
            style = TextStyle(
                color = Color.Red,
                fontSize = 24.sp
            )
        )
    }
}



@Composable
fun LoginButton() {
    val checkedState = remember { mutableStateOf(true) }
    var enabled by remember {
        mutableStateOf(true)
    }
    Column {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .height(70.dp)
,
            enabled = enabled,
            border = BorderStroke(1.dp,color = Color.Yellow),

            onClick = {

                enabled = !enabled

            },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Log In",
                style = TextStyle(
                    color = Color.Yellow,
                    fontSize = 20.sp
                )
            )
        }

    }

}

@Composable
fun TermAndConditions() {
    Column(modifier = Modifier.padding(top = 25.dp) ,horizontalAlignment = Alignment.CenterHorizontally) {
        Text("By using this app, you agree to", fontSize = 18.sp)
        Row(){
            Text("Path's", fontSize = 18.sp, modifier = Modifier.padding(end = 10.dp))
            Text("Terms of use", color = Color.White, fontSize = 18.sp, textDecoration = TextDecoration.Underline)
            Text("And",fontSize = 18.sp, modifier = Modifier.padding(start = 10.dp,end = 10.dp))
            Text("Privacy", color = Color.White, fontSize = 18.sp, textDecoration = TextDecoration.Underline )
        }
        Text("Policy", color = Color.White, fontSize = 18.sp, textDecoration = TextDecoration.Underline )
    }
}