package com.example.partb.ApiInterface

import com.example.partb.model.ExchangeRateData
import retrofit2.Response
import retrofit2.http.GET

// this class will tell us the interface of our APIS
interface ApiInterface {
    @GET("latest/USD")
    // the data organization will be the one defined in Jokes
    suspend fun getRates():Response<ExchangeRateData>
}