package com.example.petar.inteligentnisistemi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.petar.inteligentnisistemi.connection.Connections;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.helpers.SharePreferenceManager;
import com.example.petar.inteligentnisistemi.models.Car;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity implements View.OnClickListener
{
    private LinearLayout activityLogin;
    private EditText loginEditText;
    private EditText markEditText;
    private Button loginButton;
//    private Button registerButton;

    private void findViews()
    {
        activityLogin = (LinearLayout) findViewById(R.id.activity_login);
        loginEditText = (EditText) findViewById(R.id.loginEditText);
        markEditText = (EditText) findViewById(R.id.markEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
//        registerButton = (Button) findViewById(registerButton);

        loginButton.setOnClickListener(this);
//        registerButton.setOnClickListener(this);
    }

    ProgressDialog progressDialog;

    @Override
    public void onClick(View v)
    {
        if (v == loginButton)
        {
            if(!UIApplication.isNetworkAvailable(getApplicationContext()))
            {
                Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!loginEditText.getText().toString().equals("") && !markEditText.getText().toString().equals(""))
            {
                Constants.getInstance().regbr = loginEditText.getText().toString();
                Constants.getInstance().marka = markEditText.getText().toString();
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Login , Please wait...");
                progressDialog.show();
                Connections.getInstance().login(Constants.getInstance().regbr, Constants.getInstance().marka, new Callback<String>()
                {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response)
                    {
                        if (response.isSuccessful())
                        {
                            SharePreferenceManager.getInstance().put(SharePreferenceManager.REG_BR, Constants.getInstance().regbr);
                            SharePreferenceManager.getInstance().put(SharePreferenceManager.MARKA, Constants.getInstance().marka);
                            Connections.getInstance().getAllCars(new Callback<ArrayList<Car>>()
                            {
                                @Override
                                public void onResponse(Call<ArrayList<Car>> call, Response<ArrayList<Car>> response)
                                {
                                    if (response.isSuccessful())
                                    {
                                        Constants.getInstance().map.cars = response.body();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ArrayList<Car>> call, Throwable t)
                                {
                                    Log.i("Sda", "Gotovo");
                                }
                            });

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t)
                    {
                        Log.i("Sda", "Gotovo");
                    }
                });
            }
            // Handle clicks for loginButton
        }
/*        else if (v == registerButton)
        {
            progressDialog = ProgressDialog.show(this, "Register", "Please wait...", true);
            // Handle clicks for registerButton
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
    }
}
