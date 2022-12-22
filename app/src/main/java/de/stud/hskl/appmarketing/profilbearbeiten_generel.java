package de.stud.hskl.appmarketing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class profilbearbeiten_generel extends AppCompatActivity {

    Switch s1;
    Switch s2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilbearbeiten_generel);
        s1= findViewById(R.id.switch1);
        s2= findViewById(R.id.switch2);
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profilbearbeiten_generel.this, Profilbearbeiten_Fahrer.class);
                startActivity(intent);
            }
        });
        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profilbearbeiten_generel.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}