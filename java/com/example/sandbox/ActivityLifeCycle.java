package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.d("lifecycle","onCreate invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("lifecycle","onStart invoked");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("lifecycle","onPause invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("lifecycle","onResume invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //It will be called when the system restarts the app
        Log.d("lifecycle","onRestart invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("lifecycle","onStop invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("lifecycle","onDestroy invoked");
    }
}
