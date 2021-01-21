
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Button btnAddNV = (Button)findViewById(R.id.save);
        AddNV(btnAddNV);

    }
    public void AddNV(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tenNV = (EditText)findViewById(R.id.tenNv);
                EditText luong = (EditText)findViewById(R.id.luong);

                ConnectDB db=new ConnectDB(getApplicationContext());
                db.addNV(new NhanVienModel(-1,tenNV.getText().toString(),"TP HCM","Tan Phu",luong.getText().toString()));
            }
        });
    }

    public void HideButton(View view){
        Button btnEdit = (Button)findViewById(R.id.edit);
        Button btnDelete = (Button)findViewById(R.id.xoa);
        Button btnSave = (Button)findViewById(R.id.save);

        btnEdit.setVisibility(View.VISIBLE);
        btnDelete.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.INVISIBLE);
    }

}