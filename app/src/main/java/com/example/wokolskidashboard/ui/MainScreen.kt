package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.ui.components.ButtonFun
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.components.TextFieldFun
import java.nio.file.Files.size

@Composable
fun MainScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        ){
        //saldo

        //formularz
        var isChecked by remember { mutableStateOf(false) }
        Checkbox(isChecked, onCheckedChange = { checked -> isChecked = checked})
        Text("Chcesz dokonać wpłaty?")
        if(!isChecked){
            IncomeForm()
        }
    }
    }

/*
@Composable
fun SimpleInputApp(modifier: Modifier = Modifier){
    var name by remember { mutableStateOf("your name") }
    var displayName by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Simple Input App",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                println("Name: $name")
            },
            label = {Text("Enter your name:")},
            singleLine = true
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
                displayName = name
                println("Button Clicked")
            }
        ) {
            Text("Show name")
        }

        if(displayName.isNotBlank()){
            Text(
                text = "Hej, $displayName",
                style = MaterialTheme.typography.headlineMedium
            )
        }else{
            Text(modifier = Modifier
                .padding(top=25.dp)
                .align(Alignment.CenterHorizontally),
                fontSize = 20.sp,
                text = "Hej, ... nic nie wpisałeś!"
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
        var count by remember { mutableStateOf(0) }
        Button(onClick = {
            count++
            println("Button clicked $count times")
        }) {
            Text("Clicked $count times")
            println("Jestem w ciele komponetnu Button (count = $count)")
        }

    }

}
//podgląd
@Preview(showBackground = true)
@Composable
fun SimpleInputAppPreview(){
    TextFiedlButtonTextTheme{
        SimpleInputApp()
    }
}
*/
