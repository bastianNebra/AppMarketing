package de.stud.hskl.appmarketing;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOEditProfil {
    /**
     * MapIPI
     * AIzaSyD--TG__I9phq_UESnqw6jzKF3vs2HNV8E
     * **/

    private DatabaseReference databaseReference;

    public DAOEditProfil(){
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        databaseReference= db.getReference(EditProfil.class.getSimpleName());
    }
    public Task<Void> add(EditProfil e){

       return databaseReference.push().setValue(e);


    }
    public Task<Void> update (String Key, HashMap<String, Object> hashMap){
        return databaseReference.child(Key).updateChildren(hashMap);
    }
    public Task<Void> remove (String Key){
        return databaseReference.child(Key).removeValue();
    }
}
