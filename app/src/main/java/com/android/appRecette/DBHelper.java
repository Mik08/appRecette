package com.android.appRecette;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "recette.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase madb) {

        madb.execSQL("create Table user( id Integer primary key AUTOINCREMENT , pseudo Text , mail Text, password Text , image Text ,titre_recette Text, list_ingredient Text ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase madb, int oldVersion, int newVersion) {
        madb.execSQL("drop Table if exists user");

    }

    public Boolean insertData( String pseudo,String mail,  String password) {

        SQLiteDatabase madb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("pseudo", pseudo);
        contentValues.put("mail", mail);
        contentValues.put("password", password);
        Long result = madb.insert("user", null, contentValues);
        if (result == -1) {
            //retourne une errreur
            return false;
        } else {
            return true;
        }

    }

    public Boolean checkpseudoMail(String pseudo, String mail) {
        SQLiteDatabase madb = this.getWritableDatabase();
        Cursor cursor = madb.rawQuery("select * from user where pseudo = ? and mail = ?", new String[]{pseudo, mail});
        if (cursor.getCount() > 0) {
            //cela veut dire qu'il esxiste
            return true;
        } else {
            return false;
        }


    }

    public Boolean checkPseudoPassword(String pseudo, String password) {
        SQLiteDatabase madb = this.getWritableDatabase();
        Cursor cursor = madb.rawQuery("select * from user where pseudo = ? and password = ?", new String[]{pseudo, password});
        if (cursor.getCount() > 0) {
            return true;

        } else {
            return false;
        }

    }
}