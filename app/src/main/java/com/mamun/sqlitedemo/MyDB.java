package com.mamun.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDB extends SQLiteOpenHelper {

    private static String DBNAME = "mydatabase";
    private static int VERSION = 1;
    private static String TABLENAME = "muktizodda";
    private static String ID = "_id";
    private static String NAME = "name";
    private static String AGE = "age";

    public MyDB(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLENAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +NAME+" TEXT, "+AGE+" INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(db);
    }
    public boolean insertData(String name, String age){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        database.insert(TABLENAME, null, contentValues);
        return true;
    }
    public ArrayList <Model> getAllData(){
        ArrayList<Model> arrayList = new ArrayList<Model>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM "+TABLENAME,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            arrayList.add(new Model(cursor.getString(cursor.getColumnIndex(ID))
                    ,cursor.getString(cursor.getColumnIndex(NAME))
                    ,cursor.getString(cursor.getColumnIndex(AGE))));
            cursor.moveToNext();
        }

        return arrayList;
    }
}
