package com.example.petar.inteligentnisistemi.connection;

import com.example.petar.inteligentnisistemi.models.Car;
import com.example.petar.inteligentnisistemi.models.Node;
import com.example.petar.inteligentnisistemi.models.User;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
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
}
