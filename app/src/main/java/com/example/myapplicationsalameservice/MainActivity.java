package com.example.myapplicationsalameservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { private ServiceConnection serviceConnection;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Toast.makeText(MainActivity.this, "Service is connected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Toast.makeText(MainActivity.this, "Service is destroyed", Toast.LENGTH_SHORT).show();
            }
        };

    }
// Start the service
        public void lierService(View view){
            Intent intent = new Intent(MainActivity.this, UnService.class);
            intent.putExtra("NAME", "MainActivity");
            bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
            Log.i("MainActivity", "MainActivity launched the service");

            Intent newActivity = new Intent(MainActivity.this, SecondaryActivity.class);
            startActivity(newActivity);
        }
// Stop the service
        public void delierService (View view){
            unbindService(serviceConnection);
            Log.i("MainActivity","MainActivity s'est délié du service");
        }
    }