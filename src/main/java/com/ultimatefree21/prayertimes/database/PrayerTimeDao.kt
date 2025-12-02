package com.ultimatefree21.prayertimes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ultimatefree21.prayertimes.model.PrayerTime
import kotlinx.coroutines.flow.Flow

@Dao
interface PrayerTimeDao {
    @Insert
    suspend fun insertPrayerTime(prayerTime: PrayerTime)

    @Query("SELECT * FROM prayer_times WHERE date = :date LIMIT 1")
    fun getPrayerTimeByDate(date: String): Flow<PrayerTime?>

    @Query("SELECT * FROM prayer_times ORDER BY date DESC")
    fun getAllPrayerTimes(): Flow<List<PrayerTime>>

    @Query("DELETE FROM prayer_times WHERE date = :date")
    suspend fun deletePrayerTimeByDate(date: String)
}