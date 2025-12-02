package com.ultimatefree21.prayertimes.service

import android.location.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import android.location.LocationManager
import android.content.Context
import android.os.Looper
import android.location.LocationListener

class LocationService(private val context: Context) {

    private val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    fun getLocation(): Flow<Location?> = callbackFlow {
        val listener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                trySend(location).isSuccess
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, listener, Looper.getMainLooper())

        awaitClose { locationManager.removeUpdates(listener) }
    }
}