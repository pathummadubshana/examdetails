package com.testing.examdetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhandler extends SQLiteOpenHelper {



    //crate databse
    public DBhandler( Context context,  String dbname,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }
//crate table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE class(name varchar(20),subject varchar(10),grade varchar(5),marks varchar(5))");



    }
//drop the table when the version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists class");
        onCreate(db);

    }
    //to save tha user data

    public  long saveDate(String name,String subject,String grade, String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("subject",subject);
        cv.put("grade",grade);
        cv.put("marks",marks);

      long recordID=  db.insert("class",null,cv);

      return recordID;

    }
    //to view tha data
    public  String getData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from class",null);
        String output="";
        while (cursor.moveToNext()){
            String name=cursor.getString(0);
            String subject=cursor.getString(1);
            String grade=cursor.getString(2);
            String mark = cursor.getString(3);

            output= output + name + "_" + subject + "_" + grade + "_" + mark +"\n";
        }

        return  output;
    }
}
