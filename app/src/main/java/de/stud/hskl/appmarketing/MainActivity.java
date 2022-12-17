package de.stud.hskl.appmarketing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DriveData[] DriveData = new DriveData[]{
                //einfügen der Daten über DB
                //new DriveData(//alle einzelnen Daten inkl. Kartenzugriff)
        };

        DriveAdapter DriveAdapter = new DriveAdapter(DriveData, MainActivity.this);
        recyclerView.setAdapter(DriveAdapter);

    }
}