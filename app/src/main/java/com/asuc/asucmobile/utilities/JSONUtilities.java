package com.asuc.asucmobile.utilities;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.asuc.asucmobile.controllers.Controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class JSONUtilities {

    private static final String TAG = "JSONUtilities";

    /**
     *  getUrlBody() takes a website and puts all its contents into a String format. Used for JSON
     *  parsing.
     *
     *  @param reader The buffer attached to a website to retrieve all characters.
     *  @return JSON data in String format.
     */
    private static String getUrlBody(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        int character = reader.read();
        while (character != -1) {
            builder.append((char) character);
            character = reader.read();
        }
        return builder.toString();
    }

    /**
     * readJSONFromUrl() retrieves JSON info from an api and calls an update function through the
     * controller to pass on the data.
     *
     * @param context The Android context from which we're loading the JSON.
     * @param url Url where JSON data is located.
     * @param name Label of main JSONArray in the url.
     * @param controller Data Controller to host the callback function once the info is retrieved.
     */
    public static void readJSONFromUrl(Context context, String url, String name, Controller controller) {
        new ReadJSONTask(context, url, name, controller).execute("");
    }

    private static class ReadJSONTask extends AsyncTask<String, Void, Void> {

        Context context;
        String url;
        String name;
        Controller controller;

        private ReadJSONTask(Context context, String url, String name, Controller controller) {
            this.context = context;
            this.url = url;
            this.name = name;
            this.controller = controller;
        }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                InputStream input = (new URL(url)).openStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
                String jsonText = getUrlBody(buffer);
                JSONObject json = new JSONObject(jsonText);
                JSONArray jsonArray = json.getJSONArray(name);
                input.close();
                controller.setResources(context, jsonArray);
            } catch (Exception e) {
                //VERY HACKY WAY TO GET BUSINFO CONTROLLER INTO JSON, TEMPORARY! - ALEX
                try{
                    InputStream input = (new URL(url)).openStream();
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
                    String jsonText = getUrlBody(buffer);
                    JSONArray x = new JSONArray();
                    x.put(jsonText);
                    controller.setResources(context, x);

                }catch (Exception e1){
                    Log.e(TAG, e1.getMessage());
                    controller.setResources(context, null);
                }
            }
            return null;
        }

    }

    public static String readJSONFromAsset(Context context, String fileName) {
        String json;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

 }