package com.example.petar.inteligentnisistemi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.petar.inteligentnisistemi.customComponents.DrawableView;
import com.example.petar.inteligentnisistemi.helpers.Constants;
import com.example.petar.inteligentnisistemi.models.Edge;
import com.example.petar.inteligentnisistemi.parsers.MapParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class MainActivity extends Activity {

DrawableView drawableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawableView= (DrawableView) findViewById(R.id.drawableView);

        MapParser mp=new MapParser();
        try {
            mp.main(getApplicationContext());
            for(int i=0;i< Constants.getInstance().map.nodes.size();i++)
            {
                for(int e: Constants.getInstance().map.nodes.get(i).tmpEdges)
                {
                    Edge edge=new Edge();
                    edge.from=Constants.getInstance().map.getNodeAt(i);
                    edge.to=Constants.getInstance().map.getNodeAt(e-1);
                    Constants.getInstance().map.getNodeAt(i).edges.add(edge);
                }
            }
            Log.i("Sda","Gotovo");
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*((ProgressBar)findViewById(R.id.progressBar)).setMax(100);
        ((ProgressBar)findViewById(R.id.progressBar)).setProgress(50);*/
    }

    boolean firstInit=true;
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if(firstInit)
        {
            firstInit=false;
            drawableView.drawMap();
        }
    }
}
