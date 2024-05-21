// Handles the logic

package com.example.currencyconverter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CurrencyViewModel : ViewModel() {

    private val apiService = ApiService.create()
    var rates by mutableStateOf<Map<String, Double>>(emptyMap())
    var errorMessage by mutableStateOf("")

    fun fetchRates(base: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getRates(base)
                rates = response.rates
            } catch (e: Exception) {
                errorMessage = e.message ?: "An error occurred"
            }
        }
    }
}