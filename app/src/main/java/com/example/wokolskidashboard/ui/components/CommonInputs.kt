package com.example.wokolskidashboard.ui.components

import android.R.attr.name
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OutlinedTextFieldFun(
    desc: String,
    value: String,
    onChange:(String)-> Unit
){

    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = {Text(desc)},
        singleLine = true
    )
}
@Composable
fun MoneyFieldFun(
    desc:String,
    value: String,
    onChange:(String)-> Unit,
    isError: Boolean = false
){
    OutlinedTextField(
        label = { Text(desc) },
        value = value,
        onValueChange = onChange,
        isError = isError
    )
    if(isError==true){
        Text(text = "Wprowadź liczbę większą od 0.00 [rubli]",
            color = Color.Red,
            style = MaterialTheme.typography.bodySmall)
    }
}
@Composable
fun ButtonFun(
    text: String,
    onClick:()-> Unit,
    modifier: Modifier = Modifier.padding(10.dp),
    backgroundColor:Color = LightGray,
    color: Color = Black,
    enabled: Boolean = true
){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = color
        )

    ){
        Text(text)
    }
}


