package de.stud.hskl.appmarketing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class General_profil extends AppCompatActivity {

    public FirebaseAuth firebaseAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mGetReference;
    private String email;
    private static final String USERS = "usser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_profil);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");

        ImageView photo = findViewById(R.id.header_img);
        EditText name = findViewById(R.id.profile_name);
        EditText email_profil = findViewById(R.id.profile_email);
        EditText hs = findViewById(R.id.profile_standortHS);
        EditText alt = findViewById(R.id.profile_alter);

        try {
            firebaseAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance();
            mGetReference = mDatabase.getReference(USERS);

        }catch(Exception ex){

        }
        mGetReference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapShot){
                for(DataSnapshot ds: dataSnapShot.getChildren()){
                    if(ds.child("email").getValue().equals(email)){
                        name.setText(ds.child("firstName").getValue(String.class));
                        email_profil.setText(ds.child("email").getValue(String.class));
                        hs.setText(ds.child("hs").getValue(String.class));
                        alt.setText(ds.child("name").getValue(String.class));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }
        });





    }




}
