package com.example.myapplicationghitaintent;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
public class DeuxiemeActivite extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle extras=getIntent().getExtras();
        Toast.makeText(getApplicationContext(), "nom et prenom : " + extras.get("nom")+
                " "+extras.get("prenom"),Toast.LENGTH_LONG).show();
    }
}
