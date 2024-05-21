package com.example.currencyconverter

data class CurrencyResponse(
    val rates: Map<String, Double>,
    val base: String,
    val data: String
)