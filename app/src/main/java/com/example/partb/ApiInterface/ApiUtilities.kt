package com.example.partb.ApiInterface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  ApiUtilities {
    private const val BASE_URL ="https://v6.exchangerate-api.com/v6/144fd292bc37de3553dc2e47/"

    fun getInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}
