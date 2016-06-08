package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.sanch.myandroidlibrary.JokeActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements OnsetJokeListener {
    private ProgressBar mSpinner;
    private  Button button;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        button = (Button)rootView.findViewById(R.id.joke_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJoke();
            }

        });
        //Progress bar
        mSpinner = (ProgressBar) rootView.findViewById(R.id.progressBar);
        mSpinner.setVisibility(View.GONE);
        return rootView;
    }

    public void getJoke(){
        mSpinner.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(this);
    }

    @Override
    public void onReceived(String strJoke) {
        mSpinner.setVisibility(View.GONE);
        Intent intent = new Intent(getActivity(),JokeActivity.class);
        intent.putExtra(getActivity().getString(R.string.jokeEnvelope), strJoke);
        startActivity(intent);

    }
}
