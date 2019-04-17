package com.example.sacwp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sacwp.api.NetworkService;
import com.example.sacwp.data.City;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bottom_sheet extends BottomSheetDialogFragment {
    public final String APPID = "693bc5884d2a585cdb170d137f0da55a";
    public final String UNITS = "metric";
    TextView minTempOne;
    TextView maxTempOne;
    TextView vlagaOne;
    TextView windSpeedOne;
    String maxTempTwo;
    String minTempTwo;
    String vlagaTwo;
    String windSpeedTwo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet,container,false);
        minTempOne = v.findViewById(R.id.minTemp);
        maxTempOne = v.findViewById(R.id.maxTemp);
        vlagaOne = v.findViewById(R.id.vlaga);
        windSpeedOne = v.findViewById(R.id.windSpeed);
        NetworkService.getInstance()
                .getCityApi()
                .getCity("Вінниця",APPID,UNITS)
                .enqueue(new Callback<City>() {
                    @Override
                    public void onResponse(Call<City> call, Response<City> response) {
                        if (response.isSuccessful()) {
                            City city = response.body();
                            showMaxTemp(city);
                            maxTempOne.setText("Максимальная температура: " +maxTempTwo+ "°");
                            showMinTemp(city);
                            minTempOne.setText("Минимальная температура: "+ minTempTwo +"°");
                            showHumidity(city);
                            vlagaOne.setText("Влажность: "+vlagaTwo);
                            showWindSpeed(city);
                            windSpeedOne.setText("Скорость ветра: "+windSpeedTwo);
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<City> call, Throwable t) {

                    }

                });
        return v;
    }

    private void showMaxTemp(City city){
        double temp = city.getMain().getTemp_max();
        maxTempTwo = String.valueOf(temp);
    }

    private void showMinTemp(City city){
        double temp = city.getMain().getTemp_min();
        minTempTwo = String.valueOf(temp);
    }

    private void showHumidity(City city){
        double temp = city.getMain().getHumidity();
        vlagaTwo = String.valueOf(temp);
    }

    private void showWindSpeed(City city){
        double temp = city.getWind().getSpeed();
        windSpeedTwo = String.valueOf(temp);
    }


    public void setText(String vlaga , String windSpeed , String maxTemp, String minTemp){
        minTempOne.setText(minTemp);
        maxTempOne.setText(maxTemp);
        windSpeedOne.setText(windSpeed);
        vlagaOne.setText(vlaga);
    }
}
