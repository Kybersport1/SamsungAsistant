package com.example.sacwp.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService instance;
    private static final Object lock = new Object();
    // объекты Retrofit и базовая ссылка для запросов
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        // создание или возврат нашего сервиса для запросов
        if (instance == null)
            synchronized (lock) {
                if (instance == null)
                    instance = new NetworkService();
            }
        return instance;
    }

    public CityApi getCityApi() {

        return retrofit.create(CityApi.class);
    }
}
