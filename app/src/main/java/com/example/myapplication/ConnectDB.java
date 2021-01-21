package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    //get nhân viên
    public List<NhanVienModel> getListNV (){
        List<NhanVienModel> list = new ArrayList<NhanVienModel>();
        String queryString = "SELECT * FROM  NhanVien";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                String hoTen = cursor.getString(1);
                String TinhThanh = cursor.getString(2);
                String QuanHuyen = cursor.getString(3);
                String Luong =cursor.getString(4);
                NhanVienModel  nv = new NhanVienModel(id,hoTen,TinhThanh,QuanHuyen,Luong);
                list.add(nv);
            }while (cursor.moveToNext());
        }else{}
        cursor.close();
        db.close();
        return list;
    }


}
