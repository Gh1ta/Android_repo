package com.example.myapplicationsalameservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("MyIntentService", "Intent recu");
    }


    public void OnCreate() {
        super.onCreate();
        Log.i("MyIntentService", "Creating the intent");

    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("MyIntentService", "Destroying the intent service");
    }
}
