package de.stud.hskl.appmarketing;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

   private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
                System.out.println();
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textViewSwitchToLogin = findViewById(R.id.alreadyHaveAccount);
        textViewSwitchToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToLogin();
            }
        });
    }

    private void registerUser() {
        EditText etUsername = findViewById(R.id.inputUsername);
        EditText etRegisterEmail = findViewById(R.id.inputEmail);
        EditText etPassword = findViewById(R.id.inputPassword);
        EditText etPasswordConfirm = findViewById(R.id.inputConfirmPassword);

        String userName = etUsername.getText().toString();
        String email = etRegisterEmail.getText().toString();
        String password = etPassword.getText().toString();
        String confirmPassword = etPasswordConfirm.getText().toString();

        if (userName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

         if (password.equals(confirmPassword)){
            mAuth.createUserWithEmailAndPassword(email, password)

                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                User user = new User(userName, email, password);


                                FirebaseDatabase.getInstance().getReference("users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                showMainActivity();
                                            }
                                        });
                            } else {
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }else {
            Toast.makeText(RegisterActivity.this,"Authentication failed.",Toast.LENGTH_LONG);
        }
    }

    private void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void switchToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}































