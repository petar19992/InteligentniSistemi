package com.example.petar.inteligentnisistemi;

import android.app.Activity;
import android.app.Presentation;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.helpers.SharePreferenceManager;

public class SplashActivity extends Activity
{

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    Intent mainIntent;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        Constants.getInstance().regbr = SharePreferenceManager.getInstance(getApplicationContext()).getString(SharePreferenceManager.REG_BR, "");

        if (Constants.getInstance().regbr.equals(""))
        {
            mainIntent = new Intent(this, LoginActivity.class);
        } else
        {
            mainIntent = new Intent(this, MainActivity.class);
        }
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                /* Create an Intent that will start the Menu-Activity. */
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
