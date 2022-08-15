package com.example.rr_eventtrackingapp;

// Database created for Event Tracking App
// Help with this code provided via Zybooks
// And GeeksforGeeks: https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class eventDatabase extends SQLiteOpenHelper {

    // Variables for Database
    // Database name
    private static final String DB_NAME = "eventdatabase";

    // Database version
    private static final int DB_VERSION = 1;

    // Table name
    private static final String TABLE_NAME = "Events";

    // Name column
    private static final String NAME_COL = "Name";

    // Date column.
    private static final String DATE_COL = "Date";

    // Location column.
    private static final String LOCATION_COL = "Location";

    // Time column.
    private static final String TIME_COL = "Time";

    // Instance
    private static eventDatabase getInstance;

    // https://www.androiddesignpatterns.com/2012/05/correctly-managing-your-sqlite-database.html
    public static eventDatabase getInstance(Context context) {
        if (getInstance == null) {
            getInstance = new eventDatabase(context.getApplicationContext());
        }
        return getInstance;
    }

    // Creating a constructor for our database handler.
    public eventDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    // This method creates a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + NAME_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DATE_COL + " TEXT,"
                + LOCATION_COL + " TEXT,"
                + TIME_COL + " TEXT)";

        db.execSQL(query);
    }

    // Adding new event to database
    public void addNewEvent(String editName, String editDate, String editLocation, String editTime) {

        // Get writeabale database object
        SQLiteDatabase db = this.getWritableDatabase();

        // ContentValues object holds table columns and data to insert into table
        ContentValues values = new ContentValues();

        // Passing values
        values.put(NAME_COL, editName);
        values.put(DATE_COL, editDate);
        values.put(LOCATION_COL, editLocation);
        values.put(TIME_COL, editTime);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    // Code from: https://www.tutorialspoint.com/android/android_sqlite_database.htm
    // Grabs data
    public Cursor getData(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Events where name="+name+"", null );
        return res;
    }

    // Updates Events
    public boolean updateEvents (String name, String date, String location, String time) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("Name", name);
        contentValues.put("Date", date);
        contentValues.put("Location", location);
        contentValues.put("Time", time);

        db.update("Events", contentValues, "name = ? ", new String[] { Integer.toString(Integer.parseInt(name)) } );
        return true;
    }

    // Deletes Events
    public Integer deleteEvent (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Events",
                "name = ? ",
                new String[] { Integer.toString(Integer.parseInt(name)) });
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Checks to see if table exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

