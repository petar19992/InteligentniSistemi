package com.example.petar.inteligentnisistemi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.petar.inteligentnisistemi.connection.Api;
import com.example.petar.inteligentnisistemi.customComponents.DrawableView;
import com.example.petar.inteligentnisistemi.models.Car;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity
{

    DrawableView drawableView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawableView = (DrawableView) findViewById(R.id.drawableView);

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl("http://192.168.0.15:8082/")  //call your base url :8082
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = restAdapter.create(Api.class);
        Call<ArrayList<Car>> repos = api.getAllCars();
        repos.enqueue(new Callback<ArrayList<Car>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Car>> call, Response<ArrayList<Car>> response)
            {


            }

            @Override
            public void onFailure(Call<ArrayList<Car>> call, Throwable t)
            {

            }
        });

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), "{\"regBr\": \"NI 245 45\"}");
        Call<Car> response = api.getCarByRegistrationNumber(body);

        response.enqueue(new Callback<Car>()
        {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response)
            {
                Log.i("", "USPESNO");
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t)
            {
                Log.i("", "NEUSPESNO");
            }
        });
       /* MapParser mp = new MapParser();
        try
        {
            mp.main(getApplicationContext());
            for (int i = 0; i < Constants.getInstance().map.nodes.size(); i++)
            {
                for (int e : Constants.getInstance().map.nodes.get(i).tmpEdges)
                {
                    Edge edge = new Edge();
                    edge.from = Constants.getInstance().map.getNodeAt(i);
                    edge.to = Constants.getInstance().map.getNodeAt(e - 1);
                    Constants.getInstance().map.getNodeAt(i).edges.add(edge);
                }
            }
            Log.i("Sda", "Gotovo");
        } catch (XmlPullParserException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }*/

        /*((ProgressBar)findViewById(R.id.progressBar)).setMax(100);
        ((ProgressBar)findViewById(R.id.progressBar)).setProgress(50);*/
    }

    boolean firstInit = true;

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if (firstInit)
        {
            /*firstInit = false;
            drawableView.drawMap();*/
        }
    }
}
