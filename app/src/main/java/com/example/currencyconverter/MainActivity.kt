package com.example.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconverter.ui.theme.CurrencyConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyConverter()
                }
            }
        }
    }
}

@Composable
fun CurrencyConverter() {
    var amount by remember { mutableStateOf("1.0") }
    val baseCurrency by remember { mutableStateOf("USD") }
    var targetCurrency by remember { mutableStateOf("EUR") }
    val convertedAmount by remember { mutableStateOf("") }

    LaunchedEffect(baseCurrency) {

    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            "Currency Converter",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = amount,
            onValueChange = { amount = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 18.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = targetCurrency,
            onValueChange = { targetCurrency = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 18.sp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ }
        ) {
            Text("Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Converted Amount: $convertedAmount",
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CurrencyConverterTheme {
        CurrencyConverter()
    }
}