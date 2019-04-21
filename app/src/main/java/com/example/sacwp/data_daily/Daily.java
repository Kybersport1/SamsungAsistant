package com.example.sacwp.data_daily;

import com.example.sacwp.data.Main;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {
    @SerializedName("list")
    @Expose
    private List<WeatherList> list;

    public List<WeatherList> getList() {
        return list;
    }

    public void setList(List<WeatherList> list) {
        this.list = list;
    }
}
