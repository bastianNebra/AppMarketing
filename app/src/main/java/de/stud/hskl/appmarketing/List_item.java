package de.stud.hskl.appmarketing;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class    List_item extends AppCompatActivity {

    public FirebaseAuth firebaseAuth;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mGetReference;
    private String email;
    private static final String USERS = "users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fahrt_card_item_list);

        /**
         *
         * Intent intent = getIntent();
         *         email = intent.getStringExtra("email");
         *         System.out.println("Email: "+email);
         *
         *         ImageView photo = findViewById(R.id.header_img);
         *         EditText name = findViewById(R.id.profile_name);
         *         EditText email_profil = findViewById(R.id.profile_email);
         *         EditText hs = findViewById(R.id.profile_standortHS);
         *         EditText alt = findViewById(R.id.profile_alter);
         *
         *         try {
         *             firebaseAuth = FirebaseAuth.getInstance();
         *             mDatabase = FirebaseDatabase.getInstance();
         *             mGetReference = mDatabase.getReference("users"
         *             );
         *
         *         }catch(Exception ex){
         *
         *         }
         *         mGetReference.addValueEventListener(new ValueEventListener(){
         *             @Override
         *             public void onDataChange(@NonNull DataSnapshot dataSnapShot){
         *                 for(DataSnapshot ds: dataSnapShot.getChildren()){
         *                     if(ds.child("email").getValue().equals(email)){
         *                         name.setText(ds.child("firstName").getValue(String.class));
         *                         email_profil.setText(ds.child("email").getValue(String.class));
         *                         hs.setText(ds.child("hs").getValue(String.class));
         *                         alt.setText(ds.child("name").getValue(String.class));
         *                     }
         *                 }
         *             }
         *
         *             @Override
         *             public void onCancelled(@NonNull DatabaseError databaseError){
         *
         *             }
         *         });
         * **/


    }




}
