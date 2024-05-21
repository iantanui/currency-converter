package com.example.currencyconverter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("latest")
    suspend fun getRates(@Query("base") base: String):  CurrencyResponse

    companion object {
        private const val BASE_URL= ""

        fun create(): ApiService {
            return Retrofit.Builder()
                .baseurl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}