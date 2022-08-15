package com.example.rr_eventtrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// This file focuses on allowing user to log in
// Help with this code provided by:
// https://www.tutorialspoint.com/android/android_login_screen.htm

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button logIn, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditTexts for Email and Password
        email = (EditText) findViewById(R.id.editTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextPassword);

        // Buttons for Log In and Sign Up
        logIn = (Button) findViewById(R.id.logInButton);
        signUp = (Button) findViewById(R.id.signUpButton);

        // Help with these section(s) provided by:
        // https://www.codebrainer.com/blog/registration-form-in-android-check-email-is-valid-is-empty
        // https://programmerknows.com/login-and-registration-form-in-android-studio-code/

        // logIn
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        eventTrackingGrid.class);
                startActivity(intent);
            }
        });

        // signUp
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        SignUpActivity.class);
                startActivity(intent);

            }
        });


    }
}