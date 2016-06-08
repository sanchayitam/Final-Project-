package com.example.sanch.myandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView txtView = (TextView) findViewById(R.id.jokes);

         //the Intent that started us
        Intent myIntent = getIntent();

        //Retrieve the joke from the Intent Extras and set the textview
        txtView.setText(myIntent.getStringExtra(getString(R.string.jokeEnvelope)));
        if(txtView.length() == 0)
        {
            txtView.setText(R.string.empty_txt);
        }
    }
}
