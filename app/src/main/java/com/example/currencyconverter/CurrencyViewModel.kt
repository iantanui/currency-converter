// Handles the logic

package com.example.currencyconverter

import android.util.Log
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
                val response = apiService.getRates(base, ApiService.API_KEY)
                rates = response.rates

                Log.d("CurrencyViewModel", "JSON Response: $response")

            } catch (e: Exception) {
                errorMessage = e.message ?: "An error occurred"
            }
        }
    }

    // Dummy data for preview
    fun setDummyData() {
        rates = mapOf(
            "EUR" to 0.85,
            "GBP" to 0.75,
            "JPY" to 110.0
        )
    }
}