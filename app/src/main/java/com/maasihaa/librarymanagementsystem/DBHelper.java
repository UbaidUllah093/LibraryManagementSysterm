package com.maasihaa.librarymanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Library.db";
    public static final String CONTACTS_TABLE_NAME = "book";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "book_name";
    public static final String CONTACTS_COLUMN_AUTHOR = "author_name";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table book " +
                        "(id integer primary key, book_name text,author_name text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS book");
        onCreate(db);
    }

    public boolean insertBook (String book_name, String author_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("book_name", book_name);
        contentValues.put("author_name", author_name);
        db.insert("book", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from book where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }


    public Integer deleteBooks (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("book",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllBooks() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from book", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add("Book:  " + res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)) + "     Author:  " + res.getString(res.getColumnIndex(CONTACTS_COLUMN_AUTHOR)));
            res.moveToNext();
        }
        return array_list;
    }
}