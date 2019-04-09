package com.example.sacwp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("main")
    @Expose
    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
