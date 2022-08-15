package com.example.rr_eventtrackingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Help with this code from: https://www.geeksforgeeks.org/how-to-update-data-to-sqlite-database-in-android/
// This file allows for an event to be edited

public class editEvent extends eventTrackingGrid {

    EditText editEventName, editEventDate, editEventLocation, editEventTime;
    Button saveEditEvent;
    String editedName, editedDate, editedLocation, editedTime;

    private eventDatabase eventDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);

        editEventName = findViewById(R.id.editName);
        editEventDate = findViewById(R.id.editDate);
        editEventLocation = findViewById(R.id.editLocation);
        editEventTime = findViewById(R.id.editTime);
        saveEditEvent = findViewById(R.id.saveEventButton);

        eventDatabase = eventDatabase.getInstance(getApplicationContext());


        editedName = getIntent().getStringExtra("Name");
        editedDate = getIntent().getStringExtra("Date");
        editedLocation = getIntent().getStringExtra("Location");
        editedTime = getIntent().getStringExtra("Time");

        // Setting data to edit text
        editEventName.setText(editedName);
        editEventDate.setText(editedDate);
        editEventLocation.setText(editedLocation);
        editEventTime.setText(editedTime);

        // Adding on click listener for updated event
        saveEditEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // This updates the event based on data passed to it
                eventDatabase.updateEvents(editedName, editEventDate.getText().toString(), editEventLocation.getText().toString(), editEventTime.getText().toString());

                // Displays Toast message to confirm event was updated
                Toast.makeText(editEvent.this, "Event Updated..", Toast.LENGTH_SHORT).show();

                 Intent intent = new Intent(editEvent.this, eventTrackingGrid.class);
            }
        });
    }
}
