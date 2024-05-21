// Handle API requests

package com.example.currencyconverter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("latest")
    suspend fun getRates(@Query("base") base: String, @Query("access_key") apiKey: String):  CurrencyResponse

    companion object {
        private const val BASE_URL= "https://api.freecurrencyapi.com/v1/"
        internal const val API_KEY = "fca_live_SnjMynmRd2nl3dte7zzFTW9HxH5qAj0jrFtGOCGj"

        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}