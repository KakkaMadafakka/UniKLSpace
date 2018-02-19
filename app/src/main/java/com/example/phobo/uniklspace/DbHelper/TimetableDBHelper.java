package com.example.phobo.uniklspace.DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.phobo.uniklspace.Model.ClassTimetable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by phobo on 19-Feb-18.
 */

public class TimetableDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "timetable.db";
    private static final int DATABASE_VERSION = 3 ;
    public static final String TABLE_NAME = "classes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_SUBJECT = "subject";
    public static final String COLUMN_TIME_START = "timestart";
    public static final String COLUMN_TIME_END = "timeend";
    public static final String COLUMN_CLASS = "class";
    public static final String COLUMN_LECTURE = "lecture";



    public TimetableDBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DAY + " TEXT NOT NULL, " +
                COLUMN_SUBJECT + " TEXT NOT NULL, " +
                COLUMN_TIME_START + " VARCHAR NOT NULL, " +
                COLUMN_TIME_END + " VARCHAR NOT NULL, " +
                COLUMN_CLASS + " VARCHAR NOT NULL, " +
                COLUMN_LECTURE + " TEXT NOT NULL);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    /**create record**/
    public void saveClasses(ClassTimetable classTimetable) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DAY, classTimetable.getDay());
        values.put(COLUMN_SUBJECT, classTimetable.getSubject());
        values.put(COLUMN_TIME_START, classTimetable.getTimestart());
        values.put(COLUMN_TIME_END, classTimetable.getTimeend());
        values.put(COLUMN_CLASS, classTimetable.getClasss());
        values.put(COLUMN_LECTURE, classTimetable.getLecture()  );


        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    /**Query records, give options to filter results**/
    public List<ClassTimetable> classesList(String filter) {
        String query;
        if(filter.equals("")){
            //regular query
            query = "SELECT  * FROM " + TABLE_NAME;
        }else{
            //filter results by filter option provided
            query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ filter;
        }

        List<ClassTimetable> classesLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ClassTimetable classTimetable;

        if (cursor.moveToFirst()) {
            do {
                classTimetable = new ClassTimetable();

                classTimetable.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                classTimetable.setDay(cursor.getString(cursor.getColumnIndex(COLUMN_DAY)));
                classTimetable.setSubject(cursor.getString(cursor.getColumnIndex(COLUMN_SUBJECT)));
                classTimetable.setTimestart(cursor.getString(cursor.getColumnIndex(COLUMN_TIME_START)));
                classTimetable.setTimeend(cursor.getString(cursor.getColumnIndex(COLUMN_TIME_END)));
                classTimetable.setClasss(cursor.getString(cursor.getColumnIndex(COLUMN_CLASS)));
                classTimetable.setLecture(cursor.getString(cursor.getColumnIndex(COLUMN_LECTURE)));
                classesLinkedList.add(classTimetable);
            } while (cursor.moveToNext());
        }

        return classesLinkedList;
    }

/*    *//**Query only 1 record**//*
    public ClassTimetable getPerson(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE _id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        Person receivedPerson = new Person();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedPerson.setName(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_NAME)));
            receivedPerson.setAge(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_AGE)));
            receivedPerson.setOccupation(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_OCCUPATION)));
            receivedPerson.setImage(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_IMAGE)));
        }



        return receivedPerson;


    }*/
}
