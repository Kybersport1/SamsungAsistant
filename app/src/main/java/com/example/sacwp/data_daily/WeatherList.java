package com.example.sacwp.data_daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherList {
    @SerializedName("weather")
    @Expose
    private List<TwoList> weather;

    public List<TwoList> getWeather() {
        return weather;
    }

    public void setWeather(List<TwoList> weather) {
        this.weather = weather;
    }
}
