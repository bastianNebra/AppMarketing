package de.stud.hskl.appmarketing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity {

    //FirebaseAuth firebaseAuth;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout =findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(drawerToggle );
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnMitfahrer = findViewById(R.id.btnMitfahrer);
        Button btnFahrer = findViewById(R.id.btnFahrer);


        btnFahrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFahrer();
            }
        });

        btnMitfahrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewMitfahrer();
            }
        });



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.fahrer_profil:
                    {

                            Intent intent = new Intent(MainActivity.this, Fahrer_Profil.class);
                            startActivity(intent);
                            break;

                    }
                    case R.id.mitfahrer_profil:
                    {

                            Intent intent = new Intent(MainActivity.this, Mitfahrer_Profil.class);
                            startActivity(intent);
                            break;

                    }
                    case R.id.general_profil_edit:
                    {
                        Intent intent = new Intent(MainActivity.this, General_profil_edit.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.fahrtcart_item_list:
                    {
                        Intent intent = new Intent(MainActivity.this, List_item.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.activity_detail:
                    {
                        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case R.id.dashboard_fahrer:
                    {
                        Intent intent = new Intent(MainActivity.this, Dashboard_fahrer.class);
                        startActivity(intent);
                        break;
                    }
                }
                return false;
            }
        });

    }

    private void viewFahrer() {
        Intent intent = new Intent(MainActivity.this, Fahrer_Profil.class);
        startActivity(intent);
    }

    private void viewMitfahrer() {
        Intent intent = new Intent(MainActivity.this, Mitfahrer_Profil.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}