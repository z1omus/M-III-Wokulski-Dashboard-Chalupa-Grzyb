package com.example.wokolskidashboard.ui.components
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.MainScreen

@Composable
fun ExpenseForm(onSubmit: (Transaction) -> Unit) {
    var name by remember {mutableStateOf("")}
    var amount by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }
    var isImportant by remember { mutableStateOf(false) }
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
        Text("Wydatek zbyteczny")
        Switch(modifier = Modifier.padding(10.dp),
            checked = isImportant, onCheckedChange = {isImportant = it})

        ButtonFun("Zapisz", onClick = {
            val transaction = Transaction(name, amount.toDouble(), isIncome = false,isImportant)
            onSubmit(transaction)
            name="";amount="";isValid=false;
        },
            backgroundColor = Color.Gray,
            enabled = isFormValid)

    }
}

@Preview(showBackground = true)
@Composable
fun ExpenseFormPreview(){
    MainScreen()
}
