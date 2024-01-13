package com.example.partb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConversionRate::class], version = 1, exportSchema = false)
abstract class RatesDatabase : RoomDatabase() {

    abstract fun conversionRateDao(): ConversionRateDao

    companion object {
        @Volatile
        private var INSTANCE: RatesDatabase? = null

        fun getDatabase(context: Context): RatesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RatesDatabase::class.java,
                    "rates_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
