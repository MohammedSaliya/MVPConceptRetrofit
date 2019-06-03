package com.example.mvpconceptretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpconceptretrofit.Model.Country;
import com.example.mvpconceptretrofit.Model.Data;
import com.example.mvpconceptretrofit.View.MainActivity;
import com.example.mvpconceptretrofit.presenter.CountryPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.ViewHolder> {


    private List<Data> dataList;


    @NonNull
    @Override
    public AdapterActivity.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.activity_adapter, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterActivity.ViewHolder viewHolder, int i) {

        viewHolder.country.setText(dataList.get(i).getRestResponse().getResult().get(i).getName());
        viewHolder.Alpha2.setText(dataList.get(i).getRestResponse().getResult().get(i).getAlpha2Code());
        viewHolder.Alpha3.setText(dataList.get(i).getRestResponse().getResult().get(i).getAlpha3Code());
    }

    @Override
    public int getItemCount() {
        return dataList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView country, Alpha2, Alpha3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.country);
            Alpha2 = itemView.findViewById(R.id.Alpha2);
            Alpha3 = itemView.findViewById(R.id.alpha3);
        }
    }
}
