package de.stud.hskl.appmarketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
public class Mitfahrer_Profil extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitfahrer_profil);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView2);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);

        Button btnSenden = findViewById(R.id.btnSenden);
        EditText adresse = findViewById(R.id.editTextTextPersonName);
        EditText maxlaufweg = findViewById(R.id.max_laufweg);


        btnSenden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailAnsicht();

            }
        });

    }

    private void detailAnsicht() {

        try {
            Intent intent = new Intent(Mitfahrer_Profil.this, DetailActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}