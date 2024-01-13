package com.example.partb.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ConversionRateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(conversionRate: ConversionRate)

    @Query("SELECT * FROM conversion_rates")
    fun getAllConversionRates(): LiveData<List<ConversionRate>>
}
