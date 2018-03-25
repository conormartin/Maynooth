
// Code by Conor Martin

package com.conorarranmore.beerapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchActivity extends AsyncTask<String,Void,String>{

    @Override //Method to read data from API url
    protected String doInBackground(String... urls) {
        //Create new StringBuilder called result, this will store any data returned from the server in result
        StringBuilder result = new StringBuilder();
        //Create new URL and Http connection to connect to the server
        URL url;
        HttpURLConnection urlConnection;
        //Tries to connect to the server using the URL from the execute command in the SearchResults file
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            //If the connection is successful, the input stream reads the data returned fro the request
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();

            while(data != -1) {
                char current = (char) data;
                result.append(current);
                data = reader.read();
            }
            //returns the information as a string
            return result.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override //Takes result from above method (a JSON file) and turns it into a string then prints it to screen
    protected void onPostExecute(String result){
        super.onPostExecute(result);

        try {
            //Create new JSON object which takes in result from above method
                JSONObject beerDataJSON = new JSONObject(result);
                //Create JSON array and populate with the data tree in the json file, this sets each sub setting of the 'data' header to a new array element
                JSONArray dataList = beerDataJSON.getJSONArray("data");
                //Create another JSON object set to the first array element for each sub header
                JSONObject dataJson = dataList.getJSONObject(0);
                if(dataList.getJSONObject(0) == null){
                    SearchResults.nameTextView.setText("No results found");
                }
                else {
                    //Extracts relevant strings from the JSON and sets them to TextViews
                    String name = dataJson.getString("name");
                    SearchResults.nameTextView.setText(name);
                    String description = dataJson.getString("description");
                    SearchResults.descriptionTextView.setText(description);
                    String alcoholContent = dataJson.getString("abv");
                    SearchResults.alcTextView.setText(alcoholContent);
                }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}