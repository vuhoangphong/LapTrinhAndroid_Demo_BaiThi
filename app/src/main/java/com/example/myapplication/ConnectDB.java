package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnectDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "NhanVien.sqlite";
    private static final int SCHEMA_VERSION =1 ;

    public  ConnectDB(Context context){
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE NhanVien ( ID    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, HoTen    TEXT, TinhThanh    TEXT, QuanHuyen    TEXT , Luong    TEXT )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS NhanVien");
        onCreate(db);
    }

    
}