package com.example.wokolskidashboard.ui.components

import android.R.attr.name
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldFun(
    desc: String
){
    var name by remember { mutableStateOf("") }
    OutlinedTextField(
        value = name,
        onValueChange = {
            name = it
            println("Name: $name")
        },
        label = {Text(desc)},
        singleLine = true
    )
}
@Composable
fun MoneyFieldFun(
    desc:String
){
    var amount by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(true) }

    OutlinedTextField(
        label = { Text(desc) },
        value = amount,
        onValueChange = {
            newValue -> amount = newValue
            val number = newValue.toDoubleOrNull()
            isValid = number!=null && number>0
        },
        isError = !isValid
    )
    if(!isValid){
        Text(text = "Wprowadź liczbę większą od 0",
            color = Color.Red,
            style = MaterialTheme.typography.bodySmall)
    }

}
@Composable
fun ButtonFun(
    text: String,
    onClick:()-> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.padding(10.dp)
    ){
        Text(text)
    }
}
