
// Code by Justin Commins

package com.conorarranmore.beerapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadUrl {

    /*
    In the DownloadUrl class, a readUrl() method was created which reads in an URL using HTTPURLConnection object.
    It also used file handling methods such as input stream and Buffered Reader.
    After reading the url, it needs to be parsed, and to do this a Data parser class was created.
    This class contains three methods: getPlace(), getPlaces() and parse().
    The parse() method parses the data and passes it to getPlaces() method which will store it in form of a HashMap List.
    */
    public String readUrl(String myUrl) throws IOException{

        String data = "";
        InputStream inputStream = null;
        HttpURLConnection urlConnection = null;

        try {
            URL url = new URL (myUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = "";

            //check if null or not: if not store in append data
            while ((line = br.readLine()) != null){

                sb.append(line);
            }

            data = sb.toString();
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            inputStream.close();
            urlConnection.disconnect();
        }

        return data;
    }
}
