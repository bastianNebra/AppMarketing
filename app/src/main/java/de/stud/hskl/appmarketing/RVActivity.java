package de.stud.hskl.appmarketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {
    SwipeRefreshLayout sw;
    RecyclerView rv;
    RVAdapter rvAdapter;
    DAOFahrerProfil dao;
    boolean isLoading =false;
    String key=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
        sw = findViewById(R.id.swip);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager manager= new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rvAdapter = new RVAdapter(this);
        rv.setAdapter(rvAdapter);
        dao= new DAOFahrerProfil();
        loadData();
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
               LinearLayoutManager linearLayoutManager= (LinearLayoutManager)rv.getLayoutManager();
               int totalItem = linearLayoutManager.getItemCount();
               int lastVisible= linearLayoutManager.findLastCompletelyVisibleItemPosition();
               if(totalItem <lastVisible + 3){

                   if(! isLoading){
                       isLoading=true;
                       loadData();

                   }
               }
            }
        });



    }

    private void loadData() {
        sw.setRefreshing(true);

        dao.get(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<FahrerProfil>list= new ArrayList<>();

                for( DataSnapshot d: snapshot.getChildren()){
                    FahrerProfil fa = d.getValue(FahrerProfil.class);
                    list.add(fa);
                    key=d.getKey();
                }
                rvAdapter.setItems(list);
                rvAdapter.notifyDataSetChanged();
                isLoading=false;
                sw.setRefreshing(false);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                sw.setRefreshing(false);

            }
        });
    }
}