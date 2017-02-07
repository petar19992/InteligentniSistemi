package com.example.petar.inteligentnisistemi;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.petar.inteligentnisistemi.connection.Connections;
import com.example.petar.inteligentnisistemi.customComponents.DrawableView;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.models.parsing.MyWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by PETAR on 2/7/2017.
 */

public class WeatherFragment extends Fragment
{
    private TextView temperatureText;
    private ImageView temperatureImage;
    private TextView humidityText;
    private ImageView humidityImage;
    private TextView pressureText;
    private ImageView pressureImage;
    private TextView sunriseText;
    private ImageView sunriseImage;
    private TextView sunsetText;
    private ImageView sunsetImage;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-02-07 01:05:02 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews(View rootView)
    {
        temperatureText = (TextView) rootView.findViewById(R.id.temperatureText);
        temperatureImage = (ImageView) rootView.findViewById(R.id.temperatureImage);
        humidityText = (TextView) rootView.findViewById(R.id.humidityText);
        humidityImage = (ImageView) rootView.findViewById(R.id.humidityImage);
        pressureText = (TextView) rootView.findViewById(R.id.pressureText);
        pressureImage = (ImageView) rootView.findViewById(R.id.pressureImage);
        sunriseText = (TextView) rootView.findViewById(R.id.sunriseText);
        sunriseImage = (ImageView) rootView.findViewById(R.id.sunriseImage);
        sunsetText = (TextView) rootView.findViewById(R.id.sunsetText);
        sunsetImage = (ImageView) rootView.findViewById(R.id.sunsetImage);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
        findViews(rootView);
        Connections.getInstance().getWeatherInformation(Constants.getInstance().myCar, new Callback<MyWeather>()
        {
            @Override
            public void onResponse(Call<MyWeather> call, Response<MyWeather> response)
            {
                MyWeather weather = response.body();
                if (weather != null)
                {
                    temperatureText.setText(String.valueOf(weather.getTemperature())+" °C");
                    humidityText.setText(String.valueOf(weather.getHumidity())+" %");
                    pressureText.setText(String.valueOf(weather.getPressure())+" Ba");
                    sunriseText.setText(String.valueOf(weather.getSunrise())+" AM");
                    sunsetText.setText(String.valueOf(weather.getSunrise())+" PM");
                }
            }

            @Override
            public void onFailure(Call<MyWeather> call, Throwable t)
            {
                Log.i("Sda", "Gotovo");
            }
        });
        return rootView;
    }
}
