package com.example.sacwp.api;

import com.example.sacwp.SecondActivity;
import com.example.sacwp.data.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CityApi {
    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("APPID") String appId, @Query("units") String units);
}
