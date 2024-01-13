package com.example.partb.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conversion_rates")
data class ConversionRate(
    @PrimaryKey
    val currencyCode: String,
    val conversionRate: Double
)
