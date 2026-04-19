package com.example.wokolskidashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.R
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.ButtonFun
import com.example.wokolskidashboard.ui.components.IncomeForm

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .background(Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val transactions = remember { mutableStateListOf<Transaction>() }
            var saldo: Double = 0.0

            var isCheckedIncome by remember { mutableStateOf(false) }
            var isCheckedExpense by remember { mutableStateOf(false) }
            val incomeButtonColor = remember(isCheckedIncome) {
                if (isCheckedIncome) Color.Gray else Color.LightGray
            }
            val expenseButtonColor = remember(isCheckedIncome) {
                if (isCheckedExpense) Color.Gray else Color.LightGray
            }
            //saldo
            Text(modifier = Modifier.padding(20.dp), text = "SALDO ${saldo}")


            //formularz
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    ButtonFun(
                        text = "Zysk",
                        onClick = { isCheckedIncome = true; isCheckedExpense = false },
                        modifier = Modifier.background(incomeButtonColor).padding(25.dp),
                        backgroundColor = incomeButtonColor
                    )
                    ButtonFun(
                        text = "Wydatek",
                        onClick = { isCheckedExpense = true; isCheckedIncome = false },
                        modifier = Modifier.background(expenseButtonColor).padding(25.dp),
                        backgroundColor = expenseButtonColor
                    )
                }
                if (isCheckedIncome == true) {
                    IncomeForm { transaction -> transactions.add(transaction);saldo+=transaction.amount }
                } else if (isCheckedExpense == true) {
                    //ExpenseForm()
                    Text("Expenses form")
                }
            }
            //transactions
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (i in transactions) {
                    Text("${i.name}, ${i.amount} rubli, ${i.isIncome}")
                }
            }

        }
    }
}



        /*ExpenseForm(
                expenseName = expenseName,
                expenseValue = expenseValue,
                isWasteful = isWasteful,
                expenseNameChanged = {expenseName = it},
                expenseValueChanged = {expenseValue = it.toDouble()},
                isWastefulValueChanged = {isWasteful = it},
                {
                    val expense = Transaction(nextExpenseId, expenseName, expenseValue, false, isWasteful)
                    expenseList.add(expense)
                    nextExpenseId++
                }
            )
            Spacer(Modifier.height(10.dp))
            LazyColumn() {
                items(expenseList.size, itemContent = { index ->
                    val expense = expenseList[index]
                    for(e in expense) println(e)
                    //TransactionCard(expense)
                })*/


/*@Composable
fun MainScreen(modifier: Modifier = Modifier){
    var expenseName by remember { mutableStateOf("") }
    var expenseValue by remember { mutableDoubleStateOf(0.0) }
    var isWasteful by remember { mutableStateOf(false) }
    var nextExpenseId by remember { mutableIntStateOf(1)}
    var expenseList = remember { mutableStateListOf<Transaction>()}


    Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        ExpenseForm(
            expenseName = expenseName,
            expenseValue = expenseValue,
            isWasteful = isWasteful,
            expenseNameChanged = {expenseName = it},
            expenseValueChanged = {expenseValue = it.toDouble()},
            isWastefulValueChanged = {isWasteful = it},
            {
                val expense = Transaction(nextExpenseId, expenseName, expenseValue, false, isWasteful)
                expenseList.add(expense)
                nextExpenseId++
            }
        )
        Spacer(Modifier.height(10.dp))
        LazyColumn() {
            items(expenseList.size, itemContent = { index ->
                val expense = expenseList[index]
                TransactionCard(expense)
            })
        }
    }
}*/

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


*/
//podgląd
@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
        MainScreen()
}
