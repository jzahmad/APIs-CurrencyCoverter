package com.example.partb.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.partb.ApiInterface.ApiInterface
import com.example.partb.database.ConversionRate
import com.example.partb.database.ConversionRateDao
import com.example.partb.model.ExchangeRateData

class RatesRepository(
    private val apiInterface: ApiInterface
    ,private val conversionRateDao: ConversionRateDao
) {

    private val liveData = MutableLiveData<ExchangeRateData?>()
    val rates: MutableLiveData<ExchangeRateData?> get() = liveData

    suspend fun getRatesFor() {
        try {
            val result = apiInterface.getRates()
            if (result.isSuccessful) {
                val exchangeRateData = result.body()
                // Check if the response body is not null
                if (exchangeRateData != null) {
                    liveData.postValue(exchangeRateData)
                } else {
                    Log.e("RatesRepository", "API response body is null")
                }
            } else { // Handle the error, log it, or throw an exception
                Log.e("RatesRepository", "Error: ${result.code()} - ${result.message()}")
            }
        } catch (e: Exception) { // Handle exceptions
            Log.e("RatesRepository", "Exception: ${e.message}", e)
        }
    }

    suspend fun insertConversionRate(conversionRate: ConversionRate) {
        conversionRateDao.insert(conversionRate)
    }
}

