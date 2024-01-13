package com.example.partb.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.partb.repository.RatesRepository

class RatesViewModelFactory(private val memesRepository: RatesRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RatesViewModel(memesRepository) as T
    }
}