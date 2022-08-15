package com.example.rr_eventtrackingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


// This file focuses on allowing user to sign up for app
// Help with this code provided by:
// https://www.tutorialspoint.com/android/android_login_screen.htm
// https://programmerknows.com/login-and-registration-form-in-android-studio-code/

public class SignUpActivity extends MainActivity {

    EditText enterName, enterEmail, enterUsername, enterPassword;
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // TextViews for Name, Email, Username, and Password
        enterName = (EditText) findViewById(R.id.signUpName);
        enterEmail = (EditText) findViewById(R.id.editSignUpEmailAddress);
        enterUsername = (EditText) findViewById(R.id.signUpUsername);
        enterPassword = (EditText) findViewById(R.id.editSignUpPassword);

        // Button to create account
        createAccount = (Button) findViewById(R.id.createAccountButton);

        // Help with these section(s) provided by:
        // https://www.codebrainer.com/blog/registration-form-in-android-check-email-is-valid-is-empty
        // https://programmerknows.com/login-and-registration-form-in-android-studio-code/

        // Create Account Click
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });

    }
}