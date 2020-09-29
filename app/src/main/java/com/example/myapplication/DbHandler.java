package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHandler extends SQLiteOpenHelper {
    public static final String DBName = "test.db";
    public static final String Table ="User";
    public DbHandler( Context context){
        super(context, DBName, null, 1);
    }
    // raw data base created for example
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TableName = "CREATE TABLE "+Table+" (ID INTEGER PRIMARY KEY AUTOINCREMENT ,USERNAME TEXT,PASSWORD TEXT);";
        sqLiteDatabase.execSQL(TableName);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    // add information
    public boolean addInfo(String username,String password){
        SQLiteDatabase addDb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME",username);
        contentValues.put("PASSWORD",password);
        long state = addDb.insert(DBName,null,contentValues);
        if (state == -1){
            return false;
        }
        return true;
    }
}
