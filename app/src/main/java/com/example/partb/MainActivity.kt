package com.example.partb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partb.ApiInterface.ApiInterface
import com.example.partb.ApiInterface.ApiUtilities
import com.example.partb.database.ConversionRate
import com.example.partb.database.RatesDatabase
import com.example.partb.repository.RatesRepository
import com.example.partb.viewModel.RatesViewModel
import com.example.partb.viewModel.RatesViewModelFactory

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: RatesViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val database = RatesDatabase.getDatabase(applicationContext)
        val conversionRateDao = database.conversionRateDao()
        val repository = RatesRepository(apiInterface, conversionRateDao)

        viewModel = ViewModelProvider(this, RatesViewModelFactory(repository))[RatesViewModel::class.java]


        viewModel.rates.observe(this) { rates ->
            val conversionRates = rates?.conversion_rates
            conversionRates?.let {
                for ((key, value) in it.entries) {
                    val conversionRate = ConversionRate(currencyCode = key, conversionRate = value)
                    viewModel.insertConversionRate(conversionRate)
                }
            }
            val adapter = conversionRates?.let { ConversionRateAdapter(it) }
            recyclerView.adapter = adapter
        }
    }
}
