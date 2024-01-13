package com.example.partb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.partb.database.ConversionRate
import com.example.partb.model.ExchangeRateData
import com.example.partb.repository.RatesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RatesViewModel(private val repository: RatesRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {

                repository.getRatesFor()
        }
    }

    val rates : MutableLiveData<ExchangeRateData?> get()=repository.rates

    fun insertConversionRate(conversionRate: ConversionRate) {
        viewModelScope.launch {
            repository.insertConversionRate(conversionRate)
        }
    }

}