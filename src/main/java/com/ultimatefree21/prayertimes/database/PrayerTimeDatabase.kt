package com.ultimatefree21.prayertimes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ultimatefree21.prayertimes.model.PrayerTime

@Database(entities = [PrayerTime::class], version = 1, exportSchema = false)
abstract class PrayerTimeDatabase : RoomDatabase() {
    abstract fun prayerTimeDao(): PrayerTimeDao

    companion object {
        @Volatile
        private var INSTANCE: PrayerTimeDatabase? = null

        fun getDatabase(context: Context): PrayerTimeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PrayerTimeDatabase::class.java,
                    "prayer_time_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}