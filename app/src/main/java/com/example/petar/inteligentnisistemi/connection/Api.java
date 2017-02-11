package com.example.petar.inteligentnisistemi.connection;

import com.example.petar.inteligentnisistemi.models.Car;
import com.example.petar.inteligentnisistemi.models.Node;
import com.example.petar.inteligentnisistemi.models.PathObject;
import com.example.petar.inteligentnisistemi.models.User;
import com.example.petar.inteligentnisistemi.models.parsing.MyWeather;

import java.util.ArrayList;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by PETAR on 1/21/2017.
 */

public interface Api
{
    @GET ("car/all")
    Call<ArrayList<Car>> getAllCars();
    @GET ("node/all")
    Call<ArrayList<Node>> getAllNodes();
    @POST("car/registrationNumber")
    Call<Car> getCarByRegistrationNumber(@Body RequestBody params);
    @POST("car/lastNode")
    Call<ArrayList<Car>> getCarByLastNode(@Body RequestBody params);
    @POST("car/brand")
    Call<ArrayList<Car>> getCarByBrand(@Body RequestBody params);
    @POST("car/addCar")
    Call<Response<Void>> addNewCar(@Body RequestBody params);
    @POST("car/position")
    Call<Response<Void>> findCarByNode(@Body RequestBody params); //ToDo
    @POST("car/updateCarPosition")
    Call<Response<Void>> updateCarPosition(@Body RequestBody params);
    @POST("car/connectedNodes")
    Call<ArrayList<Node>> getNodeByCnnectedNodes(@Body RequestBody params);
    @POST("node/connectedNodesId")
    Call<ArrayList<Long>> getConnectedNodesIds(@Body RequestBody params);
    @POST("carSys/getWeatherInformation")
    Call<MyWeather> getWeatherInformation(@Body RequestBody params);
    @POST("carSys/logIn")
    Call<ResponseBody> login(@Body RequestBody params);
    @POST("carSys/startNavigation")
    Call<com.example.petar.inteligentnisistemi.models.PathObject> startNavigation(@Body RequestBody params);
}
