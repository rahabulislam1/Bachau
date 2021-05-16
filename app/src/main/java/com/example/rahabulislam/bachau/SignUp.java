package com.example.rahabulislam.bachau;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Button SignUp;
    EditText UserName, Email, Password,Location;
    TextView LinkLogin;

    String userName,email,password,location;
    //DatabaseReference databaseReference;

    //FirebaseDatabase myDatabase;
    private FirebaseAuth mAuth;
    ProgressBar progressBarSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        SignUp = findViewById(R.id.SignUp_AddID);
        UserName = findViewById(R.id.UserNameID);
        Email = findViewById(R.id.EmailAddressID);
        Password = findViewById(R.id.PassSignUpID);
        Location = findViewById(R.id.LocationID);
        LinkLogin = findViewById(R.id.link_login);
        progressBarSignUp = findViewById(R.id.signUpProgressBarID);

        mAuth = FirebaseAuth.getInstance();


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });



        LinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,Login.class);
                startActivity(intent);
            }
        });

    }

    public void userRegister(){

        userName = UserName.getText().toString();
        email = Email.getText().toString();
        password = Password.getText().toString();
        location = Location.getText().toString();

        if(email.isEmpty()) {
            Email.setError("Enter an email address");
            Email.requestFocus();
        return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Enter a valid email address");
            Email.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            Password.setError("Enter a password");
            Password.requestFocus();
            return;
        }

        if(password.length()<6) {
            Password.setError("Minimum length of a password should be 6");
            Password.requestFocus();
            return;
        }

        progressBarSignUp.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBarSignUp.setVisibility(View.GONE);

                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Register is Successfull",Toast.LENGTH_SHORT).show();
                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User is already Registered",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Error: "+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }

}
