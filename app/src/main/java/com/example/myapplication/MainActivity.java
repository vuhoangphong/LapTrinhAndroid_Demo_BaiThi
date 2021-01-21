package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<NhanVienModel> listNV = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.lstNhanVien);
        ConnectDB db=new ConnectDB(getApplicationContext()); // connect data base

        listNV  = db.getListNV(); // get list

        mainAdapter arrayAdapter = new mainAdapter(); // set adapter
        list.setAdapter(arrayAdapter); // set adapter vào list
    }
    //khởi tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    //chức năng item trong menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.Insert) {
            //sử dụng startActivityForResult để lấy kết quả từ Insert trả về, requestCode từ Main -> Insert là 1
            final int result = 1;
            startActivityForResult(new Intent(this, Insert.class), result);

            /*
             * //hoặc viết theo cách sau:
             *  Intent intent = new Intent(this,InsertActivity.class);
             * startActivityForResult(intent, result);
             *
             * */
        }
        return true;
    }


    // adapter
    public class mainAdapter extends ArrayAdapter<NhanVienModel>{
        public mainAdapter(){
            super(MainActivity.this, android.R.layout.simple_list_item_1,listNV);
        }

        public mainAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            if(row == null){
                LayoutInflater inflater = getLayoutInflater();
                row = inflater.inflate(R.layout.row,null); // layout row
            }
            NhanVienModel nv = listNV.get(position);
            ((TextView)row.findViewById(R.id.textView8)).setText(nv.getHoTen());  // set ho ten
            ((TextView)row.findViewById(R.id.textView9)).setText(nv.getLuong()); // set lương
            return row;
        }
    }


}