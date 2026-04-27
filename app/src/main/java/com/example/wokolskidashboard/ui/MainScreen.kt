package com.example.wokolskidashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.ButtonFun
import com.example.wokolskidashboard.ui.components.ExpenseForm
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.components.TransactionCard

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
            var saldo by remember { mutableStateOf(0.0) }

            var isCheckedIncome by remember { mutableStateOf(false) }
            var isCheckedExpense by remember { mutableStateOf(false) }
            val incomeButtonColor = remember(isCheckedIncome) {
                if (isCheckedIncome) Color.Gray else Color.LightGray
            }
            val expenseButtonColor = remember(isCheckedIncome) {
                if (isCheckedExpense) Color.Gray else Color.LightGray

            }

            BalanceHeader(saldo = saldo)


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
                    ExpenseForm { transaction -> transactions.add(transaction);saldo-=transaction.amount }
                }
            }

            
            LazyColumn {
                items(transactions.reversed()) { transaction ->
                    TransactionCard(transaction = transaction)
                }
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
        MainScreen()
}


