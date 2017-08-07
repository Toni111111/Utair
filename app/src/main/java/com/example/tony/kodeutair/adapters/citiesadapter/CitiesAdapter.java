package com.example.tony.kodeutair.adapters.citiesadapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tony.kodeutair.R;
import com.example.tony.kodeutair.model.modelcities.CityModel;
import com.example.tony.kodeutair.view.citiesview.MainActivity;
import com.example.tony.kodeutair.view.citiesview.SelectionCityActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tony on 31/07/17.
 */

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    SelectionCityActivity selectionCityActivity;
    private ArrayList<CityModel> cities;
    private CardView v;
    private String whereCity;

    public CitiesAdapter(SelectionCityActivity selectionCityActivity, ArrayList<CityModel> cities, String whereCity) {
        this.cities = cities;
        this.selectionCityActivity = selectionCityActivity;
        this.whereCity = whereCity;

    }


    @Override
    public CitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_city, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String city = cities.get(position).getCity();
        holder.cityTv.setText(city);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectionCityActivity, MainActivity.class);
                intent.putExtra("nameCity", holder.cityTv.getText().toString());
                intent.putExtra("whereCity", whereCity);
                selectionCityActivity.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return cities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.city_tv)
        TextView cityTv;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
