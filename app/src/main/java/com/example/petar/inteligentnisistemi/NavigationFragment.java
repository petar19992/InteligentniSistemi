package com.example.petar.inteligentnisistemi;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.petar.inteligentnisistemi.connection.Connections;
import com.example.petar.inteligentnisistemi.customComponents.DrawableView;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.models.Car;
import com.example.petar.inteligentnisistemi.models.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PETAR on 2/6/2017.
 */

public class NavigationFragment extends Fragment
{
    DrawableView drawableView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        drawableView = (DrawableView) rootView.findViewById(R.id.drawableView);
        drawableView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i("Sda", "Kliknuto");
            }
        });

        if (Constants.getInstance().map.cars.size() == 0)
        {
            Connections.getInstance().getAllCars(new Callback<ArrayList<Car>>()
            {
                @Override
                public void onResponse(Call<ArrayList<Car>> call, Response<ArrayList<Car>> response)
                {
                    if (response.isSuccessful())
                    {
                        Constants.getInstance().map.cars = response.body();
                        drawableView.drawCars();
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Car>> call, Throwable t)
                {
                    Log.i("Sda", "Gotovo");
                }
            });
        }
        Connections.getInstance().getAllNodes(new Callback<ArrayList<Node>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Node>> call, Response<ArrayList<Node>> response)
            {
                Constants.getInstance().map.nodes = response.body();
                if (Constants.getInstance().map.nodes != null && Constants.getInstance().map.nodes.size() > 0)
                {
                    for (final Node n : Constants.getInstance().map.nodes)
                    {
                        if (n != null)
                        {
                            Connections.getInstance().getConnectedNodesIds(n, new Callback<ArrayList<Long>>()
                            {
                                @Override
                                public void onResponse(Call<ArrayList<Long>> call, Response<ArrayList<Long>> response)
                                {
                                    if (response.isSuccessful())
                                    {
                                        ArrayList<Long> ids = response.body();
                                        if (ids != null)
                                        {
                                            for (Node node : Constants.getInstance().map.nodes)
                                            {
                                                if (node != null)
                                                {
                                                    if (ids.contains(node.getId()))
                                                    {
                                                        n.connectedNodes.add(node);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (Constants.getInstance().map.nodes.indexOf(n) == Constants.getInstance().map.nodes.size() - 1)
                                    {
                                        if (drawableView.getWidth() != 0)
                                        {
                                            drawableView.drawMap();
                                            drawableView.drawCars();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<ArrayList<Long>> call, Throwable t)
                                {
                                    Log.i("Sda", "Gotovo");
                                }
                            });
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Node>> call, Throwable t)
            {
                Log.i("Sda", "Gotovo");
            }
        });
        return rootView;
    }

    class RequestTask extends AsyncTask<String, String, String>
    {

        @Override
        protected String doInBackground(String... uri)
        {
            String responseString = null;
            try
            {
                URL url = new URL("");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                if (conn.getResponseCode() == HttpsURLConnection.HTTP_OK)
                {
                    // Do normal input or output stream reading
                    BufferedReader r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuilder total = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null)
                    {
                        total.append(line).append('\n');
                    }
                } else
                {

                }
            }
            catch (IOException e)
            {
                //TODO Handle problems..
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String result)
        {
            super.onPostExecute(result);
            //Do anything with response..
        }
    }
}
