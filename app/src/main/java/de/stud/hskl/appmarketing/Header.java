package de.stud.hskl.appmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Header extends AppCompatActivity {

   FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView yourName;
    TextView yourStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference("users");

        yourName = findViewById(R.id.your_name);
        yourStatus = findViewById(R.id.your_status);

        getData();
    }

    public void getData(){

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                System.out.println("Values von snapshot "+ value);
                yourName.setText((CharSequence) snapshot.child("firstName").getValue());
                yourStatus.setText((CharSequence) snapshot.child("status").getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Header.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
