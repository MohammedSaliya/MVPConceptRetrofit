package com.example.mvpconceptretrofit.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryService {

    private Retrofit retrofit = null;


    /**
     * This method creates a new instance of the API interface.
     *
     * @return The API interface
     */
    public CountryAPI getAPI() {
        String BASE_URL = "http://services.groupkt.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(CountryAPI.class);
    }
}
