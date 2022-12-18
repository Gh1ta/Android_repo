package com.example.myapplicationsalameservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondaryActivity extends AppCompatActivity {
    private ServiceConnection serviceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Toast.makeText(SecondaryActivity.this, "Liaison au service", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Toast.makeText(SecondaryActivity.this, "Deconnexion du service", Toast.LENGTH_SHORT).show();
            }
        };
    }

    // Start the service
    public void lierService(View view) {
        Intent intent = new Intent(SecondaryActivity.this, UnService.class);
        intent.putExtra("NAME", "SecondaryActivity");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
        Log.i("SecondaryActivity", "SecondaryActivity s'est lié au service");

    }

    // Stop the service
    public void delierService(View view) {
        unbindService(serviceConnection);
        Log.i("SecondaryActivity", "SecondaryActivity s'est délié du service");
    }
}