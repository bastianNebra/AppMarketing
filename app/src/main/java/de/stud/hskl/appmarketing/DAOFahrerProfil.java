package de.stud.hskl.appmarketing;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAOFahrerProfil {
    private DatabaseReference databaseReference;

    public DAOFahrerProfil() {
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        databaseReference= db.getReference(FahrerProfil.class.getSimpleName());
}
    public Task<Void> add(FahrerProfil f){

        return databaseReference.push().setValue(f);


    }
    public Query get(String key){
        if( key == null){
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }
}
