package com.example.wokolskidashboard.ui.components
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun TransactionCard(
    transaction: Transaction,
){
    val CardColor = if(transaction.isIncome){Color.Green} else{Color.Red}
    Column(Modifier
        .border(3.dp, CardColor)
        .padding(10.dp)
    ){
        if(transaction.isIncome) {
            Text("${transaction.name} - ${transaction.amount}")
        }  else {
            Text("${transaction.name} - ${transaction.amount} - ${
                if(transaction.isImportant){
                    "Zbyteczny"
                }  else {
                    "Niezbyteczny"
                }
            }")
        }
    }
}


