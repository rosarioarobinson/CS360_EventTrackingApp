package com.example.rr_eventtrackingapp;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

// This file is opened when onClick is pressed in eventTrackingGrid
// This file allows for the pop up functionality to display on screen to notify user
// of an upcoming event

public class UpcomingEvent extends AppCompatActivity {
    Button showPopupBtn, closePopupBtn;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tracking_grid);

        showPopupBtn = (Button) findViewById(R.id.notificationButton);

        // Help with pop up window code provided by: https://www.thecrazyprogrammer.com/2017/07/android-popupwindow-example.html
        showPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflater = (LayoutInflater) UpcomingEvent.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.activity_upcoming_event,null);

                closePopupBtn = (Button) customView.findViewById(R.id.closeButton);

                // Creates the pop up window
                popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

                // Displays the pop up window
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // Closes the pop up window using the close button
                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });
    }
}