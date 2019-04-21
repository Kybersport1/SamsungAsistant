package com.example.sacwp.api_daily;

import com.example.sacwp.api.CityApi;
import com.example.sacwp.api.NetworkService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkServiceDaily {
    private static NetworkServiceDaily instance;
    private static final Object lock = new Object();
    // объекты Retrofit и базовая ссылка для запросов
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private Retrofit retrofit;

    private NetworkServiceDaily() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkServiceDaily getInstance() {
        // создание или возврат нашего сервиса для запросов
        if (instance == null)
            synchronized (lock) {
                if (instance == null)
                    instance = new NetworkServiceDaily();
            }
        return instance;
    }

    public DailyApi getDailyApi() {

        return retrofit.create(DailyApi.class);
    }
}
