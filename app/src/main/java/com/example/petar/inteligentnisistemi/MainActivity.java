package com.example.petar.inteligentnisistemi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.petar.inteligentnisistemi.customComponents.DrawableView;

public class MainActivity extends Activity {

DrawableView drawableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawableView= (DrawableView) findViewById(R.id.drawableView);
    }
}
