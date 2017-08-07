package com.example.tony.kodeutair.adapters.WeatherAdapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tony.kodeutair.R;
import com.example.tony.kodeutair.model.modelweather.WeatherCities;
import com.example.tony.kodeutair.view.weatherview.WeatherCityOneFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tony on 6/08/17.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    WeatherCityOneFragment weatherCityOneFragment;
    private WeatherCities weatherCities;
    private CardView v;

    public WeatherAdapter(WeatherCityOneFragment weatherCityOneFragment, WeatherCities weatherCities) {
        this.weatherCityOneFragment = weatherCityOneFragment;
        this.weatherCities = weatherCities;

    }

    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_weather, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.ViewHolder holder, int position) {
        holder.temperatureWeatherTv.setText("Температура воздуха: " + String.valueOf(weatherCities.getList().get(position).getMain().getTemp()) + " K");
        holder.datewWeatherTv.setText("Дата: " + weatherCities.getList().get(position).getDtTxt());
        holder.windWeatherTv.setText("Скорость ветра: " + String.valueOf(weatherCities.getList().get(position).getWind().getSpeed()) + " м/c");
    }

    @Override
    public int getItemCount() {
        return weatherCities.getList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.date_weather_tv)
        TextView datewWeatherTv;
        @BindView(R.id.temperature_weather_tv)
        TextView temperatureWeatherTv;
        @BindView(R.id.wind_weather_tv)
        TextView windWeatherTv;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
