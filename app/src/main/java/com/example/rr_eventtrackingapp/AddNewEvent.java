package com.example.rr_eventtrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

// This file allows for a new event to be added

public class AddNewEvent extends eventTrackingGrid {

    EditText eventName, eventDate , eventLocation, eventTime;
    Button saveEvent;

    // To resolve this issue with the database:
    // https://stackoverflow.com/questions/17480426/dbhelper-can-not-resolve-to-variable
    private eventDatabase eventDatabase;
    private BreakIterator Pass;

    // Help with this section to connect to database provided by:
    // https://abhiandroid.com/database/sqlite
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tracking_grid);

        eventName = (EditText) findViewById(R.id.editName);
        eventDate = (EditText) findViewById(R.id.editDate);
        eventLocation = (EditText) findViewById(R.id.editLocation);
        eventTime = (EditText) findViewById(R.id.editTime);

        eventDatabase = eventDatabase.getInstance(getApplicationContext());

        // https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
        saveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Gets data from text fields
                String editName = eventName.getText().toString();
                String editDate = eventDate.getText().toString();
                String editLocation = eventLocation.getText().toString();
                String editTime = eventTime.getText().toString();

                // Helps validate if the text fields are empty
                if (editName.isEmpty() && editDate.isEmpty() && editLocation.isEmpty() && editTime.isEmpty()) {
                    Toast.makeText(AddNewEvent.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add new event to database
                eventDatabase.addNewEvent(editName, editDate, editLocation, editTime);

                // Displays Toast message to confirm event was added
                Toast.makeText(AddNewEvent.this, "Event has been added.", Toast.LENGTH_SHORT).show();
                eventName.setText("");
                eventDate.setText("");
                eventLocation.setText("");
                eventTime.setText("");

                Intent intent = new Intent(AddNewEvent.this, eventTrackingGrid.class);


            }
        });
    }


}