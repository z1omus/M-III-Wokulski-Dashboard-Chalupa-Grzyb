package com.example.wokolskidashboard.ui.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun BalanceHeader(
    saldo: Double
){
    Column(modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp)){
        Text("$saldo Rubli", fontSize = 30.sp)
    }

}

