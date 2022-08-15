package com.example.rr_eventtrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// This file is for the event tracking grid and focuses on onClicks to pass to other files for buttons

public class eventTrackingGrid extends AppCompatActivity {

    Button gridNotifButton, gridAddButton, gridEditButton, gridDeleteButton, gridSmsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tracking_grid);

        gridNotifButton = (Button) findViewById(R.id.notificationButton);
        gridAddButton = (Button) findViewById(R.id.addEventButton);
        gridEditButton = (Button) findViewById(R.id.logInButton);
        gridDeleteButton = (Button) findViewById(R.id.signUpButton);
        gridSmsButton = (Button) findViewById(R.id.logInButton);

        // This onClick is for upcoming event, or the notification button in the upper right corner
        gridNotifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(eventTrackingGrid.this,
                        UpcomingEvent.class);
                startActivity(intent);

            }
        });

        // All of these onClick functions cause app to crash when run in Emulator


//
//        gridAddButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(eventTrackingGrid.this,
//                        AddNewEvent.class);
//                startActivity(intent);
//
//            }
//        });
//
//        gridEditButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(eventTrackingGrid.this,
//                        editEvent.class);
//                startActivity(intent);
//
//            }
//        });

        // Did not understand how to get the delete button to delete a row with the database
//        gridDeleteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(eventTrackingGrid.this,
//                        eventDatabase.class);
//                startActivity(intent);
//
//            }
//        });
//
//        gridSmsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(eventTrackingGrid.this,
//                        UserPermissions.class);
//                startActivity(intent);
//
//            }
//        });



    }
}