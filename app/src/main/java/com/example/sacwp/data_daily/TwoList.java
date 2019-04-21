package com.example.sacwp.data_daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TwoList {
    @SerializedName("main")
    @Expose
    private String main;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
