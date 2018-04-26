package com.abhisheksingh.ifbservices;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 26-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME =  "IFBService.db";
    public static final String TABLE_NAME = "login_credentials";
    public static final String username = "username";
    public static final String password = "password";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(username TEXT PRIMARY KEY , password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String uname, String pwd)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(username,uname);
        contentValues.put(password,pwd);
        long result = db.insert(TABLE_NAME , null , contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
}
