package com.example.petar.inteligentnisistemi.helpers;

import android.app.DownloadManager;
import android.os.AsyncTask;

import com.example.petar.inteligentnisistemi.models.Car;
import com.example.petar.inteligentnisistemi.models.Map;
import com.example.petar.inteligentnisistemi.models.Node;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by petar on 9.10.16..
 */

public class Constants
{

    /************************************/
    public Map map;
    public Car myCar;
    public String regbr;
    public String marka;

    public Node findNodeById(long id)
    {
        for (Node n : map.nodes)
            if (n.getId() == id)
            {
                return n;
            }
        return null;
    }

    /************************************/

    private static Constants instance;

    public static Constants getInstance()
    {
        if (instance == null)
        {
            instance = new Constants();
        }
        return instance;
    }

    private Constants()
    {
        map = new Map();
    }


    public interface IGetInterface
    {
        void onStart();

        void onFinish(String result);
    }

    public void GET(String url, IGetInterface iGetInterface)
    {
        new DownloadFilesTask(url, iGetInterface).execute();

    }

    private class DownloadFilesTask extends AsyncTask<Void, Void, Void>
    {

        String url;
        IGetInterface iGetInterface;
        String result;

        public DownloadFilesTask(String url, IGetInterface iGetInterface)
        {
            this.url = url;
            this.iGetInterface = iGetInterface;
        }

        @Override
        protected void onPreExecute()
        {
            if (iGetInterface != null)
            {
                iGetInterface.onStart();
            }
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            if (iGetInterface != null)
            {
                iGetInterface.onFinish(result);
            }
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            HttpURLConnection urlConnection = null;
            try
            {
                URL mUrl = new URL(url);
                urlConnection = (HttpURLConnection) mUrl.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder total = new StringBuilder();
                String line;
                while ((line = r.readLine()) != null)
                {
                    total.append(line).append('\n');
                }
                result = total.toString();
            }
            catch (Exception ex)
            {

            }
            finally
            {
                if (urlConnection != null)
                {
                    urlConnection.disconnect();
                }
            }
            return null;
        }
    }
}
