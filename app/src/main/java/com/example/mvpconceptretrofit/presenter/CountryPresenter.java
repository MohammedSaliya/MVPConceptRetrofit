package com.example.mvpconceptretrofit.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mvpconceptretrofit.AdapterActivity;
import com.example.mvpconceptretrofit.Model.Country;
import com.example.mvpconceptretrofit.Model.Data;
import com.example.mvpconceptretrofit.R;
import com.example.mvpconceptretrofit.View.ContryView;
import com.example.mvpconceptretrofit.service.CountryService;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CountryPresenter extends AdapterActivity {

    private ContryView contryView;
    private CountryService countryService;


    public CountryPresenter(ContryView contryView) {
        this.contryView = contryView;
        if (this.countryService == null) {
            this.countryService = new CountryService();
        }
    }

    public void getCountries() {
        countryService
                .getAPI()
                .getResults().enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {


                Data data = response.body();

                    if (data != null && data.getRestResponse() != null) {
                        List<Country> result = data.getRestResponse().getResult();
                        contryView.countriesReady(result);

                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                try {
                    throw new InterruptedException("Somethinks Went Wrong!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
