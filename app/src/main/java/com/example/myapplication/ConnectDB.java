package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnectDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "NhanVien.sqlite";
    private static final int SCHEMA_VERSION =1 ;

    public  ConnectDB(Context context){
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);

    }
    //tao database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE NhanVien ( ID    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, HoTen    TEXT, TinhThanh    TEXT, QuanHuyen    TEXT , Luong    TEXT )"
        );
    }
    //xoa database va tao lai neu ton tai
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS NhanVien");
        onCreate(db);
    }
    //them nhan vien
    public boolean addNV(NhanVienModel nv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("HoTen",nv.getHoTen());
        contentValues.put("TinhThanh",nv.getTinhThanh());
        contentValues.put("QuanHuyen", nv.getQuanHuyen());
        contentValues.put("Luong",nv.getLuong());
        long inserted = db.insert("NhanVien",null,contentValues);
        if(inserted == -1 )
            return false;
        else
            return true;
    }


}
