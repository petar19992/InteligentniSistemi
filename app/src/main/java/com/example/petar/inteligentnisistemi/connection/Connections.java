package com.example.petar.inteligentnisistemi.connection;

import com.example.petar.inteligentnisistemi.models.Car;
import com.example.petar.inteligentnisistemi.models.Node;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PETAR on 1/28/2017.
 * <p>
 * Singleton za pozivanje sa API-em
 */

public class Connections
{
    Retrofit restAdapter;
    Api api;
    private static Connections instance;

    private Connections()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        restAdapter = new Retrofit.Builder()
                .baseUrl("http://192.168.0.15:8082/")  //call your base url :8082
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = restAdapter.create(Api.class);
    }

    public static Connections getInstance()
    {
        if (instance == null)
            instance = new Connections();
        return instance;
    }

    public void login(String regBr,String marka,Callback<String> callback)
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put("regBr", regBr);
            jsonObject.put("brand", marka);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString() /*"{\"regBr\": \"NI 245 45\"}"*/);
        Call<String> response = api.login(body);
        response.enqueue(callback);
    }
    public void getAllCars(Callback<ArrayList<Car>> callback)
    {
        Call<ArrayList<Car>> repos = api.getAllCars();
        repos.enqueue(callback);
    }
    public void getAllNodes(Callback<ArrayList<Node>> callback)
    {
        Call<ArrayList<Node>> repos = api.getAllNodes();
        repos.enqueue(callback);
    }

    public void getCarByRegistrationNumber(String regBr, Callback<Car> callback)
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put("regBr", regBr);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString() /*"{\"regBr\": \"NI 245 45\"}"*/);
        Call<Car> response = api.getCarByRegistrationNumber(body);
        response.enqueue(callback);
    }

    public void getCarByLastNode(Node node, Callback<ArrayList<Car>> callback)
    {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), node.toString());
        Call<ArrayList<Car>> response = api.getCarByLastNode(body);
        response.enqueue(callback);
    }
    public void getCarByBrand(String brand, Callback<ArrayList<Car>> callback)
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put("brand", brand);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        Call<ArrayList<Car>> response = api.getCarByBrand(body);
        response.enqueue(callback);
    }

    public void addNewCar(String regBr, String brand, Callback<Response<Void>> callback)
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            jsonObject.put("regBr", regBr);
            jsonObject.put("brand", brand);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        Call<Response<Void>> response = api.addNewCar(body);
        response.enqueue(callback);
    }
    public void getNodeByCnnectedNodes(Node node, Callback<ArrayList<Node>> callback)
    {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), node.getNodeForConnectionNodes());
        Call<ArrayList<Node>> response = api.getNodeByCnnectedNodes(body);
        response.enqueue(callback);
    }
    public void getConnectedNodesIds(Node node, Callback<ArrayList<Long>> callback)
    {
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), node.getNodeForConnectionNodes());
        Call<ArrayList<Long>> response = api.getConnectedNodesIds(body);
        response.enqueue(callback);
    }
}
