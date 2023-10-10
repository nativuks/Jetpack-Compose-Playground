package com.nativuks.jetpackcomposeplayground.components
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(100.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.TopEnd

        ) {
            Text("Esto es un Ejemplodasdasdasdasdasdasdadasdasdasdasdasdsa", modifier = Modifier.fillMaxSize())
        }
    }
}
@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            "Ejemplo1", modifier = Modifier
                .background(Color.Red)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo2", modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo3", modifier = Modifier
                .background(Color.Green)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.Magenta)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
                .height(100.dp)
        )
        Text(
            "Ejemplo4", modifier = Modifier
                .background(Color.Blue)
                .fillMaxSize()
                .height(100.dp)
        )


    }
}

@Composable
fun MyRow() {
    /*   Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
           Text("Ejemplo 1")
           Text("Ejemplo 2")
           Text("Ejemplo 3")
       }*/

    /*    Row(Modifier.fillMaxSize()){
            Text("Ejemplo 1", modifier = Modifier.weight(1f))
            Text("Ejemplo 2", modifier = Modifier.weight(1f))
            Text("Ejemplo 3", modifier = Modifier.weight(1f))
        }*/

    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text("Ejemplo 1", modifier = Modifier.width(100.dp))
        Text("Ejemplo 2", modifier = Modifier.width(100.dp))
        Text("Ejemplo 3", modifier = Modifier.width(100.dp))
        Text("Ejemplo 4", modifier = Modifier.width(100.dp))
        Text("Ejemplo 5", modifier = Modifier.width(100.dp))
        Text("Ejemplo 6", modifier = Modifier.width(100.dp))
    }
}



@Preview
@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text("Ejemplo 1")
        }
        //MySpacer(size= 30)
        Box(modifier = Modifier.background(Color.White).fillMaxWidth().height(30.dp)) {

        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
                .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(" Ejemplo 2")
            }
            MySpacer2(size = 20, false)
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Yellow), contentAlignment = Alignment.Center
            ) {
                Text("Ejemplo 3")
            }

        }
        MySpacer(size = 40)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Green),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text("Ejemplo 4")
        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MySpacer2(size: Int, isVertical: Boolean = true){
    if(isVertical) {
        Spacer(modifier = Modifier.height(size.dp))
    } else {
        Spacer(modifier = Modifier.width(size.dp))
    }
}

