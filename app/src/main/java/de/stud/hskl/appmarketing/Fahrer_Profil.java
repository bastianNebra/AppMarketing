package de.stud.hskl.appmarketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;


import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
<<<<<<< HEAD

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Fahrer_Profil extends AppCompatActivity implements OnMapReadyCallback {

import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

public class Fahrer_Profil extends AppCompatActivity implements OnMapReadyCallback {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahrer_profil);

        Button btn = (Button)findViewById(R.id.speichern);


        /*SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);*/

        EditText editText = findViewById(R.id.adress_fahrer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String address = editText.getText().toString();
                GeoCodeLocation locationAddress = new GeoCodeLocation();
                locationAddress.getAddressFromLocation(address, getApplicationContext(), new GeoCoderHandler());


        EditText adress_fahrer = findViewById(R.id.adress_fahrer);
        TextView fahrer = findViewById(R.id.textView);
        TextView adress_ziel = (TextView) findViewById(R.id.adress_fahrer_ziel);
        Switch swith1 = findViewById(R.id.switch1);
        Switch swith2 = findViewById(R.id.switch2);
        EditText auto = findViewById(R.id.auto);
        EditText mail = findViewById(R.id.mail);
        EditText autobeschreibung = findViewById(R.id.editTextTextMultiLine);
        TextView anzahl_platz = findViewById(R.id.anzahl);
        DAOFahrerProfil dao = new DAOFahrerProfil();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String address = adress_fahrer.getText().toString();
                GeoCodeLocation locationAddress = new GeoCodeLocation();
                locationAddress.getAddressFromLocation(address, getApplicationContext(), new GeoCoderHandler());
                FahrerProfil f = new FahrerProfil(adress_fahrer.getText().toString(),fahrer.getText().toString(),adress_ziel.getText().toString(),
                        swith1.getText().toString(),swith2.getText().toString(),auto.getText().toString(),autobeschreibung.getText().toString(),
                        anzahl_platz.getText().toString());
                f.setMail(mail.getText().toString());
                dao.add(f).addOnSuccessListener(suc ->{
                    Toast.makeText(Fahrer_Profil.this, "Fahrmöglichkeit Erfolgreich hinzugefügt", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fahrer_Profil.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }).addOnFailureListener(fai ->{
                    Toast.makeText(Fahrer_Profil.this, "Fahrmöglichkeit nicht Erfolgreich hinzugefügt", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fahrer_Profil.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                });





            }
        });


    }


    private void saveFahrerProfil(){

    }
    private class GeoCoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            System.out.println(locationAddress);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }


}


}

