package com.abhisheksingh.ifbservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 26-04-2018.
 */

public class DatabaseHelperTask extends SQLiteOpenHelper {

    public static final String DATABASE_NAME =  "IFBService.db";
    public static final String TABLE_NAME = "task";
    public static final String id = "id";
    public static final String name = "task_name";
    public static final String expertise = "expertise";
    public static final int startTime = 0;
    public static final int endTime = 0;
    public static final int costperHr = 0;

    public DatabaseHelperTask(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, task_name TEXT, expertise TEXT , startTime INTEGER, endTime INTEGER, rate INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String task_name, String exp, int st, int et, int rate)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name, task_name);
        contentValues.put(expertise, exp);
        contentValues.put(String.valueOf(startTime), st);
        contentValues.put(String.valueOf(endTime), et);
        contentValues.put(String.valueOf(costperHr), rate);
        long result = db.insert(TABLE_NAME , null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
