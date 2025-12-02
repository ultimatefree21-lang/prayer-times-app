package com.ultimatefree21.prayertimes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ultimatefree21.prayertimes.model.PrayerTime
import com.ultimatefree21.prayertimes.database.PrayerTimeDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PrayerTimeViewModel(private val dao: PrayerTimeDao) : ViewModel() {

    private val _prayerTimes = MutableStateFlow<List<PrayerTime>>(emptyList())
    val prayerTimes: StateFlow<List<PrayerTime>> = _prayerTimes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadPrayerTimes()
    }

    private fun loadPrayerTimes() {
        viewModelScope.launch {
            dao.getAllPrayerTimes().collect { times ->
                _prayerTimes.value = times
            }
        }
    }

    fun insertPrayerTime(prayerTime: PrayerTime) {
        viewModelScope.launch {
            dao.insertPrayerTime(prayerTime)
        }
    }

    fun getPrayerTimeForDate(date: String) {
        viewModelScope.launch {
            dao.getPrayerTimeByDate(date).collect { time ->
                if (time != null) {
                    _prayerTimes.value = listOf(time)
                }
            }
        }
    }
}