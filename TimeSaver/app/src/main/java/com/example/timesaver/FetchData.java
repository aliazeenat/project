package com.example.timesaver;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData extends AsyncTask<Void,Void,Void> {
    String line;
    String data;

    @Override
    protected Void doInBackground(Void... voids) {
        URL url;
        try{

            url = new URL("https://api.myjson.com/bins/19we9x");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            line = "";
            line = bufferedReader.readLine();

            JSONArray ja = new JSONArray(line);
            JSONObject jo = (JSONObject) ja.get(0);

            data = (String) jo.get("description");


        }catch (Exception e){}

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Help.tv.setText(data);
    }
}
