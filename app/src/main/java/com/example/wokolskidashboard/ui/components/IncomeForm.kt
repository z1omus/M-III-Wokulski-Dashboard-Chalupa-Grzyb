package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IncomeForm(){
    Spacer(Modifier.size(20.dp))
    var name by remember { mutableStateOf("") }
    var name1 by remember { mutableStateOf("") }
    var displayName by remember { mutableStateOf("") }
    OutlinedTextField(
        value = name,
        onValueChange = {
            name = it
            println("Name: $name")
        },
        label = { Text("Enter your name:") },
        singleLine = true
    )
    Spacer(Modifier.size(20.dp))
    OutlinedTextField(
        value = name1,
        onValueChange = {
            name1 = it
            println("Name: $name1")
        },
        label = { Text("Enter your name:") },
        singleLine = true
    )
    Spacer(Modifier.size(20.dp))
    Button(
        modifier = Modifier,
        onClick = {
            println("Button Clicked")
        }) {
        Text("Show name")
    }

}