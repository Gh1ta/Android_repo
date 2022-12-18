package com.example.myapplicationsalame2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String message = "Activite est creee";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Snackbar.make(findViewById(android.R.id.content), message , Snackbar.LENGTH_SHORT).show();
        Log.i("onCreate():", message);
    }
    @Override
    protected void onStart() {
        String message = "Activite est demarree";
        super.onStart();
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        Log.i("onStart():", message);
    }
    @Override
    protected void onRestart() {
        String message = "Activite est redemarree";
        super.onRestart();
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        Log.i("onRestart():", message);
    }
    @Override
    protected void onResume() {
        String message = "Activite est reprise";
        super.onResume();
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        Log.i("onResume():", message);
    }
    @Override
    protected void onPause() {
        String message = "Activite est en pause";
        super.onPause();
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        Log.i("onPause():", message);
    }
    @Override
    protected void onStop() {
        String message = "Activite est stoppee";
        super.onStop();
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        Log.i("onStop():", message);
    }
    @Override
    protected void onDestroy() {
        String message = "Activite est detruite";
        super.onDestroy();
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        Log.i("onDestroy():", message);
    }
}