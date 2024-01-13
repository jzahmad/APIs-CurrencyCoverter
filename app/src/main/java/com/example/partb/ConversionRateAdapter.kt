package com.example.partb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConversionRateAdapter(private val conversionRates: Map<String, Double>) :
    RecyclerView.Adapter<ConversionRateAdapter.ConversionRateViewHolder>() {

    class ConversionRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val currencyTextView: TextView = itemView.findViewById(R.id.currencyTextView)
        val rateTextView: TextView = itemView.findViewById(R.id.rateTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversionRateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_conversion_rate, parent, false)
        return ConversionRateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ConversionRateViewHolder, position: Int) {
        val currencyCodes = conversionRates.keys.toList()
        val currentCurrencyCode = currencyCodes[position]
        val currentRate = conversionRates[currentCurrencyCode]

        holder.currencyTextView.text = currentCurrencyCode
        holder.rateTextView.text = currentRate?.toString() ?: "N/A"
    }

    override fun getItemCount(): Int {
        return conversionRates.size
    }
}
