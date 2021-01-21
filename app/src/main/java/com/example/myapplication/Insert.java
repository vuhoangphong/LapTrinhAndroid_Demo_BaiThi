
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Insert extends AppCompatActivity {
    Spinner sp1,sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Button btnAddNV = (Button)findViewById(R.id.save);
       sp1= findViewById(R.id.QuanHuyen);
       sp = findViewById(R.id.TinhThanh);



        // sự kiện spinner tỉnh thành thay đổi
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String arrTinh[] = null;
                if(position == 0) //  theo array tỉnh trong strings.xml (nhớ theo thứ tự string arr trong string xml nha!!!) ;
                {
                    arrTinh=  getResources().getStringArray(R.array.HN); // khi == 0 thi show các quận hà nội
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>( getApplicationContext(),android.R.layout.simple_spinner_item,arrTinh);
                    sp1.setAdapter(adapter);
                }
                if(position == 1)
                {
                    arrTinh = getResources().getStringArray(R.array.TPHCM); //khi == 1 thi show các quận TPHCM
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>( getApplicationContext(),android.R.layout.simple_spinner_item,arrTinh);
                    sp1.setAdapter(adapter);
                }
                //có bao nhiêu tỉnh code bấy nhiêu if (:D)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //goi ham them nhanvien
        AddNV(btnAddNV);
    }
    //them nhan vien
    public void AddNV(Button btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tenNV = (EditText)findViewById(R.id.tenNv);
                EditText luong = (EditText)findViewById(R.id.luong);
                ConnectDB db=new ConnectDB(getApplicationContext());
                db.addNV(new NhanVienModel(tenNV.getText().toString(),sp.getSelectedItem().toString(),sp1.getSelectedItem().toString(),luong.getText().toString()));
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