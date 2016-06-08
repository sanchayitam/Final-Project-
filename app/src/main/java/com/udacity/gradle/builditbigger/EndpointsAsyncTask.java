package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.sanch.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import java.io.IOException;

/**
 * Created by sanch on 5/14/2016.
 */
public class EndpointsAsyncTask extends AsyncTask<OnsetJokeListener, Void, String> {
    private static MyApi myApiService = null;
    private OnsetJokeListener listener;
    String LOG_TAG = "ASYNC_TASK";

    @Override
    protected String doInBackground(OnsetJokeListener ... params) {

        listener = params[0];

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://final-project-1310.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.tellAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
            listener.onReceived(result);
        Log.i(LOG_TAG, "Retrieved the joke : " + result);
    }
}