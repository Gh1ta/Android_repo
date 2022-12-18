package com.example.myapplicationsalameservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class UnService extends Service {
    public class LocalBinder extends Binder {
        UnService getService() {
            return UnService.this;
        }
    }
    private final IBinder binder = new LocalBinder();
    private static final String TAG = "UnService";
    public UnService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,  "Premier composant lié : "+intent.getStringExtra( "NAME"));
        return binder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"Dernier composant délié: "+intent.getStringExtra( "NAME"));
        return super.onUnbind(intent);
    }
    @Override
    public void onCreate() {
        Log.i(TAG, "Le service a ete cree");
        Toast.makeText( this, "Service cree", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Le service a ete detruit");
        Toast.makeText(this, "Service Detruit", Toast.LENGTH_SHORT).show();
    }
}
