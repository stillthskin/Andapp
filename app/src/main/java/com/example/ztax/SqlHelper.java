package com.example.ztax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {
    private static final String databaseName = "mydb.db";

    public SqlHelper(@Nullable Context context) {
        super(context, "mydb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (Email TEXT PRIMARY KEY, Username TEXT, Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");

    }
    public Boolean insertUsers(String email, String username, String pass){
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("Email", email);
        content.put("Username", username);
        content.put("Password",pass);
        long res = mydb.insert("users",null,content);

        return res != -1;
    }

    public Boolean checkuname(String username){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cusor = mydb.rawQuery("SELECT * FROM users WHERE usename=?", new String[] {username});
        return cusor.getCount() > 0;

    }
    public Boolean checkunamepassword(String username, String password){
        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cusor = mydb.rawQuery("SELECT * FROM users WHERE username=?and password=?", new String[] {username,password});
        return cusor.getCount() > 0;

    }
}
