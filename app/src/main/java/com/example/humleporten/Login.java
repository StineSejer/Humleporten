package com.example.humleporten;

import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity
{
    EditText metEmailAddress, metPassword;
    Button mbtLogIn;
    TextView tvNotUser;
    ProgressBar progressBar;
    FirebaseAuth fAuch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metEmailAddress = findViewById(R.id.etEmailAddress);
        metPassword = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.progressBar);
        fAuch = FirebaseAuth.getInstance();
        mbtLogIn = findViewById(R.id.btLogIn);
        tvNotUser = findViewById(R.id.tvNotUser);

        mbtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = metEmailAddress.getText().toString().trim();
                String password = metPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email))
                {
                    metEmailAddress.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    metPassword.setError("Password is required");
                    return;
                }
                if (password.length() < 5)
                {
                    metPassword.setError("Password must be more than 5 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuch.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "Sign In successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Login failed! Try again" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });


        tvNotUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });



    }}
