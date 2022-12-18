package com.example.myapplicationghitaintent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bouton_explicite, bouton_implicite, bouton_my_explicite, bouton_my_implicite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bouton_explicite = (Button)findViewById(R.id.button);
        bouton_implicite = (Button) findViewById(R.id.button2);
        bouton_my_explicite = (Button) findViewById(R.id.button3);
        bouton_my_implicite = (Button) findViewById(R.id.button4);
        bouton_explicite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DeuxiemeActivite.class);
                intent.putExtra("nom", "benmaissa");
                intent.putExtra("prenom", "yann");
                startActivity(intent);
            }
        });
        bouton_implicite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.inpt.ac.ma"));
                startActivity(intent);
            }
        });
        bouton_my_explicite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ForthActivity.class);
                intent.putExtra("nom", "benmaissa");
                intent.putExtra("prenom", "yann");
                startActivity(intent);
            }
        });
        bouton_my_implicite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
            }
        });

    }
}