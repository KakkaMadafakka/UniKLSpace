package com.example.phobo.uniklspace.Timetable;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.phobo.uniklspace.DbHelper.TimetableDBHelper;
import com.example.phobo.uniklspace.Home.MainActivity;
import com.example.phobo.uniklspace.Model.ClassTimetable;
import com.example.phobo.uniklspace.R;

import javax.security.auth.Subject;

/**
 * Created by phobo on 19-Feb-18.
 */

public class AddRecordActivity extends AppCompatActivity {

    private EditText etsubject, etclass, etlecture;
    private ImageButton startime, endtime;
    private Button saveadd;
    private TextView start_tv, end_tv;
    private static final int TIME_DIALOG_START = 1;
    private static final int TIME_DIALOG_END = 2;
    private int hours, mins;
    private TimetableDBHelper dbHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        //init
        start_tv =findViewById(R.id.tv_classstart);
        end_tv =findViewById(R.id.tv_classend);
        etsubject = findViewById(R.id.subject_update);
        etclass = findViewById(R.id.class_location_update);
        etlecture = findViewById(R.id.lecture_update);
        saveadd =findViewById(R.id.updateUserButton);


        //listen to add button click
        saveadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                savePerson();
            }
        });

    }


    public void showTimePickerStart(View v) {
        showDialog(TIME_DIALOG_START);
    }
    public void showTimePickerEnd(View v) {
        showDialog(TIME_DIALOG_END);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        super.onCreateDialog(id);

        switch (id) {
            case TIME_DIALOG_START:
                return new TimePickerDialog(this, timeSetListenerstart, hours,mins, false);
            case TIME_DIALOG_END:
                return new TimePickerDialog(this, timeSetListenerend, hours,mins, false);
        }
        return null;
    }
    private TimePickerDialog.OnTimeSetListener timeSetListenerstart =
            new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker arg0, int pHours, int  pMins) {
                    hours = pHours;
                    mins = pMins;
                    updateTimeDisplayStart();
                }

            };
    private TimePickerDialog.OnTimeSetListener timeSetListenerend =
            new TimePickerDialog.OnTimeSetListener() {

                @Override
                public void onTimeSet(TimePicker arg0, int pHours, int  pMins) {
                    hours = pHours;
                    mins = pMins;
                    updateTimeDisplayEnd();
                }

            };
    private void updateTimeDisplayStart() {
        // Month is 0 based so add 1
        start_tv.setText(String.format("%02d:%02d", hours,mins));
    }
    private void updateTimeDisplayEnd() {
        // Month is 0 based so add 1
        end_tv.setText(String.format("%02d:%02d", hours,mins));
    }

    /*>>>SavingInfoHere<<<*/

    private void savePerson(){
        String day = etsubject.getText().toString().trim();
        String subject = etsubject.getText().toString().trim();
        String classs = etclass.getText().toString().trim();
        String lecture = etlecture.getText().toString().trim();
        String timestart = start_tv.getText().toString().trim();
        String timeend = end_tv.getText().toString().trim();
        dbHelper = new TimetableDBHelper(this);


        //dbHelper = new PersonDBHelper(this);

        if(subject.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Please enter your subject", Toast.LENGTH_SHORT).show();
        }

        if(classs.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Please enter your class location", Toast.LENGTH_SHORT).show();
        }

        if(lecture.isEmpty()){
            //error name is empty
            Toast.makeText(this, "Please enter the lecture's name", Toast.LENGTH_SHORT).show();
        }

        //create new person
        ClassTimetable classTimetable = new ClassTimetable(subject, classs, lecture, timestart,timeend, day);
        dbHelper.saveClasses(classTimetable);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
        goBackHome();

    }

    private void goBackHome(){
        startActivity(new Intent(AddRecordActivity.this, MainActivity.class));
    }
}
