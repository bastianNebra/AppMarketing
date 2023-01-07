package de.stud.hskl.appmarketing;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class General_profil_edit extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_profil_edit);

        final EditText e1 = findViewById(R.id.profile_name);
        final EditText e2 = findViewById(R.id.profile_email);
        final EditText e3 = findViewById(R.id.profile_standortHS);
        final EditText e4 = findViewById(R.id.profile_alter);
        Button bn= findViewById(R.id.update_btn);
        DAOEditProfil dao = new DAOEditProfil();
        bn.setOnClickListener( v ->{

            HashMap<String, Object> hashMap =new HashMap<>();

            hashMap.put("name", e1.getText().toString());
            hashMap.put("email", e2.getText().toString());
            hashMap.put("standort", e3.getText().toString());
            hashMap.put("alter", e4.getText().toString());
            dao.update("OXjjkrSnbuTG6l3Edjltb1vnkdq2",hashMap).addOnSuccessListener( suc ->{
                Toast.makeText(this," Data updated", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er ->{
                Toast.makeText(this," Data not updated", Toast.LENGTH_SHORT).show();
            });




        });

    }


}
