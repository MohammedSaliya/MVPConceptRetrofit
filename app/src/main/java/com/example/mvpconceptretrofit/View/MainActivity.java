package com.example.mvpconceptretrofit.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mvpconceptretrofit.AdapterActivity;
import com.example.mvpconceptretrofit.Model.Country;
import com.example.mvpconceptretrofit.Model.Data;
import com.example.mvpconceptretrofit.R;
import com.example.mvpconceptretrofit.presenter.CountryPresenter;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ContryView {

    RecyclerView recyclerView;
    AdapterActivity adapterActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        CountryPresenter countryPresenter = new CountryPresenter(this);
        countryPresenter.getCountries();

    }

    @Override
    public void countriesReady(List<Country> countries) {
        for (Country country : countries) {
            Log.i("Retrofit", country.getName() + "\n"
                    + "-Alpha2:" + country.getAlpha2Code() + "\n"
                    + "-Alph3:" + country.getAlpha3Code());


            FancyToast.makeText(this, country.getName() + "\n"
                            + country.getAlpha2Code() + "\n"
                            + country.getAlpha3Code(), FancyToast.LENGTH_LONG,
                    FancyToast.SUCCESS, R.drawable.eagle, false).show();

            adapterActivity = new AdapterActivity(this,  countries);
            recyclerView.setAdapter(adapterActivity);
            adapterActivity.notifyDataSetChanged();


        }

    }
}
