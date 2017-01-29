package com.example.petar.inteligentnisistemi;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by PETAR on 1/28/2017.
 */

public class UIApplication extends Application
{


    @Override
    public void onCreate()
    {
        super.onCreate();
        getScreenDimensions();
    }
    public static int WIDTH,HEIGHT;
    private void getScreenDimensions()
    {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        WIDTH = size.x;
        HEIGHT = size.y;
    }
}
