package com.ultimatefree21.prayertimes.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.rxjava3.core.Single;

public class PrayerTimeApiClient {

    private static final String BASE_URL = "http://api.aladhan.com/v1/timings";
    private static PrayerTimeApiClient instance;
    private Retrofit retrofit;

    private PrayerTimeApiClient() {
        retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    public static PrayerTimeApiClient getInstance() {
        if (instance == null) {
            instance = new PrayerTimeApiClient();
        }
        return instance;
    }

    public interface PrayerTimeApi {
        @GET("{timestamp}")
        Single<PrayerTimeResponse> getPrayerTimes(@Path("timestamp") long timestamp, @Query("latitude") double latitude, @Query("longitude") double longitude);
    }
}