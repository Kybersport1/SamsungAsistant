package com.example.sacwp.api_daily;

import com.example.sacwp.data.City;
import com.example.sacwp.data_daily.Daily;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DailyApi {
    @GET("daily")
    Call<Daily> getDaily(@Query("q") String city, @Query("units") String units, @Query("APPID") String appid);
}
