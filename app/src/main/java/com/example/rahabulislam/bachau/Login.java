package com.example.rahabulislam.bachau;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button Login , SignUp;
    EditText loginEmail, loginPassword;
    private FirebaseAuth mAuth;

    String email,password;
    ProgressBar progressBarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login = findViewById(R.id.LoginID);
        SignUp = findViewById(R.id.SignUpID);
        loginEmail= findViewById(R.id.EmailID);
        loginPassword = findViewById(R.id.PassID);
        progressBarLogin = findViewById(R.id.loginProgressBarID);

        mAuth = FirebaseAuth.getInstance();


        /*Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Home.class);
                startActivity(intent);
            }
        });*/


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,SignUp.class);
                startActivity(intent);
            }
        });


    }

    public void userLogin(){
        email = loginEmail.getText().toString();
        password = loginPassword.getText().toString();

        if(email.isEmpty()) {
            loginEmail.setError("Enter an email address");
            loginEmail.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginEmail.setError("Enter a valid email address");
            loginEmail.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            loginPassword.setError("Enter a password");
            loginPassword.requestFocus();
            return;
        }

        if(password.length()<6) {
            loginPassword.setError("Minimum length of a password should be 6");
            loginPassword.requestFocus();
            return;
        }

        progressBarLogin.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressBarLogin.setVisibility(View.GONE);

                if(task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Unsuccessfull",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
