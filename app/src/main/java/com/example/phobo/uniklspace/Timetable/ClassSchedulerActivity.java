package com.example.phobo.uniklspace.Timetable;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.phobo.uniklspace.R;

public class ClassSchedulerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DBHelper dbhelper = new DBHelper(this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.close();
        
    }
}