package com.example.wokolskidashboard.ui.components

import android.R.attr.name
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldFun(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)) {
        TextField(
            value = "www",
            onValueChange = {},
            label = { Text("enter") },
            singleLine = true
        )
    }
}
@Composable
fun SimpleInputOutput(modifier: Modifier = Modifier){

    var name by remember { mutableStateOf("your name") }
    var displayName by remember { mutableStateOf("") }

    Button(

        onClick = {
            displayName = name
            println("Button Clicked")
        }) {
        Text("Show name")
    }

    if(displayName.isNotBlank()){
        Text(
            text = "Hej, $displayName !",
            style = MaterialTheme.typography.headlineSmall
        )
    } else {
        Text(modifier = Modifier
            .padding(top = 24.dp),
            fontSize = 20.sp,
            text="Hej, ... ?")
    }
}