package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

/*
@Composable
fun IncomeForm(
    name: String,
    amount: Double,
    isIncome: Boolean = true
): Transaction {
    return Transaction(name, amount, isIncome)
}*/

@Composable
fun IncomeForm(onSubmit: (Transaction) -> Unit) {
    var name by remember {mutableStateOf("")}
    var amount by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }
    val isFormValid = name.isNotBlank() && isValid

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextFieldFun(
            desc = "Podaj nazwę towaru: ",
            value = name,
            onChange = {name = it}
            )


        MoneyFieldFun(
            desc = "Podaj cenę towaru (w rublach): ",
            value = amount,
            onChange = {amount = it
            var number = amount.toDoubleOrNull()
                       if(number==null || number<=0)isValid=false else isValid=true},
            isError = !isValid
            )


        ButtonFun("Zapisz", onClick = {
            val transaction = Transaction(name, amount.toDouble(), isIncome = true)
            onSubmit(transaction)
            name="";amount="";isValid=false
        },
            backgroundColor = Color.Gray,
        enabled = isFormValid)
    }
}
